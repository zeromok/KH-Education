package Generic;

public class BoxEx {

    public static void main(String[] args) {

        // 비제네릭
//        Box box = new Box();
//        box.set("홍길동"); // 상자(Box 객체)에 문자열 저장
//
//        // 조상객체 품에 안겨있는, 문자열 객체를 강제로 끄집어내어 저장 Object -> String
//        String name = (String) box.get(); // 상자에 저장된 객체를 반환 Object 타입으로...
//
//        System.out.println(name);

        // --------------------------------

        // String 로 구체타입을 지정해 제네릭을 사용해보자
        // 라이브클래스인 Box 에서는 타입파라미터를 T 로 지정해 놓고
        // 사용할 때 구체타입을 지정해주었다.
        Box<String> box = new Box<>();
//        box.set("홍길동");
//        String str = box.get();
//        System.out.println(str);

        // --------------------------------

//        box.set(new Apple());
//        Apple apple = (Apple) box.get();
//
//        System.out.println(apple);
//        // 객체의 레퍼런스 - main.java.Generic.Apple@28a418fc 가 나옴
//        // FQCN@객체의 주소(논리적인 주소)
//
//        // 형변환은 프로그램 성능에 안좋다 (프로모션, 캐스팅)
//        // 그래서 제네릭이 나왔다.
//
//        // 아래의 문장에서는, (자동/강제) 형변환이 전혀 없다.
//        Apple apple = new Apple();
//        System.out.println(apple);


    } // main()

} // end class
