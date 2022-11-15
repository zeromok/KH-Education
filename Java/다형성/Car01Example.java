package Java.다형성;

public class Car01Example {

    public static void main(String[] args) {

        // 1. 매개변수 없는 기본생성자 호출
        Car01 car00 = new Car01();
        System.out.println("car00.company : " + car00.company);

        Car01 car01 = new Car01("자가용");
        System.out.println("car01.company : " + car01.company);
        System.out.println("car01.model : " + car01.model);

        Car01 car02 = new Car01("자가용", "빨강");
        System.out.println("car01.company : " + car02.company);
        System.out.println("car01.model : " + car02.model);
        System.out.println("car01.color : " + car02.color);

        Car01 car03 = new Car01("자가용", "빨강", 200);
        System.out.println("car4.company : " + car03.company);
        System.out.println("car4.model : " + car03.model);
        System.out.println("car4.color : " + car03.color);
        System.out.println("car4.maxSpeed : " + car03.maxSpeed);


    }// main()
}// end class
