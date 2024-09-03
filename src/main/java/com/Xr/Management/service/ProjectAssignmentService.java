package com.Xr.Management.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Xr.Management.dto.ProjectAssignmentRequest;
import com.Xr.Management.dto.ProjectAssignmentResponse;
import com.Xr.Management.enums.Role;
import com.Xr.Management.exception.UserException;
import com.Xr.Management.mapper.ProjectAssignmentMapper;
import com.Xr.Management.model.Project;
import com.Xr.Management.model.ProjectAssignment;
import com.Xr.Management.model.User;
import com.Xr.Management.repository.ProjectAssignmentRepository;
import com.Xr.Management.repository.ProjectRepository;
import com.Xr.Management.repository.UserRepository;
import com.Xr.Management.utils.Messages;

@Service
public class ProjectAssignmentService implements ProjectAssignmentServiceImpl {

	@Autowired
	ProjectAssignmentRepository projectAssignmentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ProjectAssignmentMapper projectAssignmentMapper;

	@Override
	public ProjectAssignmentResponse createAssignment(Long userId, Long projectId, Role role) {

		User user = userRepository.findById(userId);

		Project project = (Project) projectRepository.findById(projectId);

		ProjectAssignmentRequest projectAssignmentRequest = ProjectAssignmentRequest.builder().userId(user)
				.projectId(project).role(role).build();

		ProjectAssignment projectAssignment = projectAssignmentMapper.toEntity(projectAssignmentRequest);
		projectAssignment.setDeleted(false);
		ProjectAssignment saveAssignment = projectAssignmentRepository.save(projectAssignment);

		return projectAssignmentMapper.toDto(saveAssignment);

	}

	@Override
	public ProjectAssignmentResponse updateAssignment(Long id, Long userId, Long projectId, Role role) {

		ProjectAssignment projectAssignment = (ProjectAssignment) projectAssignmentRepository.findById(id);

		User user = userRepository.findById(userId);

		Project project = (Project) projectRepository.findById(projectId);

		ProjectAssignmentRequest projectAssignmentRequest = ProjectAssignmentRequest.builder().userId(user)
				.projectId(project).role(role).build();

		projectAssignmentMapper.update(projectAssignmentRequest, projectAssignment);

		ProjectAssignment updateAssignment = projectAssignmentRepository.save(projectAssignment);

		return projectAssignmentMapper.toDto(updateAssignment);

	}

	@Override
	public List<ProjectAssignment> getAssignments() {
		return projectAssignmentRepository.findAll();
	}

	@Override
	public List<ProjectAssignmentResponse> getProjectAssignments(int pageNumber, int pageSize) {
		if (pageNumber < 1 || pageSize < 1) {
			throw new UserException(Messages.PAGE_NUMBER_AND_PAGE_SIZE);
		}
//		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

		Page<ProjectAssignment> projectAssignment = projectAssignmentRepository.findByDeletedFalse(pageable);
		List<ProjectAssignmentResponse> projectData = ((Collection<ProjectAssignment>) projectAssignment).stream().map(projectAssignmentMapper::toDto)
				.collect(Collectors.toList());
		return projectData;
	}

}
