package com.Xr.Management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.Xr.Management.dto.UserRequest;
import com.Xr.Management.dto.UserResponse;
import com.Xr.Management.model.User;


@Mapper(componentModel = "spring")
@Component  // This should ensure Spring picks up the mapper
public interface UserMapper extends EntityMapper<UserResponse, User> {

    // Maps a UserRequest DTO to a User entity
    User toEntity(UserRequest request);

    // Maps a User entity to a UserResponse DTO
    UserResponse toDto(User model);

    // Updates an existing User entity based on a UserRequest DTO
    void update(UserRequest dto, @MappingTarget User entity);
}
