package com.Xr.Management.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Xr.Management.dto.ProjectRequest;
import com.Xr.Management.dto.ProjectResponse;
import com.Xr.Management.enums.Category;
import com.Xr.Management.enums.Platform;
import com.Xr.Management.enums.Status;
import com.Xr.Management.enums.Technology;
import com.Xr.Management.exception.UserException;
import com.Xr.Management.mapper.ProjectsMapper;
import com.Xr.Management.model.Project;
import com.Xr.Management.repository.ProjectRepository;
import com.Xr.Management.utils.Messages;
import com.Xr.Management.utils.Utils;


@Service
public class ProjectService implements ProjectServiceImpl {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ProjectsMapper projectsMapper;

	@Override
	public ProjectResponse createProject(String name, String description, Double amount, String startDate,
			String endDate, String holdDate, List<Technology> technology, Category category, Platform platform,
			Status status, Integer totalMilestone, Integer currentMilestone, String clientName, Double amountReceived) {

		Long startDateInMillis = convertToMillisecondsIfNeeded(startDate);
		Long endDateInMillis = convertToMillisecondsIfNeeded(endDate);
		Long holdDateInMillis = convertToMillisecondsIfNeeded(holdDate);

		ProjectRequest projectRequest = ProjectRequest.builder().name(name).description(description).amount(amount)
				.startDate(startDateInMillis).endDate(endDateInMillis).holdDate(holdDateInMillis).technology(technology)
				.category(category).platform(platform).status(status).totalMilestone(totalMilestone)
				.currentMilestone(currentMilestone).clientName(clientName).amountReceived(amountReceived).build();

		Project project = projectsMapper.toEntity(projectRequest);
		project.setDeleted(false);
		Project saveProject = projectRepository.save(project);

		return projectsMapper.toDto(saveProject);

	}

	@Override
	public ProjectResponse updateProject(Long id, String name, String description, Double amount, String startDate,
			String endDate, String holdDate, List<Technology> technology, Category category, Platform platform,
			Status status) {

		Long startDateInMillis = convertToMillisecondsIfNeeded(startDate);
		Long endDateInMillis = convertToMillisecondsIfNeeded(endDate);
		Long holdDateInMillis = convertToMillisecondsIfNeeded(holdDate);

		ProjectRequest projectRequest = ProjectRequest.builder().name(name).description(description).amount(amount)
				.startDate(startDateInMillis).endDate(endDateInMillis).holdDate(holdDateInMillis).technology(technology)
				.category(category).platform(platform).status(status).build();

		Project project = ((Optional<Project>) projectRepository.findById(id)).orElseThrow(() -> new UserException(Messages.USER_NOT_FOUND));

		projectsMapper.update(projectRequest, project);

		Project updateProject = projectRepository.save(project);

		return projectsMapper.toDto(updateProject);
	}

	private Long convertToMillisecondsIfNeeded(String date) {
		if (date != null) {
			if (date.length() != 13) {
				return Utils.convertDateStringToMilliseconds(date);
			} else {
				try {
					return Long.parseLong(date);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(
							"Invalid date format: must be either a date string or milliseconds.");
				}
			}
		}
		return null;
	}

	@Override
	public List<ProjectResponse> getProjectData(int pageNumber, int pageSize) {
	    if (pageNumber < 1 || pageSize < 1) {
	        throw new UserException(Messages.PAGE_NUMBER_AND_PAGE_SIZE);
	    }
	    Pageable pageable = new PageRequest(pageNumber - 1, pageSize);
	    Page<Project> projectPage = projectRepository.findByDeletedFalse(pageable);
	    List<Project> projects = projectPage.getContent(); // Extract the list of projects
	    List<ProjectResponse> projectData = projects.stream()
	                                                .map(projectsMapper::toDto)
	                                                .collect(Collectors.toList());
	    return projectData;
	}

	

	@Override
	public void softDeleteUser(Long id) {
		Project project = projectRepository.findByIdAndDeletedFalse(id)
				.orElseThrow(() -> new UserException(Messages.USER_NOT_FOUND_OR_ALREADY_DELETED));
		project.setDeleted(true);
		projectRepository.save(project);
	}

	@Override
	public List<Project> getProjectDetails() {
		return projectRepository.findAll();
	}

	@Override
	public List<ProjectResponse> getProjectData() {
		List<Project> projects = projectRepository.findByDeletedFalse();
		List<ProjectResponse> projectData = projects.stream().map(projectsMapper::toDto).collect(Collectors.toList());
		return projectData;
	}

}
