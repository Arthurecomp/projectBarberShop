package com.br.barberapi.service.query;

import com.br.barberapi.entity.ScheduleEntity;
import com.br.barberapi.exception.ScheduleInUseException;

import java.time.OffsetDateTime;
import java.util.List;

public interface IScheduleQueryService {
    ScheduleEntity findById(long id);

    List<ScheduleEntity> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt);

    void verifyScheduleExist(OffsetDateTime startAt, OffsetDateTime endAt) throws ScheduleInUseException;


}
