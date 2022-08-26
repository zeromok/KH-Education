package org.zerock.myapp.mapper;


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
import org.zerock.myapp.exception.DAOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class BoardMapperTests {

    // BoardMapper 를 주입받아서, 테스트 수행
    @Setter(onMethod_= {@Autowired})
    private BoardMapper mapper;

    @BeforeAll
    void beforeAll() {
        log.trace("beforeAll() invoked");

        assertNotNull(this.mapper);
        log.info("\t - mapper : {}", this.mapper);

    }

//    @Test
//    void dummyTest() {;;}

    @Test
    @Order(1)
    @DisplayName("1. BoardMapper.selectAllList test.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelectAllList() throws DAOException {
        log.trace("selectAllList() invoked");

        // 1.
//        this.mapper.selectAllList().forEach(log::info);

        // 2.
        List<BoardVO> list = this.mapper.selectAllList();
        for(BoardVO vo : list) {
            log.info("\t - vo : {}", vo);
        }
        }


    @Test
    @Order(2)
    @DisplayName("2. BoardMapper.insert(dto) test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testInsert() throws DAOException {
        log.trace("testInsert() invoked");
    }

    @Test
    @Order(3)
    @DisplayName("3. BoardMapper.select(dto) test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelect() throws DAOException {
        log.trace("testSelect() invoked");

        BoardDTO dto = new BoardDTO();
        dto.setBno(100);


        log.info("\t - this.mapper.select(dto) : {}", this.mapper.select(dto));

    }

    @Test
    @Order(4)
    @DisplayName("4. BoardMapper.update(dto) test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testUpdate() throws DAOException {
        log.trace("testUpdate() invoked");

        BoardDTO dto = new BoardDTO();
        dto.setBno(100);
        dto.setTitle("NEW_TITLE");
        dto.setContent("NEW_CONTENT");
        dto.setWriter("WRITER");

        log.info("\t - result : {}", this.mapper.update(dto));

    }




    @Test
    @Order(5)
    @DisplayName("5. BoardMapper.delete(bno) test.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testDelete() throws DAOException {
        log.trace("testDelete() invoked");

//        BoardDTO dto = new BoardDTO();
//        dto.setBno(33);

        log.info("\t - result : {}",this.mapper.delete(33) == 1);

    }

}// end class
