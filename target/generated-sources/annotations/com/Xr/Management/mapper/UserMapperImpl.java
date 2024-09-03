package com.Xr.Management.mapper;

import com.Xr.Management.dto.UserRequest;
import com.Xr.Management.dto.UserResponse;
import com.Xr.Management.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T11:52:01+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserResponse dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.countryCode( dto.getCountryCode() );
        user.email( dto.getEmail() );
        user.id( dto.getId() );
        user.name( dto.getName() );
        user.number( dto.getNumber() );
        user.photo( dto.getPhoto() );
        user.role( dto.getRole() );

        return user.build();
    }

    @Override
    public List<User> toEntities(List<UserResponse> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserResponse userResponse : dtos ) {
            list.add( toEntity( userResponse ) );
        }

        return list;
    }

    @Override
    public List<UserResponse> toDtos(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( entities.size() );
        for ( User user : entities ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public void update(UserResponse dto, User entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCountryCode( dto.getCountryCode() );
        entity.setEmail( dto.getEmail() );
        entity.setName( dto.getName() );
        entity.setNumber( dto.getNumber() );
        entity.setPhoto( dto.getPhoto() );
        entity.setRole( dto.getRole() );
    }

    @Override
    public User toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.countryCode( request.getCountryCode() );
        user.email( request.getEmail() );
        user.name( request.getName() );
        user.number( request.getNumber() );
        user.password( request.getPassword() );
        user.photo( request.getPhoto() );
        user.role( request.getRole() );

        return user.build();
    }

    @Override
    public UserResponse toDto(User model) {
        if ( model == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.countryCode( model.getCountryCode() );
        userResponse.email( model.getEmail() );
        userResponse.id( model.getId() );
        userResponse.name( model.getName() );
        userResponse.number( model.getNumber() );
        userResponse.photo( model.getPhoto() );
        userResponse.role( model.getRole() );

        return userResponse.build();
    }

    @Override
    public void update(UserRequest dto, User entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCountryCode( dto.getCountryCode() );
        entity.setEmail( dto.getEmail() );
        entity.setName( dto.getName() );
        entity.setNumber( dto.getNumber() );
        entity.setPassword( dto.getPassword() );
        entity.setPhoto( dto.getPhoto() );
        entity.setRole( dto.getRole() );
    }
}
