package org.zerock.myapp.service;


import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;

import java.sql.Timestamp;

public interface UserService {
    // 서비스 계층의 구현

    public abstract UserVO findUser(LoginDTO dto) throws Exception;
    // 1. 전송받은 사용자의 아이디와 암호로 사용자 정보를 획득


    public abstract Boolean modifyUserWithRememberMe(String userid, String rememberme, Timestamp rememberage) throws Exception;
    // 2. 자동로그인 쿠키값과 이 쿠키의 만료일자 컬럼들 설정
    // DTO 를 쓰지 않았다.
    /*
        특정유저의 쿠키와 관련된 컬럼을 바꾸는 것이므로, 성공했냐 안했냐 로 구분
        즉, Boolean 으로 반환타입을 정해준다.
    */


    public abstract UserVO findUserByRememberMeCookie(String rememberMeCookie) throws Exception;
    // 3. 인자값으로 받은 자동로그인 쿠키값으로, UserVO객체를 만들어 반환


}
