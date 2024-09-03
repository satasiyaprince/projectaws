package com.Xr.Management.dto;

import com.Xr.Management.model.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaymentDetailsRequest {

	private String paymentName;

	private Project projectId;

	private Double amount;

	private String createdBy;

	private Long date;
}
