package com.agenda.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@Component
public class SimpleAppointment implements Job {

    private final SimpMessagingTemplate s;

    public SimpleAppointment(SimpMessagingTemplate s) {
        this.s = s;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        s.convertAndSend("/topic/greetings",jobExecutionContext.getJobDetail().getDescription());
        log.info("Job Started-"+ jobExecutionContext.getJobDetail().getDescription() +" at:"+new Date());
    }
}
