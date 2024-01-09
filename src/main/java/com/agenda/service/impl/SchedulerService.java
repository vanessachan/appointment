package com.agenda.service.impl;

import com.agenda.model.Appointment;
import com.agenda.model.RecurrenciesEnum;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerKey.triggerKey;


@Component
public class SchedulerService {

    @Autowired
    private Scheduler scheduler;




    public void schedulJob(Appointment appointment) throws SchedulerException {

        JobDetail job = buildJobDetail(appointment);

        Trigger trigger = buildTrigger(appointment);

        deleteJob(job);
        scheduler.scheduleJob(job, trigger);
    }

    private void deleteJob(JobDetail job) throws SchedulerException {
        if (scheduler.checkExists(job.getKey())) {

            scheduler.deleteJob(job.getKey());
        }
    }

    public void deleteJob(Long id) throws SchedulerException {
        JobKey jKey = JobKey.jobKey(String.valueOf(id));
        TriggerKey tKey = TriggerKey.triggerKey(String.valueOf(id));
        if (scheduler.checkExists(jKey)) {
            if (scheduler.checkExists(tKey)) {
                scheduler.unscheduleJob(tKey);
            }
            scheduler.deleteJob(jKey);

        }

    }

    private static Trigger buildTrigger(Appointment appointment) {
        int recurrencyHour= (int) Duration.ofHours(appointment.getRecurrency().getRecurrency()* 24L).toMinutes(); ;
        if(appointment.getRecurrency().equals(RecurrenciesEnum.PERSONALIZED)){
           recurrencyHour= (int) Duration.ofHours(appointment.getRecurrencyPersonalized()*24L).toMinutes();
        }
        return newTrigger()
                .withIdentity(String.valueOf(appointment.getId()))
                .startAt(java.sql.Timestamp.valueOf(LocalDateTime.of(appointment.getStartDate(), appointment.getTime())))
                .endAt(java.sql.Timestamp.valueOf(LocalDateTime.of(appointment.getStopDate(), appointment.getTime())))
                .withSchedule(simpleSchedule()
                        .withIntervalInMinutes(recurrencyHour)
                        .repeatForever()
                        .withMisfireHandlingInstructionNextWithRemainingCount())
                .build();
    }

    private JobDetail buildJobDetail(Appointment appointment) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(appointment.getId().toString(), appointment.getName());
        return newJob(SimpleAppointment.class).
                withIdentity(String.valueOf(appointment.getId()))
                .withDescription(appointment.getName())
                .usingJobData(jobDataMap).build();
    }


}
