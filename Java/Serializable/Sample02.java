package Java.Serializable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
// Serializable : Tag Interface 라고 부른다.(JVM 에게 보여주려고 꼬리표를 붙인다.)
public class Sample02 implements Serializable {
    // Serializable 인터페이스를 구현하고 있는 클래스 이기 때문에
    // 이 클래스에서 찍어낸 객체는 객체의 직렬화/역직렬화 가능


    // Serializable 인터페이스를 구현하는 클래스는 반드시 아래의 필드를 가져야함
    // 만일 개발자가 아래 필드를 선언하지 않으면, 컴파일시점에, 자바 컴파일러가 자동으로 넣어줌
    @Serial
    private static final long serialVersionUID = 777L;

    int sample02Field;

    int sample02Field2 = 1000; // 새로운 필드 추가 -> 역시 직렬화 대상

} // end class
