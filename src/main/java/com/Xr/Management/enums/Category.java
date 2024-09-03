package com.Xr.Management.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

	FRONTEND("FRONTEND"), BACKEND("BACKEND"), ADMIN("ADMIN"), UI("UI"), QA("QA");

	private String category;
}
