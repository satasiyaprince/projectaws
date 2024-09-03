package com.Xr.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Xr.Management.dto.ProjectAssignmentResponse;
import com.Xr.Management.enums.Role;
import com.Xr.Management.model.ProjectAssignment;
import com.Xr.Management.service.ProjectAssignmentServiceImpl;

@RestController
@RequestMapping("/projectAssignment")
//@Tag(name = "Project Assignment API")
public class ProjectAssignmentController {

	@Autowired
	ProjectAssignmentServiceImpl projectAssignmentServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<Object> createProjectAssignment(@RequestParam Long userId, @RequestParam Long projectId,
			@RequestParam Role role) {
		ProjectAssignmentResponse projectAssignmentResponse = projectAssignmentServiceImpl.createAssignment(userId,
				projectId, role);
		return ResponseEntity.ok(projectAssignmentResponse);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAuthority('admin:access')")
	public ResponseEntity<Object> updateProjectAssignmrnt(@PathVariable Long id,
			@RequestAttribute(required = false) Long userId, @RequestParam(required = false) Long projectId,
			@RequestParam(required = false) Role role) {
		ProjectAssignmentResponse projectAssignment = projectAssignmentServiceImpl.updateAssignment(id, userId,
				projectId, role);

		return ResponseEntity.ok(projectAssignment);
	}

	@GetMapping("/getAllAssignment")
	public List<ProjectAssignment> projectAssignments() {
		return projectAssignmentServiceImpl.getAssignments();
	}

	@GetMapping("/data")
	@PreAuthorize("hasAuthority('admin:access')")
	public List<ProjectAssignmentResponse> getUserData(@RequestParam(defaultValue = "1") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize) {
		return projectAssignmentServiceImpl.getProjectAssignments(pageNumber, pageSize);
	}

}
