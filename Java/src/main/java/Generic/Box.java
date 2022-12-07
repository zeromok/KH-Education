package Generic;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
// 1. 객체의 속성 = 필드
// 2. 인스턴스 필드의 초기화 = 생성자
// 3. 객체의 행위(기능) = 메소드

// 제네릭 클래스 Box<T>
// 제네릭의 목적 : 자동이든/강제이든 형변환을 없애는데 있다.
// 제네릭은 기본타입과는 전혀 상관이 없고, 오로지 "참조타입"과 관련이 있음
public class Box<T> {
    // 제네릭 타입 파라미터(매개변수) T라고 부른다.
    // T 대신 다른 타입이 들어가면 ex)String, Apple 구제적인 타입이라 부른다. = 구체타입

    private T t;
    // 필드타입도 제네릭으로 선언

    public T get() {
        return t;
    } // Method

    // 메소드의 매개변수와 리턴타입도 제네릭으로 선언
    public void set(T t) {
        this.t = t;
    } // Method

    /*
        public class Box {

            private Object object;

            // 상자에 어떤 객체든 저장해주는 메소드 - 다형성 1
            public void set(Object object) {
                this.object = object;
            }

            // 상자에 저장되는 객체를 되돌려주는 메소드\
            public Object get() {
                return object;
            }

        } // end class
    */

} // end class

// 라이브러리 클래스 : 실행은 안되지만, 기능을 제공하는 클래스
class 전자계산기 {

    private int 결과값;

    public int 덧셈(int num1, int num2) {
        return num1 + num2;
    }

    public int 뺄셈(int num1, int num2) {
        return num1 - num2;
    }

} // end 전자계산기 class

// 실행클래스 : main 이름의 메소드가 있어서, 실행이 가능한 클래스
class 사용자 {
    public static void main(String[] args) {

        전자계산기 계산기 = new 전자계산기();
        System.out.println(계산기.덧셈(1,2)); // 3
        System.out.println(계산기.뺄셈(2,1)); // 1

    }
}
