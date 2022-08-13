package org.zerock.myapp;

import lombok.extern.log4j.Log4j2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.zerock.myapp.Job.SimpleJob;
import org.zerock.myapp.listener.JobListenerImpl;
import org.zerock.myapp.listener.SchedulerListenerImpl;
import org.zerock.myapp.listener.TriggerListenerImpl;

@Log4j2
public class QuartzExample {
    public static void main(String[] args) {
        log.debug("Main() invoked");

        try{
//        	============================================
//        	1. To create A Quartz job scheduler
//             작업 스케줄을 생성해보자
//        	============================================

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            /*
            Std : 스탠다드를 의미
            스케줄공장에서 빌더를 호출해 스케줄 객체 생성
            이 순간 멀티쓰레드 기반으로 돌아간다.
            */
            log.debug("\t - scheduler : {}", scheduler);


//        	============================================
//          2. To create A Quartz job with the associated trigger
//             Trigger 를 Job 과 연결해보자
//        	============================================

            // 1. Job Detail 설정
            // Job 에 대한 상세정보를 담고있는 객체이다.

            JobKey simpleJobKey = JobKey.jobKey("simpleJob", "GROUP_1");
            // Job 에 대한 세부정보를 하나로 묶어 키로 활용한다. (현업에서는 키로 쓰는경우가 많다고 한다.)

            JobDetail simpleJob = JobBuilder
                                        .newJob(SimpleJob.class)                                    // JobDetail 정의 / 실행할 Job 설정
                                        .withDescription("SimpleJob")                  // 실행할 Job 에 대한 설명
                                        .withIdentity(simpleJobKey)                                 // Job 에 대한 세부정보
                                        .usingJobData("jobSays", "Hello, World")      // Job 에 전달할 데이터
                                        .usingJobData("myFloatData", 3.14159f)        // Job 에 전달할 데이터
                                    .build();

            //2. Trigger 설정
            /*
            JobDetail 을 언제, 어떻게 실행시킬 것인가? 에 대한 정보
            Job 이 언제 시행될지를 구성하는 객체이다.
            Trigger 는 특정 Job 에 종속적이지 않다.
            */

            TriggerKey simpleJobTriggerKey = TriggerKey.triggerKey("simpleJob", "GROUP_1");
            // Trigger 에 대한 세부정보를 하나로 묶어 키로 활용한다. (현업에서는 키로 쓰는경우가 많다고 한다.)

            Trigger simpleJobTrigger = TriggerBuilder
                                                .newTrigger()           // Trigger 정의
                                                .withDescription("Scheduling for the Simple Job Detail")      // Trigger 에 대한 설명
                                                .withIdentity(simpleJobTriggerKey)         // Trigger 에 대한 세부정보
                                                .withPriority(10)         // Trigger 에 대한 우선순위 설정 (Default=5, max=10)
                                                .startNow()             // Trigger 가 시작되는 시점을 현재시간으로 설정 (실행즉시)
                                                .withSchedule(
                                                        /*
                                                        Trigger 일정을 정의하는 데 사용할 ScheduleBuilder 를 설정
                                                        언제, 어떻게 구동될지
                                                        */
                                                        SimpleScheduleBuilder
                                                                .simpleSchedule()
//                                                                .withIntervalInHours(1)                 // 한 시간에 한번
//                                                                .withIntervalInMinutes()              // 1분에 한번
                                                                .withIntervalInSeconds(1)              // 1초에 한번
//                                                                .withIntervalInMilliseconds()         // milliSeconds
                                                                .withRepeatCount(100)  // 몇회 반복? = 100번
                                                )
                                            .build();


//        	============================================
//          3. To add each listener with Quartz job, trigger, scheduler
//             리스너를 설정해보자
//        	============================================

            ListenerManager lm = scheduler.getListenerManager();

            lm.addJobListener(new JobListenerImpl());
//            lm.addTriggerListener(new TriggerListenerImpl());
//            lm.addSchedulerListener(new SchedulerListenerImpl());


//        	============================================
//          4. To schedule Quartz Jobs with Job and Trigger
//             Job 과 Trigger 를 이용해 스케줄을 예약해보자
//        	============================================

            scheduler.scheduleJob(simpleJob, simpleJobTrigger);
            // 맨 처음에 생성한 작업스케줄 객체에게 Job 에 대한 정보가 들어있는 JobDetail 과 Trigger 객체를 매개값으로 넘겨준다.


//        	============================================
//          5. To start a Quartz Scheduler
//             스케줄을 실행시켜 보자
//        	============================================

            scheduler.start();
            log.debug("\t - Job Scheduler Started.... : {}", scheduler.isStarted());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
