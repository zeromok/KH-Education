package Java.src.main.java.Serializable;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Parent { //implements Serializable {      // implements 하지 않으면, Non-serializable 함 직렬화 불가능

    // POJO : Plain Old Java Object
    public String field;

} // end class
