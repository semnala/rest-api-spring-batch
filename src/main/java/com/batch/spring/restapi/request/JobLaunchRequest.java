package com.batch.spring.restapi.request;

import lombok.Data;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Properties;

@Data
public class JobLaunchRequest {

    private String name;

    private Properties jobParameters;

    public JobParameters getJobParameters(){
        Properties properties = new Properties();
        properties.putAll(this.jobParameters);
        return new JobParametersBuilder(properties)
                .toJobParameters();
    }
}
