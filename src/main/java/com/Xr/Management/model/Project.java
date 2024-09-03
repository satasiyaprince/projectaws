package com.Xr.Management.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.Xr.Management.enums.Category;
import com.Xr.Management.enums.Platform;
import com.Xr.Management.enums.Status;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

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
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class Project extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "startdate")
	private String startDate;

	@Column(name = "enddate")
	private String endDate;

	@Column(name = "holddate")
	private String holdDate;

	@Column(name = "totalmilestone")
	private Integer totalMilestone;

	@Column(name = "currentmilestone")
	private Integer currentMilestone;

	@Column(name = "clientname")
	private String clientName;

	@Column(name = "amountreceived")
	private Double amountReceived;

	@Type(type = "list-array")
	@Enumerated(EnumType.STRING)
	@Column(name = "technology", columnDefinition = "text[]")
	private List<String> technology;

	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private Category category;

	@Enumerated(EnumType.STRING)
	@Column(name = "platform")
	private Platform platform;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted;

}
