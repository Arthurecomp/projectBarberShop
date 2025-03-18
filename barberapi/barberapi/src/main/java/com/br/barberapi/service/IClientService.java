package com.br.barberapi.service;

import com.br.barberapi.entity.ClientEntity;
import com.br.barberapi.exception.PhoneInUseException;

public interface IClientService  {

    ClientEntity save(ClientEntity client) throws PhoneInUseException;
    ClientEntity update(ClientEntity client) throws PhoneInUseException;
    void delete(long id);
}
