package org.zerock.myapp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2

@Controller
/*
이 컨트롤러는 Rest Controller(@RestController) 가 아니라,
스프링의 MVC 패턴을 따르는 컨트롤러 임 => 따라서, 핸들러 메소드가 문자열을 반환하면 이는 곧 뷰의 이름
*/
public class ResponseBodyController {


    @ResponseBody
    // 순수한 데이터로 보내고 싶을때는? = @ResponseBody
    @GetMapping("/responseBody")
    public String responseBody() {
        log.trace("==== responseBody() ====");

        return "home";
        // 뷰의 이름 반환

    }
}
