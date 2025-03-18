package com.br.barberapi.service.impl;

import com.br.barberapi.entity.ClientEntity;
import com.br.barberapi.exception.PhoneInUseException;
import com.br.barberapi.repository.IClientRepository;
import com.br.barberapi.service.IClientService;
import com.br.barberapi.service.query.IClientQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClientQueryService queryService;

    @Override
    public ClientEntity save(ClientEntity client) throws PhoneInUseException {
        queryService.verifyEmail(client.getEmail());
        queryService.verifyPhone(client.getPhone());

        return repository.save(client);
    }

    @Override
    public ClientEntity update(ClientEntity client) throws PhoneInUseException {
        queryService.verifyEmail(client.getId(), client.getEmail());
        queryService.verifyPhone(client.getId(), client.getPhone());

        var stored = queryService.findById(client.getId());
        stored.setName(client.getName());
        stored.setPhone(client.getPhone());
        stored.setEmail(client.getEmail());
        return repository.save(stored);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);

    }
}
