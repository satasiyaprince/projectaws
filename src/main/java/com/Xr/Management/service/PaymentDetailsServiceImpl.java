package com.Xr.Management.service;

import java.util.List;

import com.Xr.Management.dto.PaymentDetailsResponse;
import com.Xr.Management.model.PaymentDetails;


public interface PaymentDetailsServiceImpl {

	PaymentDetailsResponse createPaymentDetails(String paymentName, Long projectId, Double amount, String createdBy,
			String date);

	List<PaymentDetails> getPaymentDetails();

	PaymentDetailsResponse updatePaymentDetails(Long id, String paymentName, Long projectId, Double amount,
			String createdBy, String date);

	List<PaymentDetailsResponse> getPaymentData(int pageNumber, int pageSize);

}
