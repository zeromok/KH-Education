package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.Ticket;

@Log4j2
@NoArgsConstructor

@RequestMapping("/requestbody/")
@RestController
public class RequestBodyController {

    @GetMapping(path="/getTicket") //, produces = MediaType.APPLICATION_XML_VALUE)
    public Ticket getTicket(@RequestBody Ticket ticket) {
        // @RequestBody : 요청메세지 body 안에 들어있는 데이터가 있으면 ticket 의 필드에 넣어라
        log.trace("==== Controller. getTicket() ====");

        return ticket;
    }// getTicket

}// end class
