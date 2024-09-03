package com.Xr.Management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PaymentDetails extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="paymentname")
	private String paymentName;

	@ManyToOne
	private Project projectId;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="createdby")
	private String createdBy;
	
	@Column(name="date")
	private String date;
	
	@Column(name="enabled")
	private boolean enabled;

	@Column(name="deleted",nullable = false)
	private Boolean deleted;
}
