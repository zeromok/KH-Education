package Java.생성자;

public class Car00 {

    String color;
    int cc;

    // 생성자 선언 규칙 : 클래스명(매개변수) {;;}

    /*
        매개변수 (Parameter)
        매개 : 중개, 연결
        매개변수에 주는 값 : 전달인자 (Argument)
    */

    /*
        Car car = 객체생성;
        Car car = new Car();
        Car car = new Car("white", 1600);
    */
    Car00(String color, int cc) {
        ;;
    }// Constructor


}// end class


class Calculator {

    // sum : 필드 : 즉, 어디에 선언되냐에 따라 역할이 다르다.
    int sum;

    public int add(int num1, int num2) {

        // sum : 지역변수
        int sum = num1 + num2;
        return sum;

    }// add()

}// end class
