package com.br.barberapi.mapper;


import com.br.barberapi.controller.request.SaveClientRequest;
import com.br.barberapi.controller.request.UpdateClientRequest;
import com.br.barberapi.controller.response.ClientDetailResponse;
import com.br.barberapi.controller.response.ListClientResponse;
import com.br.barberapi.controller.response.SaveClientResponse;
import com.br.barberapi.controller.response.UpdateClientResponse;
import com.br.barberapi.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}