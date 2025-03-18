package com.br.barberapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table( name = "SCHEDULES")
@Getter
@Setter
@ToString
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_at", nullable = false)
    private OffsetDateTime startAt;

    @Column(name = "end_at", nullable = false)
    private OffsetDateTime endAt;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client = new ClientEntity();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(startAt, that.startAt) && Objects.equals(endAt, that.endAt) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startAt, endAt, client);
    }



}
