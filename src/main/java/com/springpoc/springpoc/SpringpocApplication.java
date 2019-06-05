package com.springpoc.springpoc;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.batch.core.Job;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringpocApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringpocApplication.class, args);
	}

	@Override
	public void run(String... args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

//		String[] springConfig = {"spring/spring-job.xml"};
//
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springConfig);
//
//		JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
//
//		Job job = (Job) applicationContext.getBean("testJob");
//
//		try {
//
//			JobParameters jobParameters = new JobParametersBuilder()
//					.addString("age", "20")
//					.toJobParameters();
//
//			JobExecution execution = jobLauncher.run(job, jobParameters);
//			System.out.println("Exist status : " + execution.getStatus());
//			System.out.println("Exist status : " + execution.getAllFailureExceptions());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Done");
//		System.exit(-1);

//		Map<String, JobParameter> maps = new HashMap<>();
//		maps.put("time", new JobParameter(System.currentTimeMillis()));
//
//		JobParameters parameters = new JobParameters(maps);
//		JobExecution jobExecution = jobLauncher.run(job, parameters);
//
//		System.out.println("Batch is running");
//		while (jobExecution.isRunning()) {
//			System.out.println("...........");
//		}
//
//		System.out.println("JobExecution: " + jobExecution.getStatus());
//		System.exit(-1);
	}
}
