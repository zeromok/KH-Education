package Java.생성자;

public class Sample01 {

    public static void main(String[] args) {

        /*
            생성자 : new 연산자에 의해 호출되어 객체의 초기화 담당
                    1. 필드의 값 설정
                    2. 메소드를 호출해 객체를 사용할 수 있도록 준비하는 역할 수행
        */

        // 1. 객체생성
        Sample00 myCar = new Sample00();

        // 2. 필드 값 생성
        System.out.println("제작회사 : " + myCar.company);
        System.out.println("모델명 : " + myCar.model);
        System.out.println("색상 : " + myCar.color);
        System.out.println("최고속도 : " + myCar.maxSpeed);
        System.out.println("현재속도 : " + myCar.speed);

        // 3. 필드 값 변경
        myCar.speed = 60;
        System.out.println("현재속도 : " + myCar.speed);


    }// main()
}// end class
