package org.zerock.myapp.service;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.exception.ServiceException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@NoArgsConstructor

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
public class BoardServiceTests {

    @Setter(onMethod_= {@Autowired} )
    private BoardService service;
    // 우리가 테스트할 객체를 주입 받자

    @BeforeAll
    void beforeAll() {
        log.trace("beforeAll() invoked.");

        assertNotNull(this.service);
        log.info("\t - this.service : {}", this.service);

    }

    @Test
    @Order(1)
    @DisplayName("1. GetList test")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testGetList() throws ServiceException {
        log.trace("testGetList() invoked.");


        List<BoardVO> list = this.service.getList();
        list.forEach(log::info);
    }


    @Test
    @Order(2)
    @DisplayName("2. register test")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testRegister() throws ServiceException {
        log.trace("testRegister() invoked.");

        // BoardDTO 객체생성
        BoardDTO dto = new BoardDTO();
        dto.setTitle("TITLE_NEW");
        dto.setContent("CONTENT_NEW");
        dto.setWriter("WRITER_NEW");

        log.info("\t - result : {}", this.service.register(dto));

    }


    @Test
    @Order(3)
    @DisplayName("3. modify test")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testModify() throws ServiceException {
        log.trace("testModify() invoked.");

        BoardDTO dto = new BoardDTO();
        dto.setBno(305);
        dto.setTitle("NEW_TITLE");
        dto.setContent("NEW_CONTENT");
        dto.setWriter("NEW_WRITER");

        log.info("\t - result : {}", this.service.modify(dto));

    }


    @Test
    @Order(4)
    @DisplayName("4. remove test")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testRemove() throws ServiceException {
        log.trace("testRemove() invoked.");

        BoardDTO dto = new BoardDTO();
        dto.setBno(305);

        log.info("\t - result : {}", this.service.remove(dto));

    }

    @Test
    @Order(5)
    @DisplayName("5. get test")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testGet() throws ServiceException {
        log.trace("testGet() invoked.");

        BoardDTO dto = new BoardDTO();
        dto.setBno(301);

        log.info("\t - result : {}", this.service.get(dto));

    }


}// end class
