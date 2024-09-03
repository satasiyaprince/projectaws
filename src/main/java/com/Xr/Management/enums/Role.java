package com.Xr.Management.enums;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.var;


@Getter
@RequiredArgsConstructor
public enum Role {

	ADMIN(Set.of(Permission.ADMIN_ACCESS, Permission.LOGIN_USER, Permission.GET_USER,
			Permission.PMS_USER_RESET_PASSWORD, Permission.PROFILE_UPDATE)),

	BDE(Set.of(Permission.PROFILE_UPDATE, Permission.PMS_USER_RESET_PASSWORD, Permission.GET_USER)),

	PROJECTMANAGER(Set.of(Permission.PROFILE_UPDATE, Permission.PMS_USER_RESET_PASSWORD, Permission.GET_USER));

	private final Set<Permission> permissions;

	public List<SimpleGrantedAuthority> getAuthorities() {
		var authorities = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toList());
		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return authorities;
	}
}
