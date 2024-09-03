package com.Xr.Management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Xr.Management.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	Page<Project> findByDeletedFalse(Pageable pageable);

	Optional<Project> findByIdAndDeletedFalse(Long id);

	List<Project> findByDeletedFalse();

	Object findById(Long projectId);
}

