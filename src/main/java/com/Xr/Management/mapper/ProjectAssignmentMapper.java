package com.Xr.Management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.Xr.Management.dto.ProjectAssignmentRequest;
import com.Xr.Management.dto.ProjectAssignmentResponse;
import com.Xr.Management.model.ProjectAssignment;

@Component
@Mapper(componentModel = "spring")
public abstract interface ProjectAssignmentMapper extends EntityMapper<ProjectAssignmentResponse, ProjectAssignment> {

	@Mapping(target = "id", ignore = true)
	ProjectAssignment toEntity(ProjectAssignmentRequest request);

	ProjectAssignmentResponse toDto(ProjectAssignment model);

//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "creationDate", ignore = true)
//	@Mapping(target = "lastModifiedDate", ignore = true)
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void update(ProjectAssignmentRequest dto, @MappingTarget ProjectAssignment entity);
}
