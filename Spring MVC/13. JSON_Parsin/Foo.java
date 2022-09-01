package org.zerock.myapp.domain;

import lombok.Data;
import lombok.Value;


/*
(주의) Java Object 의 직렬화와 역직렬화를 위해서는 기본생성자와 각 필드에 대한
Getter/Setter 메소드가 있어야 하므로, @Value 어노테이션을 사용하면 안됨
*/
@Value
//@Data                   // DTO, Do NOT use @Value annotation to create a Value Object.
public class Foo {
    private Integer id;
    private String name;

}// end class
