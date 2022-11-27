package Java.Serializable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Sample01_1 implements Serializable {
    // Serializable 인터페이스를 구현하고 있는 클래스 이기 때문에
    // 이 클래스에서 찍어낸 객체는 객체의 직렬화/역직렬화 가능

    int sample01_1Field;

} // end class
