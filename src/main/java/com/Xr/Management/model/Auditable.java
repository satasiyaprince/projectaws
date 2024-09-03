package com.Xr.Management.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@MappedSuperclass
@Data
public class Auditable {

	@ApiModelProperty(hidden = true)
	public long creationdate;

	@ApiModelProperty(hidden = true)

	public long lastModifieddate;

	public Auditable() {
	}

	@PrePersist
	public void onCreate() {
		this.creationdate = new Date().getTime();
		this.onUpdate();
	}

	@PreUpdate
	public void onUpdate() {

		this.lastModifieddate = new Date().getTime();
	}

}
