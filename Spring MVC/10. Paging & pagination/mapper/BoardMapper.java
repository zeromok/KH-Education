package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.DAOException;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

// Mybatis Mapper Interface
public interface BoardMapper {

    // 1. 게시판 테이블의 전체 목록 조회하기   - 어노테이션으로 처리
    @Select("SELECT /*+ index_desc(tbl_board) */ * FROM tbl_board")
    public abstract List<BoardVO> selectAllList() throws DAOException;

    // 2. CREATE - INSERT
    // 새로운 게시글을 등록하자(CREATE)    - Mapper XML 파일로 처리
    public abstract Integer insert(BoardDTO dto) throws DAOException;

    public abstract Integer insertSelectKey(BoardDTO dto) throws DAOException;  // *** : 새로이 입력된 게시글의 bno 를 반환받기를 원하는 경우 (mybatis 가 이러한 기능을 제공)

//    public abstract Integer insert(String title, String content, String writer) throws DAOException;
    // mybatis 가 읽어가는건 Bean, Map 객체이다. 따라서 위 예제는 어렵다.


    // 3. 기존 게시글 상세조회 하기(READ)   - Mapper XML 파일로 처리
    public abstract BoardVO select(BoardDTO dto) throws DAOException;

    // 4. 기존 게시글 업데이트(UPDATE)   - Mapper XML 파일로 처리
    public abstract Integer update(BoardDTO dto) throws DAOException;

    // 5. 기존 게시글 삭제하기(DELETE)   - 어노테이션으로 처리
    @Delete("DELETE FROM tbl_board WHERE bno = #{bno}")
    public abstract Integer delete(@Param("bno") Integer bno) throws DAOException;
    // mybatis 의 규칙 하나 : 바인드변수가 하나일 때 준대로 집어넣는다 그래서 DTO 객체를 넣으면 오류가 난다. 왜? 객체 자체를 집어넣어서...

//    ====================================== 페이징 처리 ========================================

    // 1-1. 새로이 페이징 처리가 적용된, 게시물 목록조회 하기
    public abstract List<BoardVO> selectListWithPaging(Criteria ct) throws DAOException;

    // 6. 총 게시물의 갯수를 반환
    public abstract Integer getTotalCount() throws DAOException;

}// end interface
