package org.zerock.myapp.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.persistence.UserDAO;

import java.sql.Timestamp;


@Log4j2
//@NoArgsConstructor
@AllArgsConstructor

@Service
public class UserServiceImpl implements UserService{

    //    @Setter(onMethod_= {@Autowired} )
    private UserDAO dao;
    /*
        영속성계층을 주입해달라.
        Spring 4.3v 부터 모든 필드를 매개변수로 받는 생성자가 있으면 == @AllArgsConstructor
        @Setter 어노테이션은 안붙여도 된다. 즉, 자동으로 주입된다.
    */


    @Override
    public UserVO findUser(LoginDTO dto) throws Exception {
        log.trace("======= findUser() =======");

        return this.dao.selectUser(dto);
    }

    @Override
    public Boolean modifyUserWithRememberMe(String userid, String rememberme, Timestamp rememberage) throws Exception {
        log.trace("======= modifyUserWithRememberMe() =======");

        return this.dao.updateUserWithRememberMe(userid, rememberme, rememberage) == 1;
    }
    /*
        특정유저의 쿠키와 관련된 컬럼을 바꾸는 것이므로, 성공했냐 안했냐 로 구분
        즉, Boolean 으로 반환타입을 정해준다.
    */


    @Override
    public UserVO findUserByRememberMeCookie(String rememberMeCookie) throws Exception {
        log.trace("===== findUserWithRememberMeCookie() =====");

        return this.dao.selectUserByRememberMeCookie(rememberMeCookie);

    }


}// end class
