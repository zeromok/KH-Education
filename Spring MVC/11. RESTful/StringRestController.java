package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@NoArgsConstructor

@RequestMapping("/RESTful/")
@RestController
// 이 어노테이션이 붙어있는 클래스의 핸들러 메소드는 순수한 데이터를 반환 할 수 있다.
public class StringRestController {
    /*
    요청이 들어오면 문자열을 반환 하는 예제
    vscode 의 rest client 플러그인을 이용해 실습했습니다.
    */

    // vscode : GET http://localhost:8080/RESTful/getText HTTP/1.1

    @GetMapping(path = "/getText", produces = {MediaType.TEXT_PLAIN_VALUE + "; charset=utf8"})
    public String getText() {
        log.trace("==== Controller.getText() ====");

        return "안녕하세요. :)";
        /*
        @RestController 의 핸들러 메소드에서 반환하는 문자열은,
        더이상 뷰의 이름이 아닌 실제 순수 데이터로서, 텍스트 문자열을 반환한다는 의미
        */
    }// getText()



}//end class
