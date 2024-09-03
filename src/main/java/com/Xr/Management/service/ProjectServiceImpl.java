package com.Xr.Management.service;

import java.util.List;

import com.Xr.Management.dto.ProjectResponse;
import com.Xr.Management.enums.Category;
import com.Xr.Management.enums.Platform;
import com.Xr.Management.enums.Status;
import com.Xr.Management.enums.Technology;
import com.Xr.Management.model.Project;


public interface ProjectServiceImpl {

	ProjectResponse createProject(String name, String description, Double amount, String startDate, String endDate,
			String holdDate, List<Technology> technology, Category category, Platform platform, Status status,
			Integer totalMilestone, Integer currentMilestone, String clientName, Double amountReceived);

	ProjectResponse updateProject(Long id, String name, String description, Double amount, String startDate,
			String endDate, String holdDate, List<Technology> technology, Category category, Platform platform,
			Status status);

	List<ProjectResponse> getProjectData(int pageNumber, int pageSize);

	void softDeleteUser(Long id);

	List<Project> getProjectDetails();

	List<ProjectResponse> getProjectData();

}
