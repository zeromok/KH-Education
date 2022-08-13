package org.zerock.myapp.Job;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Log4j2
@NoArgsConstructor
public class JobA implements Job {
    /*
    Job : 수행시켜야 할 일(Task), 자바인터페이스
        : 스케줄링할 실제 작업을 가지는 객체
        : Job(인터페이스)의 구현 클래스 선언 => Job 의 메소드를 오버라이드 받는다.
        : throw 가 있으므로, try 로 감싸는게 좋다.
    */

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("execute() invoked");

        try{

            log.info("\t - Batch Job A executed...");

        } catch (Exception e) {

            throw new JobExecutionException(e);

        }
    }


}
