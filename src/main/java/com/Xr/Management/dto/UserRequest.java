package com.Xr.Management.dto;

import com.Xr.Management.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRequest {

	private String name;
	private String email;
	private String password;
	private String number;
	private String countryCode;
	private String photo;
	private Role role;

}
