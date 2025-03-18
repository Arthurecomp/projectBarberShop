package com.br.barberapi.service.query.impl;

import com.br.barberapi.entity.ClientEntity;
import com.br.barberapi.exception.NotFoundException;
import com.br.barberapi.exception.PhoneInUseException;
import com.br.barberapi.repository.IClientRepository;
import com.br.barberapi.service.query.IClientQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ClientQueryService implements IClientQueryService {

    private IClientRepository clientRepository;

    @Override
    public ClientEntity findById(long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ClientEntity> list() {
        return clientRepository.findAll();
    }

    @Override
    public void verifyPhone(String phone) throws PhoneInUseException {
        if(clientRepository.existsByPhone(phone)) {
            var message = String.format("Phone %s already exists!", phone);
            throw new PhoneInUseException(message);
        }

    }

    @Override
    public void verifyPhone(long id, String phone) throws PhoneInUseException {
        var optional = clientRepository.findByPhone(phone);
        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), phone)) {
            var message = "O telefone " + phone + " já está em uso";
            throw new PhoneInUseException(message);
        }

    }

    @Override
    public void verifyEmail(String email) throws PhoneInUseException {
        if (clientRepository.existsByEmail(email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new PhoneInUseException(message);
        }

    }

    @Override
    public void verifyEmail(long id, String email) throws PhoneInUseException {
        var optional = clientRepository.findByEmail(email);
        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new PhoneInUseException(message);
        }
    }
}
