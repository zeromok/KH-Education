package org.zerock.myapp.service;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
// 스프링을 테스트와 함께 구동하도록 해주는 어노테이션
@ContextConfiguration(locations = {
        /*
        필요한 스프링 설정파일을 등록해준다.
        이때 file: 이 사용되는데, 이 file: == 프로젝트폴더
        공백없이 설정한다.
        */
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class UserServiceTests {


    @Setter(onMethod_= {@Autowired} )
    private UserServiceImpl service;

    @Test
    @DisplayName("1. findUser")
    @Order(1)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void findUser() throws Exception {
        log.trace("====== service > findUser() ======");

        LoginDTO dto = new LoginDTO();
        dto.setUserid("USER_1");
        dto.setUserpw("PASS_1");

        UserVO vo = this.service.findUser(dto);
        log.debug("\t - vo : {}", vo);

//        log.debug("\t - Result : {}", this.service.findUser(dto));

    }


    @Test
    @DisplayName("2. modifyUserWithRememberMe")
    @Order(2)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void modifyUserWithRememberMe() throws Exception {
        log.trace("====== service > modifyUserWithRememberMe() ======");

        String userid = "USER_1";
        String rememberme = "4DD335C0E975DF18372344CC6AF86D12";
        // 인증성공한 웹브라우저의 세션ID

        final int maxAge = 1*60*60*24*7;
        long now = System.currentTimeMillis();
        long expiry = now + (maxAge*1000L);

        Timestamp rememberage = new Timestamp(expiry);

        boolean ismodified = this.service.modifyUserWithRememberMe(userid, rememberme , rememberage);
        log.debug("updateCount : {}", ismodified);

    }


}// end class
