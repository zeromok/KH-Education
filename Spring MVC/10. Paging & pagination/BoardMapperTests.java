package org.zerock.myapp.mapper;


import lombok.Cleanup;
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
import org.zerock.myapp.domain.Criteria;
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

    @Test
    @Order(1)
    @DisplayName("1. BoardMapper.selectAllList test.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelectAllList() throws DAOException {
        log.trace("selectAllList() invoked");

        // 1
//        this.mapper.selectAllList().forEach(log::info);

        // 2
        @Cleanup("clear")
        List<BoardVO> list = this.mapper.selectAllList();
        for(BoardVO vo : list) {
            log.info("\t - vo : {}", vo);
        }
    }

    @Test
    @Order(2)
    @DisplayName("2. BoardMapper.insertSelectKey(dto) test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testInsertSelectKey() throws DAOException {
        log.trace("testInsert() invoked");

        BoardDTO dto = new BoardDTO();
        dto.setTitle("NEW_TITLE");
        dto.setContent("NEW_CONTENT");
        dto.setWriter("NEW_WRITER");

        log.info("\t - 1. dto : {}", dto);
        log.info("\t - 2. result : {}", this.mapper.insertSelectKey(dto) == 1);
        log.info("\t - 3. dto : {}", dto);
    }
    /*
    사용자가 입력한 데이터를 DTO 가 받아 (새로이 입력된 게시글)
     데이터가 들어간 bno 값을 얻어보자
    */

    @Test
    @Order(3)
    @DisplayName("3. BoardMapper.select(dto) test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelect() throws DAOException {
        log.trace("testSelect() invoked");

        BoardDTO dto = new BoardDTO();
        dto.setBno(299);

        log.info("\t - BoardVO : {}", this.mapper.select(dto));
    }

    @Test
    @Order(4)
    @DisplayName("4. BoardMapper.update(dto) test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testUpdate() throws DAOException {
        log.trace("testUpdate() invoked");

        BoardDTO dto = new BoardDTO();
        dto.setBno(79);
        dto.setTitle("UPDATED_TITLE");
        dto.setContent("UPDATED_CONTENT");
        dto.setWriter("UPDATED_WRITER");

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


//    ================================== 페이징처리 테스트 =============================

    @Test
    @Order(6)
    @DisplayName("6. BoardMapper.testSelectListWithPaging test.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testSelectListWithPaging() throws DAOException {
        log.trace("selectListWithPaging() invoked");

        Criteria ct = new Criteria();
        ct.setCurrPage(2);   // 우리가 보고싶은 페이지
        ct.setAmount(10);     // 몇개씩 가져오라

        // 1
//        this.mapper.selectAllList().forEach(log::info);

        // 2
        @Cleanup("clear")
        List<BoardVO> list = this.mapper.selectListWithPaging(ct);

        list.forEach(log::info);

        // 인핸스 포문 사용
//        for(BoardVO vo : list) {
//            log.info("\t == vo : {}", vo);
//        }

    }


    @Test
    @Order(7)
    @DisplayName("7. BoardMapper.GetListWithPaging test.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testGetListWithPaging() throws DAOException {
        log.trace("GetListWithPaging() invoked");

        Criteria ct = new Criteria();
        ct.setCurrPage(1);
        ct.setAmount(10);

        @Cleanup("clear")
        List<BoardVO> list = this.mapper.selectListWithPaging(ct);

        for(BoardVO vo : list) {
            log.info("\t == vo : {}", vo);
        }

    }// end


    @Test
    @Order(8)
    @DisplayName("8. BoardMapper.getTotalCount test.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void getTotalCount() throws DAOException {
        log.trace("getTotalCount() invoked");

        log.info("\t == totalCount : {}", this.mapper.getTotalCount());

    }




}// end class
