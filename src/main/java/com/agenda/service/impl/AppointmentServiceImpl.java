package com.agenda.service.impl;

import com.agenda.SecurityUser;
import com.agenda.exception.NotFoundException;
import com.agenda.model.Appointment;
import com.agenda.repository.AppointmentRepository;
import com.agenda.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final SchedulerService schedulerService;


    @Override
    @Transactional
    public Appointment save(Appointment appointment) throws SchedulerException {
        appointment.setPerson(SecurityUser.currentUser());
        Appointment appointmentSaved = appointmentRepository.save(appointment);
        schedulerService.schedulJob(appointmentSaved);
        return appointmentSaved;
    }

    @Override
    public List<Appointment> listAppointments() {
        return appointmentRepository.findByPersonId(SecurityUser.getCurrentUserId());
    }

    @Override
    public Appointment findAppointment(Long id) {
        return appointmentRepository.findAppointmentByIdAndPersonId(id, SecurityUser.getCurrentUserId()).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(Long id) throws SchedulerException {
        schedulerService.deleteJob(id);
        appointmentRepository.deleteById(id);
    }


}
