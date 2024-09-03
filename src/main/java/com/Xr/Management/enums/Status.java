package com.Xr.Management.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public enum Status {

	STARTED("STARTED"), IN_PROGRESS("IN_PROGRESS"), COMPLETED("COMPLETED");

	private String status;

}
