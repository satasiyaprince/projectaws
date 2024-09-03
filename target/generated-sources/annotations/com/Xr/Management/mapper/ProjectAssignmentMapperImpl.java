package com.Xr.Management.mapper;

import com.Xr.Management.dto.ProjectAssignmentRequest;
import com.Xr.Management.dto.ProjectAssignmentResponse;
import com.Xr.Management.model.ProjectAssignment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T11:52:00+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class ProjectAssignmentMapperImpl implements ProjectAssignmentMapper {

    @Override
    public ProjectAssignment toEntity(ProjectAssignmentResponse dto) {
        if ( dto == null ) {
            return null;
        }

        ProjectAssignment.ProjectAssignmentBuilder projectAssignment = ProjectAssignment.builder();

        projectAssignment.id( dto.getId() );
        projectAssignment.projectId( dto.getProjectId() );
        projectAssignment.role( dto.getRole() );
        projectAssignment.userId( dto.getUserId() );

        return projectAssignment.build();
    }

    @Override
    public List<ProjectAssignment> toEntities(List<ProjectAssignmentResponse> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ProjectAssignment> list = new ArrayList<ProjectAssignment>( dtos.size() );
        for ( ProjectAssignmentResponse projectAssignmentResponse : dtos ) {
            list.add( toEntity( projectAssignmentResponse ) );
        }

        return list;
    }

    @Override
    public List<ProjectAssignmentResponse> toDtos(List<ProjectAssignment> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProjectAssignmentResponse> list = new ArrayList<ProjectAssignmentResponse>( entities.size() );
        for ( ProjectAssignment projectAssignment : entities ) {
            list.add( toDto( projectAssignment ) );
        }

        return list;
    }

    @Override
    public void update(ProjectAssignmentResponse dto, ProjectAssignment entity) {
        if ( dto == null ) {
            return;
        }

        entity.setProjectId( dto.getProjectId() );
        entity.setRole( dto.getRole() );
        entity.setUserId( dto.getUserId() );
    }

    @Override
    public ProjectAssignment toEntity(ProjectAssignmentRequest request) {
        if ( request == null ) {
            return null;
        }

        ProjectAssignment.ProjectAssignmentBuilder projectAssignment = ProjectAssignment.builder();

        projectAssignment.projectId( request.getProjectId() );
        projectAssignment.role( request.getRole() );
        projectAssignment.userId( request.getUserId() );

        return projectAssignment.build();
    }

    @Override
    public ProjectAssignmentResponse toDto(ProjectAssignment model) {
        if ( model == null ) {
            return null;
        }

        ProjectAssignmentResponse.ProjectAssignmentResponseBuilder projectAssignmentResponse = ProjectAssignmentResponse.builder();

        projectAssignmentResponse.id( model.getId() );
        projectAssignmentResponse.projectId( model.getProjectId() );
        projectAssignmentResponse.role( model.getRole() );
        projectAssignmentResponse.userId( model.getUserId() );

        return projectAssignmentResponse.build();
    }

    @Override
    public void update(ProjectAssignmentRequest dto, ProjectAssignment entity) {
        if ( dto == null ) {
            return;
        }

        entity.setProjectId( dto.getProjectId() );
        entity.setRole( dto.getRole() );
        entity.setUserId( dto.getUserId() );
    }
}
