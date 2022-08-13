package org.zerock.myapp.domain;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@NoArgsConstructor
// 기본생성자를 만들지 않아도 컴파일러가 생성해 주지만 명시적으로 선언해주는게 좋다.

@Component("chef")
/*
Java Bean 객체를 만들어 준다.
관례상 클래스이름의 소문자
root-context.xml 파일안에 Beans 속성으로 xmlns:context="http://www.springframework.org/schema/context" 설정
    - context 라는 namespace 를 사용하겠다 라는 의미
Beans 태그안에 <context:component-scan base-package="org.zerock.myapp.domain" 설정
    - base-package 안 객체들 중 @Component 이 붙어있음 Bean 으로 등록해준다.
*/
public class Chef {
    ;;
}
