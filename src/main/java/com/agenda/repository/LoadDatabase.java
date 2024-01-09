package com.agenda.repository;

import com.agenda.model.Appointment;
import com.agenda.model.Person;
import com.agenda.model.RecurrenciesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

@Configuration
@Slf4j
public class LoadDatabase {

//
//    @Bean
//    CommandLineRunner initDatabase(PersonRepository personRepository, AppointmentRepository appointmentRepository) {
//
//        Person person = new Person(1L, "nessa", "nessa@test.com", null);
//        Person person2 = new Person(2L, "nessa", "nessa@test.com", null);
//
//        return args -> {
//            log.info("Preloading " + personRepository.save(person));
//            log.info("Preloading " + personRepository.save(person2));
//
//            log.info("Preloading " + appointmentRepository.save(new Appointment(1L,"teste1", null,  person,  LocalTime.now(), LocalDate.now(),LocalDate.now(), RecurrenciesEnum.EVERYDAY,null)));
//            log.info("Preloading " + appointmentRepository.save(new Appointment(2L,"teste2", null,  person, LocalTime.now(), LocalDate.now(),LocalDate.now(), RecurrenciesEnum.WEEKLY,null)));
//            log.info("Preloading " + appointmentRepository.save(new Appointment(3L,"teste3", null,  person2,  LocalTime.now(), LocalDate.now(),LocalDate.now(), RecurrenciesEnum.EVERYDAY,null)));
//
//        };
//    }
}

