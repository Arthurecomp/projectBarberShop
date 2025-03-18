package com.br.barberapi.service.query;

import com.br.barberapi.entity.ClientEntity;
import com.br.barberapi.exception.PhoneInUseException;

import java.util.List;

public interface IClientQueryService {
    ClientEntity findById(final long id);

    List<ClientEntity> list();

    void verifyPhone(final String phone) throws PhoneInUseException;
    void verifyPhone(final long id,final String phone) throws PhoneInUseException;
    void verifyEmail(final String email) throws PhoneInUseException;
    void verifyEmail(final long id,final String email) throws PhoneInUseException;

}
