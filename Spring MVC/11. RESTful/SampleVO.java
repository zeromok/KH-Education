package org.zerock.myapp.domain;


import lombok.Value;

// 읽기전용 객체
@Value
public class SampleVO {

    private String name;
    private int age;

    private Ticket ticket;

}
