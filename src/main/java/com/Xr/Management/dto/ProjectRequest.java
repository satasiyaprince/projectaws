package com.Xr.Management.dto;

import java.util.List;

import com.Xr.Management.enums.Category;
import com.Xr.Management.enums.Platform;
import com.Xr.Management.enums.Status;
import com.Xr.Management.enums.Technology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProjectRequest {

	private String name;

	private String description;

	private Double amount;

	private Long startDate;

	private Long endDate;

	private Long holdDate;

	private List<Technology> technology;

	private Category category;

	private Platform platform;

	private Status status;

	private Integer totalMilestone;

	private Integer currentMilestone;

	private String clientName;

	private Double amountReceived;
}
