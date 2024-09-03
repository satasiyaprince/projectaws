package com.Xr.Management.dto;

import com.Xr.Management.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

	private Long id;
	private String name;
	private String email;
	private String countryCode;
	private String number;
	private Role role;
	private String photo;

}
