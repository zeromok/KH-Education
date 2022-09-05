package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.*;
import org.zerock.myapp.domain.BoardVO;

import java.util.List;


// MyBatis 가 수행할 SQL 문장을 저장하는 자바 인터페이스 => Mapper Interface 라고 부른다.
// MyBatis 가 제공하는 Annotation 의 속성의 SQL 문장을 저장
public interface BoardMapper {

    // MyBatis 가 제공하는 Annotation 들
//    @Select()
//    @Insert()
//    @Update()
//    @Delete()

    @Select("SELECT * FROM tbl_board WHERE bno = #{theBno}")
    public abstract BoardVO selectBoard(@Param("theBno") Integer bno);
    // #{"바인드 변수명"} Type Value(명명은 바인드 변수명과 다르게)

    @Select("SELECT * FROM tbl_board WHERE bno > #{theBno} AND title LIKE '%'||#{search}||'%'")
    public abstract List<BoardVO> bySelectAllBoard(@Param("theBno") Integer bno,
                                                   @Param("search") String title);

}
