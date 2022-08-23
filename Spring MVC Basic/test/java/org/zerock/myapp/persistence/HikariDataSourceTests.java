package org.zerock.myapp.persistence;


import com.zaxxer.hikari.HikariDataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class HikariDataSourceTests {

    @Setter(onMethod_= {@Autowired} )
    private DataSource dataSource;
    // DataSource 를 주입받을 필드를 선언


    @BeforeAll
    void beforeAll() {
        // 필드에 원하는 타입의 Bean 객체가 잘 주입 되었는지 확인해보자
        log.debug("beforeAll() invoked");

        Objects.requireNonNull(this.dataSource);
        log.debug("\t - this.dataSource : {}", this.dataSource);
        //  - this.dataSource : HikariDataSource (*** HikariDataSource ***)

    }//beforeAll

    @Test
    void dummyTest() {
        ;;
    }

    @Test
    @DisplayName("1. javax.sql.DataSource.getconnection() test.")
    @Order(1)
    @Timeout(value = 10, unit= TimeUnit.SECONDS)
    void testGetConnection() throws SQLException {
        // 위에서 얻은 CP 를 이용해 Connection 을 얻어보자
        log.debug("1. testGetConnection() invoked");

        Connection conn = this.dataSource.getConnection();
        /*
        예외는 던져주자
        CP 에서 얻은 Connection
        Autocloseable 한 자원객체 이므로 다쓰고나면 close() 해줘야한다.
        */

        try(conn) {

            Objects.requireNonNull(conn);
            log.debug("\t - conn : {}, type : {}", conn, conn.getClass().getName());
            /*
            type : com.zaxxer.hikari.pool.HikariProxyConnection
            여기서 중요한? Proxy 가 나오는데 초심자가 알기에는 깊은주제라 간단하게만 말하고 넘어갔다.
            Proxy : 대리인 무엇을? 연결을 대리해주는?
            */

        }//try-with-resource

        conn.close();
        /*
        여기서의 close() 의 의미는 연결을 닫아버리는게 아닌 빌려온 Connection 의 반납을 의미
        만약 테스트 이후에 또 다른 테스트가 있다면 여기서 close() 를 해주면 안된다.
        */

    }//1.testGetConnection


    @Test
    @DisplayName("2. javax.sql.DataSource.getconnection() method with SQL test.")
    @Order(2)
    @Timeout(value = 10, unit= TimeUnit.SECONDS)
    void testGetConnectionWithSQL() throws SQLException {
        // SQL 쿼리를 던져 테스트 해보자
        log.debug("2. javax.sql.DataSource.getconnection() method with SQL test.");

        Connection conn = this.dataSource.getConnection();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT *FROM employees");

        try(conn; stmt; rs) {

            while (rs.next()) {

                // rs.getXXX(컬럼명)에서, 컬럼명은 대소문자 구분하지 않음
                // rs.getString(컬럼명)에서, rs.getString 메소드는 만능 임 (실제 컬럼 타입 무시하고 다문자열로 컬럼값 획득 가능)
                String employee_id = rs.getString("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String hire_date = rs.getString("hire_date");
                String job_id = rs.getString("job_id");
                String salary = rs.getString("salary");
                String commission_pct = rs.getString("commission_pct");
                String department_id = rs.getString("department_id");

                log.info("{}, {}, {}, {}, {}, {}, {}, {}, {}, {} ",
                        employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, department_id);

            }
        }//try-with-resource

    }


    @AfterAll
    void afterAll() {
        log.debug("afterAll() invoked");

        // How to close();
        ((HikariDataSource)this.dataSource).close();

    }



}
