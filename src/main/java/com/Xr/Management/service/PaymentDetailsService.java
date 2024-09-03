package com.Xr.Management.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Xr.Management.dto.PaymentDetailsRequest;
import com.Xr.Management.dto.PaymentDetailsResponse;
import com.Xr.Management.exception.UserException;
import com.Xr.Management.mapper.PaymentDetailsMapper;
import com.Xr.Management.model.PaymentDetails;
import com.Xr.Management.model.Project;
import com.Xr.Management.repository.PaymentDetailsRepository;
import com.Xr.Management.repository.ProjectRepository;
import com.Xr.Management.utils.Messages;
import com.Xr.Management.utils.Utils;


@Service
public class PaymentDetailsService implements PaymentDetailsServiceImpl {

	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	PaymentDetailsMapper paymentDetailsMapper;

	@Override
	public PaymentDetailsResponse createPaymentDetails(String paymentName, Long projectId, Double amount,
			String createdBy, String date) {
		Project project = (Project) projectRepository.findById(projectId);  // Corrected: Optional<Project>
		Long dateInMillis = null;
		if (date != null && date.length() != 13) {
			dateInMillis = Utils.convertDateStringToMilliseconds(date);
		}
		PaymentDetailsRequest paymentDetailsRequest = PaymentDetailsRequest.builder()
				.paymentName(paymentName)
				.projectId(project)
				.amount(amount)
				.createdBy(createdBy)
				.date(dateInMillis)
				.build();
		PaymentDetails paymentDetails = paymentDetailsMapper.toEntity(paymentDetailsRequest);
		paymentDetails.setDeleted(false);
		PaymentDetails savePaymentDetails = paymentDetailsRepository.save(paymentDetails);
		return paymentDetailsMapper.toDto(savePaymentDetails);
	}

	@Override
	public PaymentDetailsResponse updatePaymentDetails(Long id, String paymentName, Long projectId, Double amount,
			String createdBy, String date) {
		PaymentDetails paymentDetails = (PaymentDetails) paymentDetailsRepository.findById(id); 
		Project project = (Project) projectRepository.findById(projectId);  
		Long dateInMillis = null;
		if (date != null && date.length() != 13) {
			dateInMillis = Utils.convertDateStringToMilliseconds(date);
		}
		PaymentDetailsRequest paymentDetailsRequest = PaymentDetailsRequest.builder()
				.paymentName(paymentName)
				.projectId(project)
				.amount(amount)
				.createdBy(createdBy)
				.date(dateInMillis)
				.build();
		paymentDetailsMapper.update(paymentDetailsRequest, paymentDetails);
		PaymentDetails updateDetails = paymentDetailsRepository.save(paymentDetails);
		return paymentDetailsMapper.toDto(updateDetails);
	}

	@Override
	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetailsRepository.findAll();
	}

	@Override
	public List<PaymentDetailsResponse> getPaymentData(int pageNumber, int pageSize) {
		if (pageNumber < 1 || pageSize < 1) {
			throw new UserException(Messages.PAGE_NUMBER_AND_PAGE_SIZE);
		}
//		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);  
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

		Page<PaymentDetails> payment = paymentDetailsRepository.findByDeletedFalse(pageable);
		List<PaymentDetailsResponse> paymentData = ((Collection<PaymentDetails>) payment).stream()
				.map(paymentDetailsMapper::toDto)
				.collect(Collectors.toList());
		return paymentData;
	}
}
