package Java.src.main.java.Method;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 매개변수로 모든 필드를 받는 생성자 생성
@RequiredArgsConstructor // 기본값을 가지지 않는 생성자 생성
public class Person {

    @NonNull // 값이 들어와 초기화 될테니 준비해라~
    String name; // null
    @NonNull
    Integer age; // 0
    // int 의 참조타입은 Integer
    Boolean gender;         // null --> "결측치"(Missing Value)
    Double height;          // null
    Double weight;          // null
    // 필드를 선언할 때 보통 참조타입으로 선언 한다.

    // @RequiredArgsConstructor 가 대신 해준다.
//    Person(String name, int age){
//       // this(name, age, false);
//        this.name = name;
//        this.age = age;
//    } // 3. @R -

    Person(String name, int age, boolean gender){
        this(name, age, gender, .0, .0);
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.height = height;
//        this.weight = weight;
    } // 2.

    // @AllArgsConstructor 가 대신 해준다.
//    Person(String name, int age, boolean gender, double height, double weight ){
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.height = height;
//        this.weight = weight;
//    } // 1. @A - 와 같다

    // 기본타입()
    // 참조타입()

    /*
    자바언어에서는, 기본타입마다 각 타입에 대응되는 참조타입(즉, 클래스)을 가지고 있습니다.
    여러가지 이유로, 기본타입보다는 참조타입으로 사용해야 하는 경우가 많기 때문입니다.

    기본타입 - 참조타입(Wrapper Type)

    byte - Byte
    char - Character
    short - Short
    int - Integer
    long - Long

    float - Float
    double - Double

    boolean - Boolean

    void - Void
    */

}// end class
