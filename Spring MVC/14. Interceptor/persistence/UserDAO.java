package org.zerock.myapp.persistence;


import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;

import java.sql.Timestamp;

public interface UserDAO {
    /*
        핸들러메소드를 정의하기 위해서 DB를 직접 이용하지는 않지만
        로그인 처리를 하려면 View에서 DB로 인증처리를 위한 로직이 구현되어있어야 한다.
        먼저 영속성계층의 DAO구현을 해보자
        + Mybatis의 인터페이스 방식을 쓰지않는 방법
    */

    public abstract UserVO selectUser(LoginDTO dto) throws Exception;
    // 1. 로그인 창에서 입력한 아이디/암호에 해당하는 사용자 정보 획득


    public abstract int updateUserWithRememberMe(String userid, String rememberme, Timestamp rememberage) throws Exception;
    // 2. 자동로그인 쿠키값과 이 쿠키의 만료일자 컬럼들 설정
    // DTO를 쓰지 않은 방법


    public abstract UserVO selectUserByRememberMeCookie(String rememberMeCookie) throws Exception;
    // 3. 인자값으로 받은 자동로그인 쿠키값으로, UserVO객체를 만들어 반환

}// end interface
