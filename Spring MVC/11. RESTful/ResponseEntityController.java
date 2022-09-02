package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleVO;
import org.zerock.myapp.domain.Ticket;

@Log4j2
@NoArgsConstructor

@RequestMapping("/responseentity")
@RestController
// 이 어노테이션이 붙어있는 클래스의 핸들러 메소드는 순수한 데이터를 반환 할 수 있다.
public class ResponseEntityController {

    /*
    ResponseEntity<T> : 이 타입은 "응답메세지" 자체를 모델링한 클래스이다.
                     : 이 타입은 "응답메세지" 를 구성하는 3개요소
                     HTTP status code, Header, Body
                     를 모두 제어할 수 있는 타입 => 즉, 응답메세지를 원하는대로 구성하는데 사용
     위 타입파라미터 : 응답메세지의 body 에 넣을 자바 객체의 타입을 지정
     결론적으로, 응답메세지의 상태코드나 헤더를 제어할 수는 없지만, body 는 제어 가능한
     @ResponseBody 와 비슷한 자바 클래스임
    */

    /*
    전송파라미터로 어떤 사람의 키와 몸무게를 받고, 받은 인체수치를 체크하여 그 결과를
    ResponseEntity 타입의 객체로 반환 => 결국 JSON or XML 으로 변환되어 응답메세지의 body 에 넣어짐
    */
//    @GetMapping("/check")
    @GetMapping(
            value = "/check",
            params = {"height", "weight"},
            // 값으로 가지고 있는 요소가 무조건 들어와야 한다! 라는 속성
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SampleVO> check(Double height, Double weight) {
        log.trace("==== Controller.check() ====");

        Ticket ticket = new Ticket(777, 8900.0, "B");
        SampleVO sampleVO = new SampleVO("meme", 30, ticket);
        log.debug("\t - sampleVO : {}", sampleVO);

        ResponseEntity<SampleVO> response = null;
        ResponseEntity.BodyBuilder bodyBuilder = null;

        if(height < 20) {       // 받은 키가 비정상이라면

            bodyBuilder = ResponseEntity.status(HttpStatus.BAD_REQUEST);

        }else {

            bodyBuilder = ResponseEntity.status(HttpStatus.OK);

        }
        log.debug("\t - bodyBuilder : {}, type : {}", bodyBuilder, bodyBuilder.getClass().getName());

        response = bodyBuilder.<SampleVO>body(sampleVO);
        log.debug("\t - response : {}, type : {}", response, response.getClass().getName());

        return response;
    }

}// end class
