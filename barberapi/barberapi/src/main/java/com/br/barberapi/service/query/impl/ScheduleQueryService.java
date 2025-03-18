package com.br.barberapi.service.query.impl;

import com.br.barberapi.entity.ScheduleEntity;
import com.br.barberapi.exception.ScheduleInUseException;
import com.br.barberapi.repository.IScheduleRepository;
import com.br.barberapi.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class ScheduleQueryService  implements IScheduleQueryService {

    private IScheduleRepository scheduleRepository;

    @Override
    public ScheduleEntity findById(long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ScheduleEntity> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return scheduleRepository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyScheduleExist(OffsetDateTime startAt, OffsetDateTime endAt) throws ScheduleInUseException {
        if(scheduleRepository.existsByStartAtAndEndAt(startAt, endAt)) {
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }

    }
}
