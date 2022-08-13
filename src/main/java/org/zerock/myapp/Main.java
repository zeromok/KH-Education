package org.zerock.myapp;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

/*
FluentAPI : 메소드 체인을 사용하여 메소드 케스케이딩을 구현
          : 각 메소드가 연결된 개체(this)를 반환하도록 구현
메소드 체인 : OOP 에서 여러 메소드호출을 위한 구문
메소드 케스케이딩 : 동일한 객체에서 여러 메소드를 호출할 수 있도록 해주는 구문
*/

@Accessors(fluent = true, chain = true)
/*
fluent = true : getter(반환값:this.인자값), setter(반환값:this) => default : chain = true
chain = true : 일일이 setMethod 를 생성할 필요 없이 Chain 형태로 이어서 원하는 setMethod 를 생성하게 해준다. => default : true
*/
@Data
/*
@Getter, @Setter, @equals, @hashCode, @ToString
위 어노테이션을 한번에 설정할 수 있는 어노테이션
*/
class FluentAPI {
    private String name;
    private int age;
}
@ToString
@Builder
/*
디자인 패턴 중 하나로 생성자에 파라미터가 많을 때 활용
필드의 순서에 상관없이 원하는 파라미터로 객체를 생성하게 해준다.
*/
class Person {
    private String name;
    private int age;
    private String ssn;
}

@Log4j2
public class Main {
    public static void main(String[] args) {

        FluentAPI api = new FluentAPI();
        api.name("zeromok").age(31);
        // 체인 형태로 메소드를 호출
        log.info(api);

        // =================================================

        Person person = Person.builder()
                                .name("zeromok")
                                .age(31)
                                //.ssn("123456-789999")
                                .build();
        // 객체.builder().메소드(파라미터).build(); 형태로 원하는 메소드를 넣어 이어준다.

        log.info(person);

    }//main
}//class
