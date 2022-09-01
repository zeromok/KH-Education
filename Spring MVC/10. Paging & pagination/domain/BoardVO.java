package org.zerock.myapp.domain;



import lombok.Value;


import java.sql.Timestamp;
import java.util.Date;


@Value
public class BoardVO {

    private Integer bno;
    private String title;
    private String content;
    private String writer;

    /*정보통신망법의 요구사항에 따라, 중요 데이터 테이블에는
    아래와 같이, 레코드가 최초 생성된 시각과 최종 수정된 시각을 유지할 수 있게 컬럼 정의*/
    private Timestamp insertTs;
    private Timestamp updateTs;

}// end class
