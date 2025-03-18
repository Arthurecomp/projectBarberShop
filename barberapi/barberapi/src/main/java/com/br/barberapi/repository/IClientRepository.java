package com.br.barberapi.repository;

import com.br.barberapi.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(final String email);

    boolean existsByPhone(final String phone);

    Optional<ClientEntity> findByEmail(final String email);

    Optional<ClientEntity> findByPhone(final String phone);
}
