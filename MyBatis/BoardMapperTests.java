package org.zerock.myapp.persistence;


import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.mapper.BoardMapper;
import org.zerock.myapp.mapper.TimeMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardMapperTests {

    // mybatis 의 핵심 객체 : 모든 SQL 의 시작
    private SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    void beforeAll() throws IOException {
        log.trace("beforeAll 메소드 호출");

        // 1. mybatis-config.xml 파일에 대한 InputStream 객체 생성
        String path = "mybatis-config.xml";
//        @Cleanup
        InputStream is = Resources.getResourceAsStream(path);

        // check code
//        Objects.requireNonNull(is);
//        log.info("\t + is : {}", is );

        // 클린업 대신 try-with-resource
        // 클린업은 닫는 순서를 보장해 주지 않는다.
        try(is) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  // 공장을 만들어줄 건설사 호출
            // 단한번 sqlSessionFactory 공장객체를 생성해서 필드에 저장
            this.sqlSessionFactory = builder.build(is);     // myBatis 의 설정파일에 대한 입력스트림 객체를 넣어달라
        }

//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        this.sqlSessionFactory = builder.build(is);

        // check code
//        assertNotNull(this.sqlSessionFactory);
//        assert this.sqlSessionFactory != null;
//        log.info("\t + this.sqlSessionFactory : {}", this.sqlSessionFactory);

    }

    // dummyTest
//    @Test
//    void dummyTest() {;;}

    @Test
    @DisplayName("1. testSelectAllBoard")
    @Order(1)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelectAllBoard() {
        log.trace("testSelectAllBoard() 메소드 호출");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // SqlSession : MyBatis 를 사용하기 위한 기본 Java 인터페이스입니다.
        // 				이 인터페이스를 통해 SQL 명령을 실행하고 매퍼를 가져오며 트랜잭션을 관리할 수 있습니다.
        // sqlSessionFactory 에서 .openSession(); 메소드로 SqlSession 를 찍어낸다.

        // check code
        assert sqlSession != null;
        log.info("\t + sqlSession : {}", sqlSession);

        try(sqlSession) {

            // myBatis 는 아래와 같이, 2개의 값을 이용해서, 다수객의 Mapper XML 파일이 있을 때,
            // 1. 어느 특정 Mapper XML 을 사용할지 결정하고 (by namespace)
            // 2. 다시 결정된 Mapper XML 파일안에 있는 많은 SQL 태그중에, 어느 태그의 SQL 문장을 사용할지를 결정 (by id)
            String namespace = "mokk";          // Mapper XML 파일마다 지정된 이름
            String sqlId = "selectAllBoards";   // 특정 Mapper XML 파일안에 있는 특정 SQL 태그의 식별


            String sql = namespace + "." + sqlId;   // Mapped Statement

            // 1. selectList : 결과셋이 많을때
            // 2. selectOne : 결과셋이 1x1스키마일 때
            List<BoardVO> list = sqlSession.<BoardVO>selectList(sql);
            list.forEach(log::info);
            log.info("\t + type of list : {}", list.getClass());
        }

    }


    @Test
    @DisplayName("2. testGetCurrentTime")
    @Order(2)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testGetCurrentTime() {
        log.trace("testGetCurrentTime 메소드 호출");

        @Cleanup
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        String namespace = "mokk";
        String sqlid = "getCurrentTime";
        String sql = namespace + "." + sqlid;

        String now = sqlSession.<String>selectOne(sql);
        assert now != null;
        log.info("\t + now : {}", now);

    }



//    2. "Mapper Interface" 라는 방식으로, 자바의 인터페이스를 이용해서, SQL 문장을 처리하는 방식
//			- 자바인터페이스의 추상메소드에 저장 ====> Mapper Interface 라고 부른다.
//          - MyBatis 가 제공하는 Annotation 을 추상메소드에 붙여서 이 Annotation 안에 속성으로 SQL 문장을 저장
//			- Annotation 은 MyBatis 라이브러리가 제공

    // 자바인터페이스의 추상메소드 생성 및 Annotation 을 추상메소드에 붙여 속성으로 SQL 문장 저장
    // mybatis-config.xml => Mapper Interface 등록해주기
    @Test
    @DisplayName("3. testSelectBoard")
    @Order(3)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelectBoard() {
        log.trace("testSelectBoard 메소드 호출");

        @Cleanup
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 지정한 Mapper Interface 의 구현객체인 MapperProxy 객체 획득
        // 인터페이스의 구현객체를 만들지 않아도 만들어준다.
        BoardMapper mapper = sqlSession.<BoardMapper>getMapper(BoardMapper.class);

        BoardVO vo = mapper.selectBoard(100);

    }


    @Test
    @DisplayName("4. bySelectAllBoard")
    @Order(4)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void bySelectAllBoard() {
        log.trace("bySelectAllBoard 메소드 호출");

        @Cleanup
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // check code
//        assertNotNull(sqlSession);
//        log.info("sqlSession : {}", sqlSession);

        String namespace = "mokk";
        String sqlId = "bySelectAllBoard";
        String sql = namespace + "." + sqlId;

        Map<String, Object> map = new HashMap<>();
        map.put("theBno", 200);
        map.put("search", 1);

        List<BoardVO> list = sqlSession.selectList(sql, map);
        list.forEach(log::info);


    }


    @Test
    @DisplayName("5. getCurrentTime")
    @Order(5)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void getCurrentTime() {
        log.trace("getCurrentTime 메소드 호출");

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 설정파일에 등록되지 않은 MapperInterface 를 사용하려면?
        // 자바코드로 동적인 Mapper 를 추가해줘야 한다.
        // 1. .getConfiguration(); 메소드로 Configuration 객체를 얻기 -> 설정을 위한 단계 1.
        Configuration config = sqlSession.getConfiguration();
        // check code
        assertNotNull(config);
        log.info("\t + config : {}", config);

        // 2. 설정파일에 등록되지 않은 Mapper Interface 를 동적으로 설정에 추가
        config.<TimeMapper>addMapper(TimeMapper.class);

        // 3. 지정된 Mapper Interface 를 구현한 MapperProxy 구현객체를 얻자
        TimeMapper mapper = sqlSession.getMapper(TimeMapper.class);
        // check code
        assertNotNull(mapper);
        log.info("\t + mapper : {}", mapper);

        // 4. Mapper Interface 에 선언된 추상메소드 호출
        String now = mapper.getCurrentTime();
        assert now != null;
        log.info("\t + now : {}", now);

    }


}// endClass
