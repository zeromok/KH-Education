package org.zerock.myapp.persistence;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.zerock.myapp.mapper.TimeMapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TImeMapperTests {
    // MyBatis 의 자동 SQL 문장실행 기능실습

    SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    void beforAll() throws IOException {
        log.trace("====================beforeAll() 호출====================");

        String path = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(path);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        this.sqlSessionFactory = builder.build(is);
        //check code
        Objects.requireNonNull(this.sqlSessionFactory);
        log.info("\t + this.sqlSessionFactory : {}", this.sqlSessionFactory);
    }

    @Test
    @Order(1)
    @DisplayName("1. testGetCurrentTime1")
    @Timeout(value=10, unit= TimeUnit.SECONDS)
    void testGetCurrentTime1() throws SQLException {
        log.trace("====================beforeAll() 호출====================");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {

            TimeMapper mapper = sqlSession.<TimeMapper>getMapper(TimeMapper.class);
            String now = mapper.getCurrentTime1();
            // check code
            assert now != null;
            log.info("\t + now : {}", now);

        }

    }
}
