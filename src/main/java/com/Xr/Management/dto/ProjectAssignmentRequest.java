package com.Xr.Management.dto;

import com.Xr.Management.enums.Role;
import com.Xr.Management.model.Project;
import com.Xr.Management.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProjectAssignmentRequest {

	private User userId;

	private Project projectId;

	private Role role;
}
