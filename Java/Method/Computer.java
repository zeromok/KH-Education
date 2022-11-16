package Java.Method;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Computer {

    String model; // null
    double price; // 0.0

    int sum1(int[] values){
        int sum = 0;
        for(int i=0; i< values.length; i++){
            sum +=values[i];
        }
        return sum;
    }// sum1()

    int sum2(int ... values){
        // 별도로 받을 타입도 가능 ex) int sum2(int age, int ... values)
        // ex2) int sum2(String name, int ... values)
        // 가변인자가 뒤에오도록만 설정하자 !
        // 배열을 생성하지 않고, 값의 리스트만 넘기는 방법
        // 메소드의 매개변수를 "..."을 사용해 선언하면, 메소드 호출 시 넘겨준 값의 수에 따라 자동으로 배열이 생성, 매개값으로 사용
        // "..."으로 생성된 매개 형태는 이미 생성된 배열도 받을 수 있다.

        int sum = 0;
        for(int i=0; i<values.length; i++){
            sum += values[i];
        }
        return sum;
    }// sum2()

}// end class
