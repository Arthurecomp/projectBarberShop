package com.br.barberapi.mapper;

import com.br.barberapi.controller.request.SaveScheduleRequest;
import com.br.barberapi.controller.response.ClientScheduleAppointmentResponse;
import com.br.barberapi.controller.response.SaveScheduleResponse;
import com.br.barberapi.controller.response.ScheduleAppointmentMonthResponse;
import com.br.barberapi.entity.ClientEntity;
import com.br.barberapi.entity.ScheduleEntity;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-17T18:04:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class IScheduleMapperImpl implements IScheduleMapper {

    @Override
    public ScheduleEntity toEntity(SaveScheduleRequest request) {
        if ( request == null ) {
            return null;
        }

        ScheduleEntity scheduleEntity = new ScheduleEntity();

        scheduleEntity.setClient( saveScheduleRequestToClientEntity( request ) );
        scheduleEntity.setStartAt( request.startAt() );
        scheduleEntity.setEndAt( request.endAt() );

        return scheduleEntity;
    }

    @Override
    public SaveScheduleResponse toSaveResponse(ScheduleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long clientId = null;
        Long id = null;
        OffsetDateTime startAt = null;
        OffsetDateTime endAt = null;

        clientId = entityClientId( entity );
        id = entity.getId();
        startAt = entity.getStartAt();
        endAt = entity.getEndAt();

        SaveScheduleResponse saveScheduleResponse = new SaveScheduleResponse( id, startAt, endAt, clientId );

        return saveScheduleResponse;
    }

    @Override
    public ScheduleAppointmentMonthResponse toMonthResponse(int year, int month, List<ScheduleEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        int year1 = 0;
        year1 = year;
        int month1 = 0;
        month1 = month;

        List<ClientScheduleAppointmentResponse> scheduledAppointments = toClientMonthResponse(entities);

        ScheduleAppointmentMonthResponse scheduleAppointmentMonthResponse = new ScheduleAppointmentMonthResponse( year1, month1, scheduledAppointments );

        return scheduleAppointmentMonthResponse;
    }

    @Override
    public List<ClientScheduleAppointmentResponse> toClientMonthResponse(List<ScheduleEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientScheduleAppointmentResponse> list = new ArrayList<ClientScheduleAppointmentResponse>( entities.size() );
        for ( ScheduleEntity scheduleEntity : entities ) {
            list.add( toClientMonthResponse( scheduleEntity ) );
        }

        return list;
    }

    @Override
    public ClientScheduleAppointmentResponse toClientMonthResponse(ScheduleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long clientId = null;
        String clientName = null;
        Long id = null;
        OffsetDateTime startAt = null;
        OffsetDateTime endAt = null;

        clientId = entityClientId( entity );
        clientName = entityClientName( entity );
        id = entity.getId();
        startAt = entity.getStartAt();
        endAt = entity.getEndAt();

        Integer day = entity.getStartAt().getDayOfMonth();

        ClientScheduleAppointmentResponse clientScheduleAppointmentResponse = new ClientScheduleAppointmentResponse( id, day, startAt, endAt, clientId, clientName );

        return clientScheduleAppointmentResponse;
    }

    protected ClientEntity saveScheduleRequestToClientEntity(SaveScheduleRequest saveScheduleRequest) {
        if ( saveScheduleRequest == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( saveScheduleRequest.clientId() );

        return clientEntity;
    }

    private Long entityClientId(ScheduleEntity scheduleEntity) {
        if ( scheduleEntity == null ) {
            return null;
        }
        ClientEntity client = scheduleEntity.getClient();
        if ( client == null ) {
            return null;
        }
        Long id = client.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityClientName(ScheduleEntity scheduleEntity) {
        if ( scheduleEntity == null ) {
            return null;
        }
        ClientEntity client = scheduleEntity.getClient();
        if ( client == null ) {
            return null;
        }
        String name = client.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
