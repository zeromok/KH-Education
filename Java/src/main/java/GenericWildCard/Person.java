package GenericWildCard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
//@AllArgsConstructor
public class Person {

    @Getter
    private String name;

    public Person(String name) {
        log.trace("부모 클래스의 생성자 등장");
        log.info("부모 say : {}", name);
    }

} // end class
