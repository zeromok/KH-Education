package org.zerock.myapp.persistence;

import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.EmployeeVO;
import org.zerock.myapp.mapper.EmployeesMapper;
import org.springframework.core.io.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SqlSessionFactoryTests {

    @Setter(onMethod_= {@Autowired} )

//  @Setter(onMethod_= {@Resource(type = PooledDataSource.class)} )
    private SqlSessionFactory sqlSessionFactory;
    // mybatis 에서 가장 중요한 핵심 객체를 받을 필드 선언

//    ===========================1, 2번은 Mapper.xml 파일을 mybatis-config.xml 에 등록해서 테스트
    @BeforeAll
    void beforeAll() {
        log.debug("beforAll() invoked");

        Objects.requireNonNull(this.sqlSessionFactory);
        log.debug("\t - this.sqlSessionFactory : {}", this.sqlSessionFactory);
        // - this.sqlSessionFactory : org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@45658133

    }

    @Test
    void dummyTest() {
        ;;
    }


    @Test
    @DisplayName(" 1. testFirstMapperXML() test. ")
    @Order(1)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testFirsMapperXML() {
        log.debug("1.testFirstMapperXML() invoked");

        @Cleanup
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // MapperStatement 를 결정하기 위한 2가지 요소
        String namespace = "FirstMapper";
        String id = "DQL1";
        String sql = namespace + "." + id;

        List<EmployeeVO> list = sqlSession.selectList(sql, 130);
        list.forEach(log::info);

    }// testFirsMapperXML()


    @Test
    @DisplayName(" 2. testSecondMapperXML() test. ")
    @Order(2)
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSecondMapperXML() {
        log.debug("2. testSecondMapperXML() invoked");

        @Cleanup
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // MapperStatement 를 결정하기 위한 2가지 요소
        String namespace = "SecondMapper";
        String id = "DQL2";
        String sql = namespace + "." + id;

        /*
        SQL 문장의 바인드변수들에 줄 값들을,
        Map 객체(Key 가 바인드변수명)를 만들어 주거나
        자바빈즈객체(Property 가 바인드변수명)를 만들어 주어야 한다.
        */
        @Data
        class Parameters {
            private String email;
            private Double salary;
        }
        Parameters param = new Parameters();
        param.setEmail("%A%");
        param.setSalary(7000.0);

        List<EmployeeVO> list = sqlSession.selectList(sql, param);
        list.forEach(log::info);

    }// testSecondMapperXML()


//    =================================================3, 4번은 mapper 인터페이스를 사용해 테스트
    @Test
    @Order(3)
    @DisplayName("3. testGetAllEmployeesInEmployeesMapper() test.")
    @Timeout(value = 10, unit= TimeUnit.SECONDS)
    void testGetAllEmployeesInEmployeesMapper() {
        log.debug("testFirstMapperXML() invoked");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {
            // mapper 인터페이스를 이용할 때
            EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);

            Objects.requireNonNull(mapper);
            log.info("\t - mapper : {}, type : {}", mapper, mapper.getClass().getName());

            mapper.getAllEmployees().forEach(log::info);

        }

    }// testGetAllEmployeesInEmployeesMapper()


    @Test
    @Order(4)
    @DisplayName("4. testGetAllEmployNames() test.")
    @Timeout(value = 10, unit= TimeUnit.SECONDS)
    void testGetAllEmployNamesInEmployeesMapper() {
        log.debug("testGetAllEmployNames invoked");

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        try(sqlSession) {
            // 인터페이스의 메소드를 자동완성 규칙에 따라 설정
            EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);

            Objects.requireNonNull(mapper);
            log.info("\t - mapper : {}, type : {}", mapper, mapper.getClass().getName());

            mapper.getAllEmployeesNames().forEach(log::info);

        }

    }// testGetAllEmployNamesInEmployeesMapper()

}
