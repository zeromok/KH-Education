package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleVO;
import org.zerock.myapp.domain.Ticket;

@Log4j2
@NoArgsConstructor

@RequestMapping("/RESTful/")
@RestController
public class JSONRestController {
    /*
    요청이 들어오면 JSON 형식의 데이터를 반환 하는 예제
    (produces = MediaType.APPLICATION_JSON_VALUE)
    vscode 의 rest client 플러그인을 이용해 실습했습니다.
    */


    // GET http://localhost:8080/RESTful/getSampleVO.json HTTP/1.1
    @GetMapping(path="/getSampleVO.json", produces = MediaType.APPLICATION_JSON_VALUE)   // To convert into JSON format
//    @GetMapping(path="/getSampleVO.json", produces = MediaType.APPLICATION_XML_VALUE)     // To convert into XML format
    public SampleVO getSampleVO_json() {
        log.trace("==== Controller. getSampleVO_json() ====");

        SampleVO vo = new SampleVO("가나다", 30, null);

        return vo;
        /*
        @RestController 의 핸들러 메소드에서 반환하는 것이 자바객체라면,
        이 반환되는 자바객체를 의도한 대로 XML or JSON 자동변환시켜서,
        응답문서의 바디에 넣어 준다.
        */

    }


    // GET http://localhost:8080/RESTful/getSpecialSampleVO HTTP/1.1
    // 객체의 매개변수로 인스턴스가 들어있는 데이터를 JSON 형식으로 응답
    @ResponseBody
    @GetMapping(path = "/getSpecialSampleVO", produces = {MediaType.APPLICATION_JSON_VALUE})
    public SampleVO getSpecialSampleVO() {
        log.trace("==== Controller. getSpecialSampleVO() ====");

        SampleVO vo = new SampleVO("가나다", 30, new Ticket(1000, 2500.0, "D"));
        log.debug("\t - vo : {}", vo);

        return vo;

    }// getSpecialSampleVO()


}// end class
