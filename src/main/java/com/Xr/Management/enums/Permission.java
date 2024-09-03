package com.Xr.Management.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {

	ADMIN_ACCESS("admin:access"), LOGIN_USER("user:login"), PROFILE_UPDATE("user:profile-update"),
	PMS_USER_RESET_PASSWORD("pms-user:reset-password"), GET_USER("user:get-user");

	private final String permission;

}