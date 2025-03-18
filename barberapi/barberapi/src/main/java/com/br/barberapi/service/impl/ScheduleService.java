package com.br.barberapi.service.impl;

import com.br.barberapi.entity.ScheduleEntity;
import com.br.barberapi.exception.ScheduleInUseException;
import com.br.barberapi.repository.IScheduleRepository;
import com.br.barberapi.service.IScheduleService;
import com.br.barberapi.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) throws ScheduleInUseException {
        queryService.verifyScheduleExist(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
