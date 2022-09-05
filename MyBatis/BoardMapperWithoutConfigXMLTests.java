package org.zerock.myapp.persistence;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.*;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.mapper.BoardMapper;
import org.zerock.myapp.mapper.TimeMapper;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardMapperWithoutConfigXMLTests {

    private SqlSessionFactory sqlSessionFactory;

    // ==========선처리 작업으로 mybatis 의 설정을 동적으로 생성 (XML 파일없이)==========
    @BeforeAll
    void beforeAll() {
        log.trace("beforeAll() 호출");


        // Connection Pool 을 제공하는 DataSource(javax.sql.DataSource) 를 생성 == 설정파일의 <dataSource type="">
        HikariConfig hikariConfig = new HikariConfig();

        // 기본적인 JDBC Connection 생성을 위한 연결정보 4가지 설정
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@db20220510181325_high?TNS_ADMIN=/Users/mokpro/OPT/OracleCloudWallet/ATP");
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        hikariConfig.setUsername("ADMIN");
        hikariConfig.setPassword("Oracle12345678");

        // Connection Pool 에 대한 설정
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(3);
        hikariConfig.setConnectionTimeout(1000 * 10);
        hikariConfig.setConnectionTestQuery("SELECT 1 FROM dual");

        // HikariConfig DataSource 생성
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);     // 자원객체여서 닫아줘야함
        // check code
        Objects.requireNonNull(hikariDataSource);
        log.info("\t + hikariDataSource : {}, Type : {}", hikariDataSource, hikariDataSource.getClass().getName());

        // TX 관리자 생성
        TransactionFactory txFactory = new JdbcTransactionFactory();
        //check code
        Objects.requireNonNull(txFactory);
        log.info("\t + txFactory : {}", txFactory);

        // 실행환경 1개 생성
        Environment environment = new Environment("development", txFactory, hikariDataSource);
        //check code
        Objects.requireNonNull(environment);
        log.info("\t + environment : {}", environment);

        // Configuration 생성
        Configuration configuration = new Configuration(environment);
        //check code
        Objects.requireNonNull(configuration);
        log.info("\t + configuration : {}", configuration);

        // Configuration 에 Mapper Interface 와 Mapper XML 파일 등록
        configuration.addMappers("org.zerock.myapp.mapper");

        // sqlSessionFactory 생성
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        this.sqlSessionFactory = builder.build(configuration);

    }

    @Test
    @Order(1)
    @DisplayName("1. testGetCurrentTime")
    @Timeout(value = 7, unit = TimeUnit.SECONDS)
    void testGetCurrentTime() {
        log.trace("testGetCurrentTime() 호출");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try (sqlSession) {
            TimeMapper mapper = sqlSession.<TimeMapper>getMapper(TimeMapper.class);
            //check code
            Objects.requireNonNull(mapper);
            log.info("\t + mapper : {}", mapper);

            String now = mapper.getCurrentTime();
            log.info("\t + now : {}", now);
        }
    }


    @Test
    @Order(2)
    @DisplayName("2. testselectAllBoards")
    @Timeout(value = 7, unit = TimeUnit.SECONDS)
    void testSelectAllBoards() {
        log.trace("testselectAllBoards() 호출");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {
            BoardMapper mapper = sqlSession.<BoardMapper>getMapper(BoardMapper.class);
            Objects.requireNonNull(mapper);
            log.info("\t + mapper : {}", mapper);

            BoardVO vo = mapper.selectBoard(100);
            Objects.requireNonNull(vo);
            log.info("\t + vo : {}", vo);
        }
    }



    @Test
    @Order(3)
    @DisplayName("3. testSelectBoard")
    @Timeout(value = 7, unit = TimeUnit.SECONDS)
    void testSelectBoard() {
        log.trace("testSelectBoard() 호출");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession){
            BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
            Objects.requireNonNull(mapper);
            log.info("\t + mapper : {}", mapper);

            List<BoardVO> list = mapper.<BoardVO>bySelectAllBoard(200, "1");
            Objects.requireNonNull(list);
            log.info("\t + list : {}", list);
            list.forEach(log::info);
        }
    }

}//end class
