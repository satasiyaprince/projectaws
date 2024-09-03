package com.Xr.Management.enums;

public enum Technology {

	FLUTTER("FLUTTER"), JAVA("JAVA"), REACT("REACT"), NODE("NODE"), ANDROID("ANDROID");

	private String technology;

	private Technology(String technology) {
		this.technology = technology;
	}

	public String getTechnology() {
		return this.technology;
	}

}
