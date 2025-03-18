package com.br.barberapi.repository;

import com.br.barberapi.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface IScheduleRepository extends JpaRepository<ScheduleEntity,Long> {

    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(OffsetDateTime startTime, OffsetDateTime endTime);
    boolean existsByStartAtAndEndAt(OffsetDateTime startTime, OffsetDateTime endTime);
}
