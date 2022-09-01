package org.zerock.myapp.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor


// DTO 객체와 기능? 이 같다. - 데이터 수집
@Data
public class Ticket {

    private Integer tno;
    private Double price;
    private String grade;

}// end class
