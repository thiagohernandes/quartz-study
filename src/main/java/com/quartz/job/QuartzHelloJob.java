package com.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzHelloJob implements Job {
	
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(" -------- Servico executado conforme agendamento -------- ");
    }
    
}