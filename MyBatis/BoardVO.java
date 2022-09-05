package org.zerock.myapp.domain;

import lombok.Data;
import lombok.Value;

import java.sql.Timestamp;

@Value
public class BoardVO {

    // VO(Value Object) class 의 필드는 외부에서 접근못하게 private 해야 하며,
    // 그 타입은 기본타입을 사용해서는 안된다. (NULL 값을 표현할 수 없기 때문에)
    // 또한, 테이블의 컬럼의 순서와 일치해서 필드의 순서를 맞춰줘야 한다.
    // 필드명은 컬럼과 같게 대문자이지만 파이널 상수의 명명 규칙에 위배되므로 소문자로 해준다.
    private Integer bno;
    private String title;
    private String content;
    private String writer;
//    private Data INSERT_TS;
//    private Timestamp UPDATE_TS;
    // 지금 넣지 않는다 굳이 보여줄 정보가 아니여서
}
