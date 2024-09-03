package com.Xr.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Xr.Management.dto.PaymentDetailsResponse;
import com.Xr.Management.model.PaymentDetails;
import com.Xr.Management.service.PaymentDetailsServiceImpl;

@RestController
@RequestMapping("/paymentDetails")
//@Tag(name = "Payment API")
public class PaymentDetailsController {

	@Autowired
	PaymentDetailsServiceImpl paymentDetailsServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<Object> createPayment(@RequestParam String paymentName, @RequestParam Long projectId,
			@RequestParam Double amount, @RequestParam String createdBy, @RequestParam String date) {
		PaymentDetailsResponse paymentDetailsResponse = paymentDetailsServiceImpl.createPaymentDetails(paymentName,
				projectId, amount, createdBy, date);
		return ResponseEntity.ok(paymentDetailsResponse);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePayment(@PathVariable Long id,
			@RequestParam(required = false) String paymentName, @RequestParam(required = false) Long projectId,
			@RequestParam(required = false) Double amount, @RequestParam String createdBy,
			@RequestParam(required = false) String date) {
		PaymentDetailsResponse paymentDetails = paymentDetailsServiceImpl.updatePaymentDetails(id, paymentName,
				projectId, amount, createdBy, date);
		return ResponseEntity.ok(paymentDetails);
	}

	@GetMapping("/getAllPayment")
	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetailsServiceImpl.getPaymentDetails();
	}

	@GetMapping("/data")
	@PreAuthorize("hasAuthority('admin:access')")
	public List<PaymentDetailsResponse> getUserData(@RequestParam(defaultValue = "1") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize) {
		return paymentDetailsServiceImpl.getPaymentData(pageNumber, pageSize);
	}

}
