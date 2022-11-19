package Java.생성자;

public class KoreanExample {

    public static void main(String[] args) {
        // korean 클래스로부터 "한국인"을 찍어내보자


        // new : 힙에 객체 생성 (필드는 기본값으로 초기화)
        //       바로 뒤에 나오는 생성자 호출(필드를 초기화)
        //       제대로 초기화까지 끝낸, 힙의 객체의 주소를 반환

        // 1.
        Korean k1 = new Korean("박자바", "011223-000000"); // 겍체 생성

//        System.out.println("2. k1 : " + k1);
//        1. this : Korean@7a81197d - 클래스에서 생성한 인스턴스(객체)의 주소를 저장
//        2. k1   : Korean@7a81197d - 클래스에서 생성한 인스턴스(객체)의 주소를 저장

        System.out.println("k1.name : " + k1.name); // 필드값 출력
        System.out.println("k1.ssn : " + k1.ssn); // 필드값 출력

        // 2.
        Korean k2 = new Korean("김자바", "000000-000000"); // 겍체 생성
        System.out.println("k2.name : " + k2.name); // 필드값 출력
        System.out.println("k2.ssn : " + k2.ssn); // 필드값 출력

        // 변수의 이름 = 식별자 유의미하게 지어라~

    }// main()
}// end class
