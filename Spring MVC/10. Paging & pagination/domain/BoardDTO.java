package org.zerock.myapp.domain;


import lombok.Data;

@Data
public class BoardDTO {

    private Integer bno;
    // 값을 받아오는 컬럼이 아니다...PK
    // 쓰지는 않지만 필드로 존재할 필요가 있다.
    // 인서트할 때는 필요 없지만
    private String title;
    private String content;
    private String writer;


}
