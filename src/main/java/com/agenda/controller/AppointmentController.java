package com.agenda.controller;

import com.agenda.model.Appointment;
import com.agenda.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
//@RequestMapping("appointment")
@RequiredArgsConstructor
public class

AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/appointment")
    public Appointment save(@RequestBody @Valid Appointment appointment) throws SchedulerException {
         return appointmentService.save(appointment);
    }

    @PutMapping("/appointment")
    public void update(@RequestBody Appointment appointment) throws SchedulerException {
        appointmentService.save(appointment);
    }


    @GetMapping(value = "/appointment")
    public List<Appointment> listAll() {

        return appointmentService.listAppointments();

    }

    @DeleteMapping(value= "/appointment/{id}")
    public void delete(@PathVariable Long id) throws SchedulerException {
        appointmentService.delete(id);
    }

    @GetMapping(value= "/appointment/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id){
        return new ResponseEntity<>(appointmentService.findAppointment(id),HttpStatus.OK);
    }

    @GetMapping(path = "/test")
    public String test(Principal principal) {
        return principal.getName();
    }



}
