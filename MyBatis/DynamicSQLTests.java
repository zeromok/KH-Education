package org.zerock.myapp.persistence;

import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.mapper.BoardMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DynamicSQLTests {

    SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    void befordAll() throws IOException {
        log.trace("==========befordAll 호출==========");

        // MyBatis 의 설정파일에 대한 입력스트림 생성
        String path = "myBatis-config.xml";
        // check code
//        assertNotNull(path);
//        log.info("\t + path : {}",path);

        InputStream is = Resources.getResourceAsStream(path);

        // check code
//        assertNotNull(is);
//        log.info("\t + is : {}",is);

        // 단한번 SqlSessionFactory 객체를 생성해서, 필드에 저장
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();      // 객체생성
        this.sqlSessionFactory = builder.build(is);                             // myBatis 의 설정파일에 대한 입력스트림객체를 넣어달라
        // check code
//        assertNotNull(this.sqlSessionFactory);
//        log.info("\t + this.sqlSessionFactory : {}",this.sqlSessionFactory);
    }

    @Test
    @Order(1)
    @DisplayName("1. testFindBoardByBno")
    @Timeout(value=10, unit= TimeUnit.SECONDS)
    void testFindBoardByBno() {
        log.trace("==========testFindBoardByBno 호출==========");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {

            String namespace = "mappers.Board2Mapper";
            String sqlId = "findBoardByBno";
            String sql = namespace + "." + sqlId;

//            BoardVO board = sqlSession.<BoardVO>selectOne(sql, 99);
//            assertNotNull(board);
//            log.info("\t + board : {}",board);

            List<BoardVO> board = sqlSession.<BoardVO>selectList(sql);
            assertNotNull(board);
            log.info("\t + board : {}",board);
            // if 태그에 where 절이 안으로 들어간다면 List 를 써주는게 좋다. 오류 때문에
            // 바인드 변수가 들어가지 않을경우 결과셋이 너무 많아져 버려 list 로 받아야 한다.

        }
    }


    @Test
    @Order(2)
    @DisplayName("2. testFindBoardByTitle")
    @Timeout(value=10, unit= TimeUnit.SECONDS)
    void testFindBoardByTitle() {
        log.trace("==========testFindBoardByTitle 호출==========");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {
            String namespace = "mappers.Board2Mapper";
            String sqlId = "findBoardByTitle";
            String sql = namespace + "." + sqlId;

            List<BoardVO> list = sqlSession.<BoardVO>selectList(sql, "99");
            list.forEach(log::info);
        }
    }


    @Test
    @Order(3)
    @DisplayName("3. testFindBoardByWriter")
    @Timeout(value=10, unit= TimeUnit.SECONDS)
    void testFindBoardByWriter() {
        log.trace("==========testFindBoardByWriter 호출==========");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {

            String namespace = "mappers.Board2Mapper";
            String sqlId = "findBoardByWriter";
            String sql = namespace + "." + sqlId;

            List<BoardVO> list = sqlSession.<BoardVO>selectList(sql, 11);
            list.forEach(log::info);

//            Objects.requireNonNull(list);
//            log.info("\t + vo : {}", list);
        }
    }


    @Test
    @Order(4)
    @DisplayName("4. testFindBoardByBnoAndTitle")
    @Timeout(value=10, unit=TimeUnit.SECONDS)
    void testFindBoardByBnoAndTitle() {
        log.trace("testFindBoardByWriter invoked");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try (sqlSession) {

            String namespace = "mappers.Board2Mapper";
            String sqlId = "findBoardByBnoAndTitle";
            String sql = namespace + "." + sqlId;


            Map<String, Object> params = new HashMap<>();
            params.put("bno", 100);
            params.put("title", null);

            List<BoardVO> list = sqlSession.<BoardVO>selectList(sql, params);
            Objects.requireNonNull(list);
            list.forEach(log::info);


        }
    }


    @Test
    @Order(5)
    @DisplayName("5. testFindBoardByBnoOrTitle")
    @Timeout(value=10, unit=TimeUnit.SECONDS)
    void testFindBoardByBnoOrTitle() {
        log.trace("==========testFindBoardByBnoOrTitle() 호출==========");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try (sqlSession){

            String namespace = "mappers.Board2Mapper";
            String sqlId = "findBoardByBnoOrTitle";
            String sql = namespace + "." + sqlId;

            // 1. Map 객체를 이용해서 파라미터 넣어주기
//            Map<String, Object> params = new HashMap<>();
//            params.put("bno", 100);
//            params.put("title", 7);

            // 2. 자바빈즈 객체를 이용해 넘겨주기
            // SQL 문장의 바인드변수에 전달할 값을 가지는 자바빈즈 클래스 선언
            @Data
            class BinArguments {        // local Class
                private Integer bno;
                private String title;
            }
            BinArguments args = new BinArguments();
            args.setBno(200);
            args.setTitle("1");

            List<BoardVO> list = sqlSession.<BoardVO>selectList(sql, args);
            list.forEach(log::info);
        }

    }

    @Test
    @Order(6)
    @DisplayName("6. testFindBoardByBnos")
    @Timeout(value=10, unit=TimeUnit.SECONDS)
    void testFindBoardByBnos() {
        log.trace("testFindBoardByBnos invoked");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try (sqlSession) {

            String namespace = "mappers.Board2Mapper";
            String sqlId = "findBoardByBnos";
            String sql = namespace + "." + sqlId;

            // List 컬렉션을 만들고, 이 안에 여러개의 BNO 값 저장하여 전달
            List<Integer> bnos = Arrays.asList(1,2,3,4,5);

            List<BoardVO> list = sqlSession.<BoardVO>selectList(sql, bnos);
            list.forEach(log::info);
        }


    }

}
