package Java.다형성;

public class Korean {

    // 1. 필드 - 고유속성, 상태, 부품
    String nation = "대한민국";
    String name;
    String ssn;

    // 생성자
//    public Korean(String n, String s){
//        name = n;
//        ssn = s;
//    }

    public Korean(String name, String ssn){

        System.out.println("Korean::constructor invoked.");

        // this 는 가장 가까운 블록 안에 있는 name, ssn
        // this 키워드 : 클래스 내부에서만 사용가능, 자기자신 객체의 주소를 가지고 있다는 의미
        this.name = name;
        this.ssn = ssn;
        System.out.println("1. this : " + this); // Java.다형성.Korean@7a81197d

    } // 생성자 != 기본 생성자


}// end class
