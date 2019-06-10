package com.quartz.schedule;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.job.QuartzHelloJob;

public class QuartzHelloScheduler {

	/*
	 * 	Scheduler – the primary API for interacting with the scheduler of the framework
		Job – an interface to be implemented by components that we wish to have executed
		JobDetail – used to define instances of Jobs
		Trigger – a component that determines the schedule upon which a given Job will be performed
		JobBuilder – used to build JobDetail instances, which define instances of Jobs
		TriggerBuilder – used to build Trigger instances
	 */
	 public static void main(String[] args) {
	        try {
	        	// scheduler
	            SchedulerFactory schedFact = new StdSchedulerFactory();
	            Scheduler sched = schedFact.getScheduler();
	            sched.start();
	            // job detail
	            JobDetail job = JobBuilder.newJob(QuartzHelloJob.class) // job
	                .withIdentity("helloJob", "grupo1")
	                .build();
	            // trigger que dispara o job
	            Trigger trigger = TriggerBuilder
	                .newTrigger()
	                .withIdentity("triggerDisparaJob", "grupo1")
	                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
	                .build();
	             sched.scheduleJob(job, trigger); // associa o job a trigger
	        } catch (Exception e) {
	            System.err.println("Erro -> " + e.getMessage());
	        }
	    }
}
