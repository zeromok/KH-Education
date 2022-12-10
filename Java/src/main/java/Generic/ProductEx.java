package Generic;

public class ProductEx {

    public static void main(String[] args) {

        // 1. 제네릭 클래스 product 타입의 객체 생성 -> 사용
        // so, 타입파라미터 T -> 구체타입으로 "Tv"를 전달
        //     타입파라미터 T -> 구체타입으로 "String"를 전달
//        Product<Tv, String> product1 = new Product<Tv, String>();

//        product1.setKind(new Tv());
//        product1.setModel("스마트Tv");
//        Tv tv = product1.getKind();
//        String tvModel = product1.getModel();
//
//        System.out.println(product1);

        // ----------------------------------

        //Product<Car, String> product2 = new Product<Car, String>(); // @until 7

        // <>다이아몬드 연산자 : 타입추론 연산자
        Product<Car, String> product2 = new Product<>(); // @since 8

        product2.setKind(new Car());
        product2.setModel("아반떼");

        Car car = product2.getKind();
        String carModel = product2.getModel();

        System.out.println(product2);
    }

} // end class
