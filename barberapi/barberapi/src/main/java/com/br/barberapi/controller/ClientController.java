package com.br.barberapi.controller;

import com.br.barberapi.controller.request.SaveClientRequest;
import com.br.barberapi.controller.request.UpdateClientRequest;
import com.br.barberapi.controller.response.ClientDetailResponse;
import com.br.barberapi.controller.response.ListClientResponse;
import com.br.barberapi.controller.response.SaveClientResponse;
import com.br.barberapi.controller.response.UpdateClientResponse;
import com.br.barberapi.exception.PhoneInUseException;
import com.br.barberapi.mapper.IClientMapper;
import com.br.barberapi.service.IClientService;
import com.br.barberapi.service.query.IClientQueryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {

    private final IClientService service;
    private final IClientQueryService queryService;
    private final IClientMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    SaveClientResponse save(@RequestBody @Valid final SaveClientRequest request) throws PhoneInUseException {
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateClientResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateClientRequest request) throws PhoneInUseException {
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable final long id){
        service.delete(id);
    }

    @GetMapping("{id}")
    ClientDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping
    List<ListClientResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }
}
