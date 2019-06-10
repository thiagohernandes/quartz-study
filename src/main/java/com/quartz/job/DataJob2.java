package com.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DataJob2 implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap(); 
        String jobSays = dataMap.getString("jobSays2");
        float myFloatValue = dataMap.getFloat("myFloatValue2"); 
        System.out.println(" 2-------------------Job says: " + jobSays + ", and val is: " + myFloatValue);
    } 
	
}
