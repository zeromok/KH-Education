package org.zerock.myapp.aop;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Log4j2
@NoArgsConstructor

@Aspect
/*
    Spring AOP 역시, Spring Beans Container에 Bean으로 등록되어 운용
    하지만 component scan을 통해, 자동으로 빈으로 등록하지 못한다.
*/
@Component  // 위에 이유로, @Component을 붙여 자동으로 빈으로 등록되게 해준다.
public class LogAdvice { // POJO
    /*
        로그를 남기는 concern(걱정거리)를 구현하는 Advice 이다.
        JoinPoint가 실행되기전에 이 메소드가 수행된다고 로그를 남길 수 있다.
    */

    //    @Before(value = "POINTCUT EXPRESSION")
    @Before(value = "execution( * org.zerock.myapp.service.SampleServiceImpl.doAdd(..) )")
//    @Before(value = "execution( * org.zerock.myapp.service.*ServiceImpl.doAdd(..) )")
//    @Before(value = "execution( * org.zerock.myapp.service.*Service.*(..) )")
    public void logBefore() {

        log.trace("======= 1. LogAdvice . logBefore() =======");

    }// logBefore()
    /*
        Before Advice : Target의 JoinPoint를 호출하기 전에 실행되는 코드
    */


    @Before(value = "execution( * org.zerock.myapp.service.SampleServiceImpl.doAdd(..) ) && args(op1, op2)")
    /*
        doAdd의 매개변수를 얻어낼 수 있다.
    */
    public void logBeforeWithArgs(String op1, String op2) {

        log.trace("======= 2. LogAdvice . logBeforeWithArgs({}, {}) =======", op1, op2);

    }// logBeforeWithArgs()
    /*
        Before Advice : Target의 JoinPoint를 호출하기 전에 실행되는 코드
    */


    @AfterReturning(pointcut = "execution( * org.zerock.myapp.service.SampleServiceImpl.doAdd(..) )", returning = "result")
    /*
        pointcut > value : pointcut이 value 속성을 덮어씌운다.(재정의)
        속성이 하나면 속성명을 넣지 않아도 되지만 그 이상이 되면 넣어줘야 한다.
    */
    public void logAfterReturning(Object result) {
        // returning : 프록시가 JoinPoint(SampleServiceImpl.doAdd()메소드)에서 발생한 결과를 넣어주겠다.

        log.trace("======= 3. LogAdvice . logAfterReturning({}), type : {} =======",result, result.getClass().getName() );

    }// logAfterReturning()
    /*
        AfterReturning Advice : 모든 실행이 정상적으로 이루어 지고 난 후 동작하는 코드
    */


    @AfterThrowing(pointcut = "execution(* org.zerock.myapp.service.*Service.doAdd(..))", throwing = "e")
    public void logAfterThrowing(Exception e) {
        // Throwing : 프록시가 JoinPoint(SampleServiceImpl.doAdd()메소드)에서 발생한 예외를 넣어주겠다.

        log.trace("======= 4. LogAdvice . logAfterThrowing({}) =======", e);

    }
    /*
        AfterThrowing Advice : 예외가 발생한 후 동작하는 코드
                               Retirming 와 Throwing 는 양립할 수 없다.
                               ===============================================
       AOP Advice의 적용방식은 인터셉터로 표현되어 있어 충돌 우려가 있으므로, 인터셉터는 서비스계층에서는 쓰지 않는게 좋다.
       로그메소드가 예외객체(e)를 찍으면 안찍힌다. 대신 스택트레이스가 자동으로 만들어 진다. == e.printStackTrace();
    */


    @After("execution(* org.zerock.myapp.service.*Service.doAdd(..))")
    public void logAfter() {

        log.trace("======= 5. LogAdvice . logAfter() =======");

    }
    /*
        After Advice : 예외가 발생하건 말건 무조건 동작하는 코드
                       무조건 구현되어야 할 기능이 있으면 여기에 구현
    */


    @Around("execution(* org.zerock.myapp.service.*Service.methodForAroundAdvice(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        /*
            ProceedingJoinPoint : 프록시 객체가 넣어주는 데이터 타입, 조인포인트에 접근할 수 있게 해주며,
                                  "조인포인트를 진행시켜라" 하는 명령에 필요한 객체
        */
        log.trace("===== 6. logAround({}, type : {}) =====", pjp, pjp.getClass().getName());

        Object target = pjp.getTarget();            // 조인포인트가 있는 Target객체
        Signature signature = pjp.getSignature();   // 조인포인트의 Method Sinature -> FCQN?
        Object[] args = pjp.getArgs();              // 조인포인트의 매개변수를 배열로 반환

        log.info("\t == taget : {}", target);
        log.info("\t == signature : {}", signature);
        log.info("\t == args : {}", Arrays.toString(args));

        /*
            인스턴스(객체) 메소드는 객체없이는 존재하지는 않는다.
            그러니, 메소드 단독으로는 실행불가
        */

        long start = System.nanoTime();             // 실행 전 .nanoTime() : 현재시간을 10억분의 1초(나노초)로 반환

        Object returnValue = pjp.proceed();     // JoinPoint의 실행

        long end = System.nanoTime();               // 실행 후 .nanoTime() : 현재시간을 10억분의 1초(나노초)로 반환

//        log.info("\t == Elapsed time : {}ns", (end - start) );
//        log.info("\t == Elapsed time : {}초", (end - start) / 1000000000 );    // 단위 : ns -> 초단위로 바꾸려면 10으로 나누면 된다.
        log.info("\t == Elapsed time : {}초", (end - start) / Math.pow(10., 9.) );   // .pow() : 두 번째 인수의 거듭제곱으로 올린 첫 번째 인수의 값을 반환 == 1000000000

        return returnValue;

    }// logAround()



}// end class
