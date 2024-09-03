package com.Xr.Management.dto;

import com.Xr.Management.enums.Role;
import com.Xr.Management.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginResponse {

	private String jwt;

	private Role role;

	private String email;

	public static LoginResponse getUserResponse(User user) {

		LoginResponse userResponse = new LoginResponse();
		
		userResponse.setEmail(user.getEmail());
	
		userResponse.setRole(user.getRole());
	
		return userResponse;
	}
	
}
