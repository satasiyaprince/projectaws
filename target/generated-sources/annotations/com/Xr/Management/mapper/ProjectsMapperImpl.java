package com.Xr.Management.mapper;

import com.Xr.Management.dto.ProjectRequest;
import com.Xr.Management.dto.ProjectResponse;
import com.Xr.Management.enums.Technology;
import com.Xr.Management.model.Project;
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
public class ProjectsMapperImpl implements ProjectsMapper {

    @Override
    public Project toEntity(ProjectResponse dto) {
        if ( dto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.amount( dto.getAmount() );
        project.amountReceived( dto.getAmountReceived() );
        project.category( dto.getCategory() );
        project.clientName( dto.getClientName() );
        project.currentMilestone( dto.getCurrentMilestone() );
        project.description( dto.getDescription() );
        if ( dto.getEndDate() != null ) {
            project.endDate( String.valueOf( dto.getEndDate() ) );
        }
        if ( dto.getHoldDate() != null ) {
            project.holdDate( String.valueOf( dto.getHoldDate() ) );
        }
        project.id( dto.getId() );
        project.name( dto.getName() );
        project.platform( dto.getPlatform() );
        if ( dto.getStartDate() != null ) {
            project.startDate( String.valueOf( dto.getStartDate() ) );
        }
        project.status( dto.getStatus() );
        project.technology( technologyListToStringList( dto.getTechnology() ) );
        project.totalMilestone( dto.getTotalMilestone() );

        return project.build();
    }

    @Override
    public List<Project> toEntities(List<ProjectResponse> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Project> list = new ArrayList<Project>( dtos.size() );
        for ( ProjectResponse projectResponse : dtos ) {
            list.add( toEntity( projectResponse ) );
        }

        return list;
    }

    @Override
    public List<ProjectResponse> toDtos(List<Project> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProjectResponse> list = new ArrayList<ProjectResponse>( entities.size() );
        for ( Project project : entities ) {
            list.add( toDto( project ) );
        }

        return list;
    }

    @Override
    public void update(ProjectResponse dto, Project entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAmount( dto.getAmount() );
        entity.setAmountReceived( dto.getAmountReceived() );
        entity.setCategory( dto.getCategory() );
        entity.setClientName( dto.getClientName() );
        entity.setCurrentMilestone( dto.getCurrentMilestone() );
        entity.setDescription( dto.getDescription() );
        if ( dto.getEndDate() != null ) {
            entity.setEndDate( String.valueOf( dto.getEndDate() ) );
        }
        else {
            entity.setEndDate( null );
        }
        if ( dto.getHoldDate() != null ) {
            entity.setHoldDate( String.valueOf( dto.getHoldDate() ) );
        }
        else {
            entity.setHoldDate( null );
        }
        entity.setName( dto.getName() );
        entity.setPlatform( dto.getPlatform() );
        if ( dto.getStartDate() != null ) {
            entity.setStartDate( String.valueOf( dto.getStartDate() ) );
        }
        else {
            entity.setStartDate( null );
        }
        entity.setStatus( dto.getStatus() );
        if ( entity.getTechnology() != null ) {
            List<String> list = technologyListToStringList( dto.getTechnology() );
            if ( list != null ) {
                entity.getTechnology().clear();
                entity.getTechnology().addAll( list );
            }
            else {
                entity.setTechnology( null );
            }
        }
        else {
            List<String> list = technologyListToStringList( dto.getTechnology() );
            if ( list != null ) {
                entity.setTechnology( list );
            }
        }
        entity.setTotalMilestone( dto.getTotalMilestone() );
    }

    @Override
    public Project toEntity(ProjectRequest request) {
        if ( request == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.amount( request.getAmount() );
        project.amountReceived( request.getAmountReceived() );
        project.category( request.getCategory() );
        project.clientName( request.getClientName() );
        project.currentMilestone( request.getCurrentMilestone() );
        project.description( request.getDescription() );
        if ( request.getEndDate() != null ) {
            project.endDate( String.valueOf( request.getEndDate() ) );
        }
        if ( request.getHoldDate() != null ) {
            project.holdDate( String.valueOf( request.getHoldDate() ) );
        }
        project.name( request.getName() );
        project.platform( request.getPlatform() );
        if ( request.getStartDate() != null ) {
            project.startDate( String.valueOf( request.getStartDate() ) );
        }
        project.status( request.getStatus() );
        project.technology( technologyListToStringList( request.getTechnology() ) );
        project.totalMilestone( request.getTotalMilestone() );

        return project.build();
    }

    @Override
    public ProjectResponse toDto(Project model) {
        if ( model == null ) {
            return null;
        }

        ProjectResponse.ProjectResponseBuilder projectResponse = ProjectResponse.builder();

        projectResponse.amount( model.getAmount() );
        projectResponse.amountReceived( model.getAmountReceived() );
        projectResponse.category( model.getCategory() );
        projectResponse.clientName( model.getClientName() );
        projectResponse.currentMilestone( model.getCurrentMilestone() );
        projectResponse.description( model.getDescription() );
        if ( model.getEndDate() != null ) {
            projectResponse.endDate( Long.parseLong( model.getEndDate() ) );
        }
        if ( model.getHoldDate() != null ) {
            projectResponse.holdDate( Long.parseLong( model.getHoldDate() ) );
        }
        projectResponse.id( model.getId() );
        projectResponse.name( model.getName() );
        projectResponse.platform( model.getPlatform() );
        if ( model.getStartDate() != null ) {
            projectResponse.startDate( Long.parseLong( model.getStartDate() ) );
        }
        projectResponse.status( model.getStatus() );
        projectResponse.technology( stringListToTechnologyList( model.getTechnology() ) );
        projectResponse.totalMilestone( model.getTotalMilestone() );

        return projectResponse.build();
    }

    @Override
    public void update(ProjectRequest dto, Project entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAmount( dto.getAmount() );
        entity.setAmountReceived( dto.getAmountReceived() );
        entity.setCategory( dto.getCategory() );
        entity.setClientName( dto.getClientName() );
        entity.setCurrentMilestone( dto.getCurrentMilestone() );
        entity.setDescription( dto.getDescription() );
        if ( dto.getEndDate() != null ) {
            entity.setEndDate( String.valueOf( dto.getEndDate() ) );
        }
        else {
            entity.setEndDate( null );
        }
        if ( dto.getHoldDate() != null ) {
            entity.setHoldDate( String.valueOf( dto.getHoldDate() ) );
        }
        else {
            entity.setHoldDate( null );
        }
        entity.setName( dto.getName() );
        entity.setPlatform( dto.getPlatform() );
        if ( dto.getStartDate() != null ) {
            entity.setStartDate( String.valueOf( dto.getStartDate() ) );
        }
        else {
            entity.setStartDate( null );
        }
        entity.setStatus( dto.getStatus() );
        if ( entity.getTechnology() != null ) {
            List<String> list = technologyListToStringList( dto.getTechnology() );
            if ( list != null ) {
                entity.getTechnology().clear();
                entity.getTechnology().addAll( list );
            }
            else {
                entity.setTechnology( null );
            }
        }
        else {
            List<String> list = technologyListToStringList( dto.getTechnology() );
            if ( list != null ) {
                entity.setTechnology( list );
            }
        }
        entity.setTotalMilestone( dto.getTotalMilestone() );
    }

    protected List<String> technologyListToStringList(List<Technology> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( Technology technology : list ) {
            list1.add( technology.name() );
        }

        return list1;
    }

    protected List<Technology> stringListToTechnologyList(List<String> list) {
        if ( list == null ) {
            return null;
        }

        List<Technology> list1 = new ArrayList<Technology>( list.size() );
        for ( String string : list ) {
            list1.add( Enum.valueOf( Technology.class, string ) );
        }

        return list1;
    }
}
