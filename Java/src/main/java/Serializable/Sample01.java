package Java.src.main.java.Serializable;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class Sample01 implements Serializable {

    int sample01Field;

    Sample01_1 field01_1 = new Sample01_1();

    // 객체의 직렬화에서 제외됨 -> 왜? 소속이 Clazz 객체 (메소드영역)이기 때문에... = 값이없다.(초기값으로 간다.)
    static int staticField;

    // 객체의 직렬화에서 제외시키고 싶은 객체앞에 transient 붙이기
    transient int transientField; // transient : 일시적인, 순간적인 -> 영구적이지 않다.

} // end class
