package com.Xr.Management.mapper;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface EntityMapper<D, E> {

	E toEntity(D dto);

	D toDto(E entity);

	List<E> toEntities(List<D> dtos);

	List<D> toDtos(List<E> entities);

	@Mapping(target = "id", ignore = true)
	void update(D dto, @MappingTarget E entity);

}
