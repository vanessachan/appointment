package com.agenda.repository;

import com.agenda.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends ListCrudRepository<Appointment, Long> {

    List<Appointment> findByPersonId(Long id);

    Optional<Appointment> findAppointmentByIdAndPersonId(Long id, Long personId);
}
