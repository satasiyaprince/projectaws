package com.Xr.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Xr.Management.dto.ProjectResponse;
import com.Xr.Management.enums.Category;
import com.Xr.Management.enums.Platform;
import com.Xr.Management.enums.Status;
import com.Xr.Management.enums.Technology;
import com.Xr.Management.model.Project;
import com.Xr.Management.service.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
//@Tag(name = "Project API")
public class ProjectController {

	@Autowired
	ProjectServiceImpl projectServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<Object> createProject(@RequestParam String name, @RequestParam String description,
			@RequestParam Double amount, @RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String holdDate, @RequestParam List<Technology> technology, @RequestParam Category category,
			@RequestParam Platform platform, @RequestParam Status status, @RequestParam Integer totalMilestone,
			@RequestParam Integer currentMilestone, @RequestParam String clientName,
			@RequestParam Double amountReceived) {

		ProjectResponse project = projectServiceImpl.createProject(name, description, amount, startDate, endDate,
				holdDate, technology, category, platform, status, totalMilestone, currentMilestone, clientName,
				amountReceived);
		return ResponseEntity.ok(project);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAuthority('admin:access')")
	public ResponseEntity<Object> updateProject(@PathVariable Long id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String description, @RequestParam(required = false) Double amount,
			@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate,
			@RequestParam(required = false) String holdDate,
			@RequestParam(required = false) List<Technology> technology,
			@RequestParam(required = false) Category category, @RequestParam(required = false) Platform platform,
			@RequestParam(required = false) Status status) {

		ProjectResponse project = projectServiceImpl.updateProject(id, name, description, amount, startDate, endDate,
				holdDate, technology, category, platform, status);

		return ResponseEntity.ok(project);

	}

	@GetMapping("/data")
	@PreAuthorize("hasAuthority('admin:access')")
	public List<ProjectResponse> getUserData(@RequestParam(defaultValue = "1") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize) {
		return projectServiceImpl.getProjectData(pageNumber, pageSize);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('admin:access')")
	public ResponseEntity<Void> softDeleteUser(@PathVariable Long id) {
		projectServiceImpl.softDeleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/userAllData")
	public List<Project> userGetAllData() {
		return projectServiceImpl.getProjectDetails();
	}

	@GetMapping("/active")
	public ResponseEntity<List<ProjectResponse>> getAllProjects() {
		List<ProjectResponse> projectData = projectServiceImpl.getProjectData();
		return ResponseEntity.ok(projectData);
	}

}
