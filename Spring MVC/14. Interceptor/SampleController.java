package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@NoArgsConstructor

@Controller
@RequestMapping("/sample/")
public class SampleController {
    // 컨트롤러 클래스의 기본 골격

    @GetMapping("/doA")
    public void doA() {
        log.trace("======= doA() =======");

        Integer.parseInt("100");

    }


}// end class
