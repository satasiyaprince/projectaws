package com.Xr.Management.dto;

import com.Xr.Management.enums.Role;
import com.Xr.Management.model.Project;
import com.Xr.Management.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAssignmentResponse {

	private Long id;

	private User userId;

	private Project projectId;

	private Role role;
}
