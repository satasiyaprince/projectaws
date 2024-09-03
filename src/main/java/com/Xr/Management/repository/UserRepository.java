package com.Xr.Management.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Xr.Management.enums.Role;
import com.Xr.Management.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	boolean existsByRole(Role admin);

	Optional<User> findByIdAndDeletedFalse(Long id);

	List<User> findAllByDeletedFalse();

	Optional<User> findByEmailAndDeletedFalse(String email);

	Page<User> findByDeletedFalse(Pageable pageable);

	User findById(Long userId);



}