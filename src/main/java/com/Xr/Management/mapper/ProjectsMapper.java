package com.Xr.Management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.Xr.Management.dto.ProjectRequest;
import com.Xr.Management.dto.ProjectResponse;
import com.Xr.Management.model.Project;

@Component
@Mapper(componentModel = "spring")
public abstract interface ProjectsMapper extends EntityMapper<ProjectResponse, Project> {

	@Mapping(target = "id", ignore = true)
	Project toEntity(ProjectRequest request);

	ProjectResponse toDto(Project model);

	@Mapping(target = "id", ignore = true)
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void update(ProjectRequest dto, @MappingTarget Project entity);
}
