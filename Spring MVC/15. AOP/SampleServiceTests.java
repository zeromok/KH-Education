package org.zerock.myapp.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
// 스프링을 테스트객체와 함께 구동하도록 해주는 어노테이션

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
/*
    필요한 스프링 설정파일을 등록해준다.
    이때 file: 이 사용되는데, 이 file: == 프로젝트폴더
    공백없이 설정한다.
*/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class SampleServiceTests {

    @Setter(onMethod_ = {@Autowired})
    private SampleService service;
    // 서비스 객체 주입 받기

    @BeforeAll
    public void beforAll() {
        log.trace("======= Test . beforAll() =======");

        Objects.requireNonNull(this.service);
        log.info("this.sevice : {}", this.service);
        log.info("type : {}", this.service.getClass().getName());

    }

//    @Test
//    public void dummyTest() {;;}

    @Test
    @DisplayName("1. SampleService . doAdd ")
    @Order(1)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void doAdd() throws Exception {
        log.trace("======= Test . doAdd() =======");

        int result = this.service.doAdd("10", "20");
        log.info("result : {}", result);

    }


    @Test
    @DisplayName("2. SampleService . methodForAroundAdvice")
    @Order(2)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void methodForAroundAdvice() throws Exception {
        log.trace("====== SampleServiceTests . methodForAroundAdvice() ======");

        this.service.methodForAroundAdvice();

    }


}//end class
