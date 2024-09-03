package com.Xr.Management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Xr.Management.model.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {

	Page<PaymentDetails> findByDeletedFalse(Pageable pageable);

	Optional<PaymentDetails> findByIdAndDeletedFalse(Long id);

	List<PaymentDetails> findByDeletedFalse();

	Object findById(Long projectId);

}
