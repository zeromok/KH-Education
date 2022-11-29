package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j2
@NoArgsConstructor
@Controller
/*
    stereotype Annotation : 정형화된 어노테이션
    역할이 정해져있다. (Controller)
    기본적으로 Spring Beans Container 에 등록될 클래스는 자바빈즈 규약을 지키는 "자바빈즈" 클래스이다.
    현재의 클래스의 역할 : Controller 정의
*/
// Base URI 선언
//@RequestMapping("/base/*")    // Wildcard Base URI : 가능한 쓰지 말자
@RequestMapping("/base/")      // Best Base URI
public class SampleController {
    // POJO

    /*
        컨트롤러에 선언되는 메소드 => 컨트롤러의 핸들러(Handler) 메소드라고 부름
        그럼 무엇을 핸들링 하느냐? => 특정 request 를 처리한다.
        => 1.어떤 전송방식(Http method)과 2.어떤 Request URI 를 가지고 들어온 Request 를 처리하겠다 라는 의미
        => 위의 2가지 정보를 설정하는 어노테이션이 바로 @RequestMapping 임
    */
    @RequestMapping(
            path = { "/doA", "/doB" },
            method = { RequestMethod.GET, RequestMethod.POST })
    // /doA, /doB 로 들어온 GET, POST 방식의 Request 를 이 메소드가 처리하겠다.
    // 전송방식(method = ...) 을 삭제해버리면? => Spring 이 제공하는 모든 전송방식에 대하여 이 메소드가 처리하겠다.
    // /.../.../doA 경로를 지정할 수있다. (대소문자를 인식. : case-sensitive) = 가상 URI

    /*
        공통이 되는 URI 를 Base URI 라고 부르고 그 이후 다른 URI 를 상세 URI 라고 부른다.
        Base URI 를 지정할 수 있다.
        전체 요청 URI == Base URI + Detail URI
            1. @RequestMapping("/base/*") => 상세 URI : @RequestMapping("doA") => /base/doA
            2. @RequestMapping("/base/") => 상세 URI : @RequestMapping("/doA") => /base/doA
            3.(사용주의) @RequestMapping("/base") => 상세 URI : @RequestMapping("/doA") => /base/doA
                                                  => 상세 URI : @RequestMapping("doA") => /basedoA (X)
    */
    public void doA() {
        log.debug("doA() invoked.");
    }


    // 1. Mapping URI 로 아무것도 지정하지 않았을 때
//    @RequestMapping("")
    @RequestMapping
     /*
        Request URI = Base URI + Detail URI = "/base/" + "" = /base/
        Request URI = Base URI + Detail URI = "/base/*" = /base/*
        뒤에 Wildcard 가 있기 때문에 어떤 문자가 와도 다 매핑 => 충돌이 일어날 수 있다.
      */
    public void basic() {
        log.debug("basic() invoked.");
    }
    // View 의 이름을 반환하지 않으면(void) Request URI = View 이름


    // 2. GET 방식
    @RequestMapping(
            path = {"/basicGet"},
            method = {RequestMethod.GET}

//            path = "/baseGet",
//            method = RequestMethod.GET
    )
    public void basicGet() {
        log.debug("basicGet() invoked.");
    }


    // 3. POST 방식
    @RequestMapping(
            path = {"/basicGetPost"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public void basicGetPost() {
        log.debug("basicGetPost() invoked.");
    }


    // 4. GET 방식의 단축형 어노테이션
    @GetMapping("/basicOnlyGet")
    // == @RequestMapping(path = "/basicOnlyGet", method = RequestMethod.GET)
    public void basicOnlyGet() {
        log.debug("basicOnlyGet() invoked.");
    }


    // 5. POST 방식의 단축형 어노테이션
    @PostMapping("/basicOnlyPost")
    // == @RequestMapping(path = "/basicOnlyPost", method = RequestMethod.POST)
    public void basicOnlyPost() {
        log.debug("basicOnlyPost() invoked.");
    }


    // 6. .jsp 호출 메커니즘을 알아보자
    /*
        컨트롤러의 핸들러는 아래의 역할 및 값을 반환
        1. 역할 : 요청을 위임받아 처리
        2. 뷰의 이름을 반환
        3. 역할에 따라, 요청을 위임처리한 결과 => Model(비즈니스데이터 / Model = 상자) 생성 및 View 로 전달
    */
    @GetMapping("/ex01")
    // == @RequestMapping(path = "/basicOnlyGet", method = RequestMethod.GET)
    public String ex01() {
        log.debug("ex01() invoked.");

        return "ex01";
         /*
            이게 바로 MVC 패턴에서 View 의 이름
            BY View Resolver Configuration
            /WEB_INF/views/ + ex01 + .jsp == /WEB_INF/views/ex01.jsp
         */
    }


}//end class
