package com.Xr.Management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Xr.Management.model.ProjectAssignment;

public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment, Long> {

	Page<ProjectAssignment> findByDeletedFalse(Pageable pageable);

	Optional<ProjectAssignment> findByIdAndDeletedFalse(Long id);

	List<ProjectAssignment> findByDeletedFalse();

	Object findById(Long id);

}