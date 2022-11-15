package Java.다형성;

public class Sample00 {

    /*
        클래스에서 객체를 찍어내는 과정 = 인스턴스화
        Instance(인스턴스) : 객체(Object) 라고 하는 것이 됨, 해당클래스에서 찍어낸 객체들
    */

    /*
        필드 : 클래스 블록 안에 생성된다.
               1. 객체의 고유속성 2. 객체의 상태 3. 부품
        *** 필드는 변수가 아니다, 객체의 데이터가 저장되는 곳
    */

    // 1. 객체의 고유속성
    String company = "현대자동차";
    String model = "그랜져";
    String color = "검정";
    int maxSpeed = 350;

    // 2. 객체의 상태
    int speed;

    /*
        기본 생성자 (Default Constructor)
                    1. 모든 클래스는 생성자가 반드시 존재하며 하나 이상 가질 수 없음
                    2. 생성자 선언을 생략하면 컴파일러는 다음과 같은 기본 생성자 추가 [public]클래스명() {;;}
    */
    public Sample00() {
        /*
            ;; : 아직 실행문장을 준비하지 못했습니다. -> 필드를 의미있는 값으로 다시 초기화 할 필요가 있다.
        */
        ;;
    }


}// end class
