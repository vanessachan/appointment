package com.agenda.service;

import com.agenda.model.Appointment;
import org.quartz.SchedulerException;

import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment) throws SchedulerException;

    List<Appointment> listAppointments();

    Appointment findAppointment(Long id);

    void delete(Long id) throws SchedulerException;
}
