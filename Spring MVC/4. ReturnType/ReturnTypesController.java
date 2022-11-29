package org.zerock.myapp.controller;


import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.myapp.domain.SampleDTO;
import javax.servlet.RequestDispatcher;

@Log4j2
@NoArgsConstructor
// 빈즈컨테이너로 등록되려면 매개변수없는 생성자가 필요

@RequestMapping("/return/")
@Controller
public class ReturnTypesController {

    // 1. void return type
    @GetMapping("/void")
    public void returnVoid() {
        log.debug("returnVoid() invoked.");

        // 뷰이름 : 곧, Request URI(= Base URI + Detail URI 이다.)
        // /return/void
    }


    // 2. String return type
    @GetMapping("/String")
    public String returnString() {
        log.debug("returnString() invoked.");

        return "return/string";
        // /WEB-INF/views/ + return/string + .jsp
    }


    // 2-1. String return type : "redirect:" Keyword
    /*
    http://~:8080/return/redirect
    307 응답메세지 전송( RedirectURI 가 )
    http://~:8080/return/void
    */
    @GetMapping("/redirect")
    public String returnRedirect() {
        log.debug("returnRedirect() invoked.");

        // 307 리다이렉션 응답전송을 의미함
//        return "redirect:/return/void";
//        return "redirect:void";       // base URI 생략
        return "redirect:http://naver.com";     // 외부 URI 로 리다이렉트 수행

    }


    // 2-2. String return type : "forward:" Keyword
    /*
    redirect 와는 다르게 주소창의 주소가 변하지 않는다.
    */
    @GetMapping("/forward")
    public String returnForward() {
        log.debug("returnForward() invoked.");

        // Servlet 에서 우리가 직접 Request Forwarding 수행시 코드는 아래와 같음
//        RequestDispatcher dis = request.getRequestDispatcher(target_uri);
//        dis.forward(req, res);

//        return "forward:/WEB-INF/views/return/void.jsp";
//        return "forward:/return/void";
//        return "forward:void";
//        return "forward:http://naver.com";    // XX
        /*
        주의
        redirect 와는 다르게 외부 URI 는 허용 X
        포워드는 떠넘기는 것 떠넘기는 범위는 같은 바운더리(웹컴포넌트, 컨트롤러) 안에서만...
        redirect 는 처음부터 다른 URI 에 전달
        */
        return "forward:/base/basicGet";
        // 같은 웹어플리케이션내의 다른 컨트롤러 핸들러에게 넘기는 경우 = 가능

    }


    // 3. Object return type using @ResponseBody
    // To return JSON format document
    /*
    리턴 타입으로 객체를 넣어 반환해 줄 수 는 있지만, 웹브라우저는 객체를 이해하지 못한다. = 406에러
    */
    @GetMapping("/ResponseBody")
     // 1. @ResponseBody 을 붙이면 응답메소드 바디에 넣어 전달
//    public @ResponseBody SampleDTO returnResponseBody(

    // 2. @ResponseBody 반드시 필요하지는 않다. 붙이지 않으면 모델상자 없이 자바객체를 전달. (model 없는 model)
    public SampleDTO returnResponseBody( @NonNull @RequestParam("name") String NAME,
                                         @NonNull @RequestParam("age") Integer AGE ) {
        log.debug("returnResponseBody({}, {}) invoked.", NAME, AGE);

        SampleDTO dto = new SampleDTO();
        dto.setName(NAME);
        dto.setAge(AGE);

        log.info("\t - dto : {}", dto);

        /*
        반환할 자바객체를, 표현가능한 문서형식(예 JSON/XML)으로 변환해서, 응답메시지의 바디에 넣어서 전달
        해줘야 한다. 그래야 406(Not Acceptable) 오류가 발생하지 않는다.
        하지만, 이를 위해서는, 소위 "변환"라이브러리(== Data-binding libraries)가 필요
        스프링에서 가장많이 사용하는 Data-binding libraries 는 Jackson 계열의 라이브러리를 사용
        이 라이브러리는 pom.xml 파일에 추가 (자바객체 -> JSON/XML 로 변환)
        */
        return dto;
        // 일반 참조타입의 자바객체를 반환하는 경우
    }


    // 4. Object return type using @ResponseEntity
    // TO return JSON format document including User-defined HEADERS and BODY, HTTP status
    @GetMapping("/ResponseEntity")
    public ResponseEntity<String> returnResponseEntity() {
        log.debug("returnResponseEntity() invoked.");

//        String json = "{ 'name':'mee', 'age':30 }";

        /*@Data
        class Person {      // 메소드 블록 안에 선언된 클래스 = 지역클래스 (local class)
            private String name = "mee";
            private Integer age = 30;
            private Double weight = 58.5;
            private Double height = 175.5;
        }*/
        // 메소드 블록 안에 선언하면 null 이 나옴
        // 메소드 블록 밖에 선언하면 잘 나옴

        SampleDTO dto = new SampleDTO();
        dto.setName("mee");
        dto.setAge(30);
        // 위 객체를 JSON 으로 변환해 실습해보자

        Person person = new Person();

        Gson gson = new Gson();

//        String  json = gson.toJson(dto);
        String  json = gson.toJson(person);
        // GSON 라이브러리를 통해 객체 -> JSON 으로 변환
        // 리턴타입 : 문자열 = JSON 문자열
        log.info("\t - gson : {}", gson);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf8" );

        return new ResponseEntity<>(json, headers, HttpStatus.OK );

    }

    @Data
    class Person {      // 메소드 블록 안에 선언된 클래스 = 지역클래스 (local class)
        private String name = "mee";
        private Integer age = 30;
        private Double weight = 58.5;
        private Double height = 175.5;
        private String[] hobby = {"운동", "영화", "음악"};
        // 배열은 JSON 에서 어떻게 표현될까? {} -> []

        public String sayHello() {
            return "Hello";
        } // 메소드는 변환대상이 아니다 왜? 데이터를 저장하지 않으므로, 그냥 코드덩어리임

    }
    // 메소드 블록 안에 선언하면 null 이 나옴
    // 메소드 블록 밖에 선언하면 잘 나옴



}
