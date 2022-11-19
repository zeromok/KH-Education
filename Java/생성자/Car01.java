package Java.생성자;

public class Car01 {

    // 필드
    String company = "테슬라";
    String model;
    String color;
    int maxSpeed;

    /*
        생성자 오버로딩 (Over Loading)
            규칙 : 매개변수의 개수, 순서, 타입이 달라야 한다.
    */

    Car01() { // 매개변수 0
        System.out.println("Car::default constructor invoked");
        ;;
    } // Constructor

    Car01(String model) { // 매개변수 1
        System.out.println("Car::Car(model) constructor invoked");
        this.model = model;
    } // Constructor

    Car01(String model, String color) { // 매개변수 2
        System.out.println("Car::Car(model, color) constructor invoked");
        this.model = model;
        this.color = color;
    } // Constructor

    Car01(String model, String color, int maxSpeed) { // 매개변수 3
        System.out.println("Car::Car(model, color, maxSpeed) constructor invoked");
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    } // Constructor

}// end class
