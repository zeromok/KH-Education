package org.zerock.myapp.domain;

import lombok.Data;

@Data
// 이 어노테이션을 붙인 클래스는 자바빈즈 규약을 지키는 클래스

// DTO 클래스는 그저 자바빈즈 클래스이면 됨
// 이 DTO 클래스는 왜 만들었냐? => 컨트롤의 핸들러 메소드에서, 전송파라미터들을 한방에 수집
public class ParamsDTO {

    // 모든 필드는 private
    // 각 필드에 대해 @게터/@세터
    // @ToString, @NoArgs...
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    // 주의 : 전송파라미터의 이름과 DTO 객체의 필드명이 같아야 데이터를 잘 받을 수 있다.
    /*
    DTO 클래스의 모든 필드의 타입은 반드시 기본타입을 사용해서는 안됩니다!
   사유: 전송되지 않은 파라미터의 값을 표현하거나
        전송파라미터의 이름이 틀릴때, 이 필드에는
        null 값이 입력가능해야 하나, 기본타입은 null
        값을 저장할 수 없기 때문입니다.
    */

}// end class
