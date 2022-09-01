package org.zerock.myapp.Di;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.Hotel;
import org.zerock.myapp.domain.Restaurant;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
테스트 메소드 수행 시, 스프링 프레임워크도 함계 구동되도록 해주는 어노테이션 설정 추가
*/

// For JUnit v4
/*
@RunWith(SpringRunner.class) or @RunWith(SpringJunit4ClassRunner.class)
*/

// For JUnit v5
@ExtendWith(SpringExtension.class)
// 스프링을 테스트와 함께 구동하도록 해주는 어노테이션
@ContextConfiguration(locations = {
        /*
        필요한 스프링 설정파일을 등록해준다.
        이때 file: 이 사용되는데, 이 file: == 프로젝트폴더
        공백없이 설정한다.
        */
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
@NoArgsConstructor
public class DiTests {
    /*
    이 JUnit 테스트 클래스도, JUnit test framework 에 의해서, 구동시 기본생성자를 이용하여 객체를 생성하고
    이 객체는 자동으로 Spring Beans Container 에 등록된다.
    */

    @Setter(onMethod_= {@Autowired} )
    /*
    이 필드에 대한 setter 메소드를 통한 의존성 주입 방법   + 정공법
    아래 필드에 대해, setter 메소드를 만들고, 그 위에 지정된 어노테이션을 붙여준다.
    */
    private Hotel hotel;

    @Setter(onMethod_= {@Autowired} )
    private Restaurant restaurant;
    /*
    @Resource(type=Chef.class)
    @Resource
    @inject
    @Autowired
    @Setter(onMethod_= {@Autowired})
    의존성 주입 시그널 to Beans container, 전부 다 가능하다.
    */

    @BeforeAll
    void beforeAll() {

        assertNotNull(this.restaurant);
        //Objects.requireNonNull(this.hotel);
        //assert this.hotel != null;
        /*
        객체의 유효성을 검사하는 3가지 방법
        */

        log.debug("\t - this.restaurant : {}", this.restaurant);
        /*
        - this.hotel : Hotel(chef=Chef())
        hotel 의 필드(chef)에는 Chef 객체가 들어있는걸 확인할 수 있다.
        */

        //=============================================================

        assertNotNull(this.restaurant);
        //Objects.requireNonNull(this.hotel);
        //assert this.hotel != null;
        /*
        객체의 유효성을 검사하는 3가지 방법
        */

        log.debug("\t - this.hotel : {}", this.hotel);
        /*
        - this.hotel : Hotel(chef=Chef())
        restaurant 의 필드(chef)에는 Chef 객체가 들어있는걸 확인할 수 있다.
        */
    }

    @Test
    void dummyTest() {
        ;;
    }
}
