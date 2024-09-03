package com.Xr.Management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.Xr.Management.dto.PaymentDetailsRequest;
import com.Xr.Management.dto.PaymentDetailsResponse;
import com.Xr.Management.model.PaymentDetails;

@Component
@Mapper(componentModel = "spring")
public abstract interface PaymentDetailsMapper extends EntityMapper<PaymentDetailsResponse, PaymentDetails> {

	@Mapping(target = "id", ignore = true)
	PaymentDetails toEntity(PaymentDetailsRequest request);

	PaymentDetailsResponse toDto(PaymentDetails model);

	@Mapping(target = "id", ignore = true)
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void update(PaymentDetailsRequest dto, @MappingTarget PaymentDetails entity);
}
