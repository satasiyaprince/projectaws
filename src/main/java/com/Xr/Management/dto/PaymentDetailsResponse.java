package com.Xr.Management.dto;

import com.Xr.Management.model.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailsResponse {

	private Long id;

	private String paymentName;

	private Project projectId;

	private Double amount;

	private String createdBy;

	private String date;
}
