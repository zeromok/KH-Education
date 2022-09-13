package org.zerock.myapp.service;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@NoArgsConstructor

@Service
public class SampleServiceImpl implements SampleService{
    /*
        이 서비스 객체가 바로, AOP에서 말하는 Target 객체를 의미함
        핵심 비지니스 로직을 메소드로 구현해 놓은 객체
    */

    @Override
    public Integer doAdd(String op1, String op2) throws Exception {
        /*
            Spring AOP에서 말하는, JoinPoint(Advice가 함께 결합(Join)되어 수행 될 지점이다.)
        */
        log.trace("======= Impl . doAdd() ========");

        return Integer.parseInt(op1) + Integer.parseInt(op2);
    }


    @Override
    public void methodForAroundAdvice() throws Exception {
        log.trace("===== Impl . methodForAroundAdvice() =====");

        Thread.sleep(1000 * 3);
    }


}// end class

