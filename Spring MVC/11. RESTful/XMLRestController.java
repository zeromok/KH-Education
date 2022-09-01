package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleVO;
import org.zerock.myapp.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/RESTful/")
@RestController
public class XMLRestController {
    /*
    요청이 들어오면 XML 형식의 데이터를 반환 하는 예제
    (produces = MediaType.APPLICATION_XML_VALUE)
    vscode 의 rest client 플러그인을 이용해 실습했습니다.
    */


    /*
    반환되는 데이터가 자바객체라면?
    GET http://localhost:8080/RESTful/getSampleVO HTTP/1.1
    */
    @GetMapping(path="/getSampleVO", produces = MediaType.APPLICATION_XML_VALUE)
    public SampleVO getSampleVO() {
        log.trace("==== Controller. getSampleVO() ====");

        SampleVO vo = new SampleVO("가나다", 30, null);

        return vo;
        /*
        @RestController 의 핸들러 메소드에서 반환하는 것이 자바객체라면,
        이 반환되는 자바객체를 의도한 대로 XML or JSON 자동변환시켜서,
        응답문서의 바디에 넣어 준다.
        */

    }

    /*
    반환되는 데이터가 자바객체라면?
    GET http://localhost:8080/RESTful/getTicket HTTP/1.1
    */
    @GetMapping(path="/getTicket", produces = MediaType.APPLICATION_XML_VALUE)
    public Ticket getTicket() {
        log.trace("==== Controller. getTicket() ====");

        Ticket ticket = new Ticket();
        ticket.setTno(12345);
        ticket.setPrice(15000.0);
        ticket.setGrade("VIP");

        return ticket;
    }// getTicket

    /*
    반복문을 이용해 여러개의 객체를 만들어
    List 에 ArrayList 이용해 넣어둔 객체를 반환 한다면?
    GET http://localhost:8080/RESTful/getTickets HTTP/1.1
    */
    @GetMapping(path = "/getTickets", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Ticket> getTickets() {
        log.trace("==== Controller. getTickets() ====");

        List<Ticket> list = new ArrayList<>();
        for (int i=0; i<=5; i++) {
            Ticket ticket = new Ticket( i, 1000.0*i, ( (i < 3)? "C" : ( (i == 4)? "B" : "A" ) ) );
            list.add(ticket);
        }

        return list;

    }// getTickets()

    /*
    반환되는 데이터가 객체안객체 데이터라면?
    GET http://localhost:8080/RESTful/getSpecialSampleVO HTTP/1.1
    */
    @GetMapping(path = "/getSpecialSampleVO", produces = {MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSpecialSampleVO() {
        log.trace("==== Controller. getSpecialSampleVO() ====");

        SampleVO vo = new SampleVO("가나다", 30, new Ticket(1000, 2500.0, "D"));
        log.debug("\t - vo : {}", vo);

        return vo;

    }// getSpecialSampleVO()


}// end class
// XML 을 반환
