package com.batch.spring.restapi.controller;

import com.batch.spring.restapi.request.JobLaunchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 요청(Request)파라미터에서 잡 이름과 잡 파라미터를 받아들어 적절한 잡을 실행시키는 컨트롤러
 */
@RestController
@RequiredArgsConstructor
public class JobLaunchingController {

    private final JobLauncher jobLauncher;

    private final ApplicationContext context;

    @PostMapping("/run")
    public ExitStatus runJob(@RequestBody JobLaunchRequest request) throws Exception{
        Job job = this.context.getBean(request.getName(), Job.class);

        return this.jobLauncher.run(job, request.getJobParameters())
                .getExitStatus();
    }

}
