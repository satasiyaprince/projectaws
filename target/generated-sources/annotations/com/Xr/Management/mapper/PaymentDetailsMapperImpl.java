package com.Xr.Management.mapper;

import com.Xr.Management.dto.PaymentDetailsRequest;
import com.Xr.Management.dto.PaymentDetailsResponse;
import com.Xr.Management.model.PaymentDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T11:51:59+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class PaymentDetailsMapperImpl implements PaymentDetailsMapper {

    @Override
    public PaymentDetails toEntity(PaymentDetailsResponse dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentDetails.PaymentDetailsBuilder paymentDetails = PaymentDetails.builder();

        paymentDetails.amount( dto.getAmount() );
        paymentDetails.createdBy( dto.getCreatedBy() );
        paymentDetails.date( dto.getDate() );
        paymentDetails.id( dto.getId() );
        paymentDetails.paymentName( dto.getPaymentName() );
        paymentDetails.projectId( dto.getProjectId() );

        return paymentDetails.build();
    }

    @Override
    public List<PaymentDetails> toEntities(List<PaymentDetailsResponse> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<PaymentDetails> list = new ArrayList<PaymentDetails>( dtos.size() );
        for ( PaymentDetailsResponse paymentDetailsResponse : dtos ) {
            list.add( toEntity( paymentDetailsResponse ) );
        }

        return list;
    }

    @Override
    public List<PaymentDetailsResponse> toDtos(List<PaymentDetails> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PaymentDetailsResponse> list = new ArrayList<PaymentDetailsResponse>( entities.size() );
        for ( PaymentDetails paymentDetails : entities ) {
            list.add( toDto( paymentDetails ) );
        }

        return list;
    }

    @Override
    public void update(PaymentDetailsResponse dto, PaymentDetails entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAmount( dto.getAmount() );
        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setDate( dto.getDate() );
        entity.setPaymentName( dto.getPaymentName() );
        entity.setProjectId( dto.getProjectId() );
    }

    @Override
    public PaymentDetails toEntity(PaymentDetailsRequest request) {
        if ( request == null ) {
            return null;
        }

        PaymentDetails.PaymentDetailsBuilder paymentDetails = PaymentDetails.builder();

        paymentDetails.amount( request.getAmount() );
        paymentDetails.createdBy( request.getCreatedBy() );
        if ( request.getDate() != null ) {
            paymentDetails.date( String.valueOf( request.getDate() ) );
        }
        paymentDetails.paymentName( request.getPaymentName() );
        paymentDetails.projectId( request.getProjectId() );

        return paymentDetails.build();
    }

    @Override
    public PaymentDetailsResponse toDto(PaymentDetails model) {
        if ( model == null ) {
            return null;
        }

        PaymentDetailsResponse.PaymentDetailsResponseBuilder paymentDetailsResponse = PaymentDetailsResponse.builder();

        paymentDetailsResponse.amount( model.getAmount() );
        paymentDetailsResponse.createdBy( model.getCreatedBy() );
        paymentDetailsResponse.date( model.getDate() );
        paymentDetailsResponse.id( model.getId() );
        paymentDetailsResponse.paymentName( model.getPaymentName() );
        paymentDetailsResponse.projectId( model.getProjectId() );

        return paymentDetailsResponse.build();
    }

    @Override
    public void update(PaymentDetailsRequest dto, PaymentDetails entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAmount( dto.getAmount() );
        entity.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getDate() != null ) {
            entity.setDate( String.valueOf( dto.getDate() ) );
        }
        else {
            entity.setDate( null );
        }
        entity.setPaymentName( dto.getPaymentName() );
        entity.setProjectId( dto.getProjectId() );
    }
}
