package com.quartz.schedule;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.job.DataJob;
import com.quartz.job.DataJob2;

public class DataScheduler {
	 public static void main(String[] args) {
	        try {
	        	SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	        	Scheduler scheduler = schedulerFactory.getScheduler();
	        	scheduler.start();
	        	JobDetail job = JobBuilder.newJob(DataJob.class)
	        			  .withIdentity("myJob", "group1")
	        			  .usingJobData("jobSays", "Hello World!")
	        			  .usingJobData("myFloatValue", 3.141f)
	        			  .build();
	        	JobDetail job2 = JobBuilder.newJob(DataJob2.class)
	        			  .withIdentity("myJob2", "group2")
	        			  .usingJobData("jobSays2", "Done crazy brother")
	        			  .usingJobData("myFloatValue2", 5.77f)
	        			  .build();
	        	Trigger triggerA = TriggerBuilder.newTrigger()
	        			  .withIdentity("triggerA", "group1")
	        			  .startNow()
	        			  .withPriority(3)
	        			  .withSchedule(SimpleScheduleBuilder.simpleSchedule()
	        			    .withIntervalInSeconds(10)
	        			    .repeatForever())
	        			  .build();
    			Trigger triggerB = TriggerBuilder.newTrigger()
		    			  .withIdentity("triggerB", "group1")
		    			  .startNow()
		    			  .withPriority(2)
		    			  .withSchedule(SimpleScheduleBuilder.simpleSchedule()
		    			    .withIntervalInSeconds(20)
		    			    .repeatForever())
		    			  .build();
    			scheduler.scheduleJob(job, triggerA);
    			scheduler.unscheduleJob(triggerA.getKey());
    			scheduler.scheduleJob(job2, triggerB);	
    			
	        } catch (Exception e) {
	            System.err.println("Erro -> " + e.getMessage());
	        }
	    }
}
