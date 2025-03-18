package com.br.barberapi.mapper;

import com.br.barberapi.controller.request.SaveScheduleRequest;
import com.br.barberapi.controller.response.ClientScheduleAppointmentResponse;
import com.br.barberapi.controller.response.SaveScheduleResponse;
import com.br.barberapi.controller.response.ScheduleAppointmentMonthResponse;
import com.br.barberapi.entity.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = "spring")
public interface IScheduleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    ScheduleEntity toEntity(final SaveScheduleRequest request);

    @Mapping(target = "clientId", source = "client.id")
    SaveScheduleResponse toSaveResponse(final ScheduleEntity entity);

    @Mapping(target = "scheduledAppointments", expression = "java(toClientMonthResponse(entities))")
    ScheduleAppointmentMonthResponse toMonthResponse(final int year, final int month, final List<ScheduleEntity> entities);

    List<ClientScheduleAppointmentResponse> toClientMonthResponse(final List<ScheduleEntity> entities);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "day", expression = "java(entity.getStartAt().getDayOfMonth())")
    ClientScheduleAppointmentResponse toClientMonthResponse(final ScheduleEntity entity);
}