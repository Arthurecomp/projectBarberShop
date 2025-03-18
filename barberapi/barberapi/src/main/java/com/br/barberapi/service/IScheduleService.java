package com.br.barberapi.service;

import com.br.barberapi.entity.ScheduleEntity;
import com.br.barberapi.exception.ScheduleInUseException;

public interface IScheduleService {
    ScheduleEntity save(final ScheduleEntity schedule) throws ScheduleInUseException;
    void delete(final long id);
}
