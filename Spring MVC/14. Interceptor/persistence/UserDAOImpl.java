package org.zerock.myapp.persistence;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@NoArgsConstructor

@Repository
/*
    이 클래스가 데이터베이스를 받아내는, 조작을 담당하는 객체이구나,빈이구나 역할 부여
    == 영속성 계층을 담당하는 DAO 이다.
*/
public class UserDAOImpl implements UserDAO{

    @Setter(onMethod_ = {@Autowired})
    private SqlSessionFactory sqlSessionFactory;    // sql 문장을 처리해주는 SqlSessionFactory객체 주입


    @Override
    public UserVO selectUser(LoginDTO dto) throws Exception {
        log.trace("======= selectUser() =======");


        SqlSession sqlSession = this.sqlSessionFactory.openSession();   // 로직수행 코드

        try(sqlSession) {

            String namespace = "org.zerock.myapp.persistence.UserDAO";
            String sqlId = "selectUser";
            String sql = namespace + "." + sqlId;

            return sqlSession.<UserVO>selectOne(sql, dto);

        }


    }// selectUser()


    @Override
    public int updateUserWithRememberMe(String userid, String rememberme, Timestamp rememberage) throws Exception {
        log.trace("======= updateUserWithRememberMe() =======");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();   // 로직수행 코드

        try (sqlSession) {

            String namespace = "org.zerock.myapp.persistence.UserDAO";
            String sqlId = "updateUserWithRememberMe";
            String sql = namespace + "." + sqlId;

            /*
                ==== 어떻게 여러 매개변수의 값을, SQL 문장의 바인드변수에 저장할까? ====

                    1. 자바빈 객체로 전달 : Mybatis는 SQL 문장의 바인드변수명(#{이름}) 앞에 get 을 붙여서,
                       get + 바인드변수명해서, get바인드변수명() 메소드를 호출해서 값을 얻어냄

                    2. Map 객체로 전달 : Mybatis는 SQL 문장의 바인드변수명(#{이름}) 을 Map의 Key로 사용
                                         즉, map.get(바인드변수명) 으로 값을 얻어냄
            */
            Map<String, Object> params = new HashMap<>();
            params.putIfAbsent("userid", userid);
            params.putIfAbsent("rememberme", rememberme);
            params.putIfAbsent("rememberage", rememberage);
            /*
                putIfAbsent() : Key값이 존재하는 경우 Map의 Value의 값을 반환하고,
                                Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장하고 Null을 반환
            */

            return sqlSession.update(sql, params);

        }

    }// updateUserWithRememberMe()


    @Override
    public UserVO selectUserByRememberMeCookie(String rememberMeCookie) throws Exception {
        log.trace("===== selectUserByRememberMeCookie() =====");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try (sqlSession) {

            String namespace = "org.zerock.myapp.persistence.UserDAO";
            String sqlId = "selectUserByRememberMeCookie";
            String sql = namespace + "." + sqlId;

            return sqlSession.<UserVO>selectOne(sql, rememberMeCookie);

        }
    }// selectUserByRememberMeCookie()


}// end class
