package com.Xr.Management.service;

import java.util.List;

import com.Xr.Management.dto.ProjectAssignmentResponse;
import com.Xr.Management.enums.Role;
import com.Xr.Management.model.ProjectAssignment;


public interface ProjectAssignmentServiceImpl {

	ProjectAssignmentResponse createAssignment(Long userId, Long projectId, Role role);

	ProjectAssignmentResponse updateAssignment(Long id, Long userId, Long projectId, Role role);

	List<ProjectAssignment> getAssignments();

	List<ProjectAssignmentResponse> getProjectAssignments(int pageNumber, int pageSize);

}
