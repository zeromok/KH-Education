package Java.Method;

public class Sample00 {

    /*
        클래스의 구성요소 중 Method(메소드) 에 대해 알아보자
        객체의 동작 및 기능
        객체와 객체간에 상호작용의 수단 = 객체의 메소드 호출
    */

    // 메소드 선언
    /*
        리턴타입 메소드명(매개변수) {
            실행코드;
        }
    */

    //반환타입(return)
    /*
        메소드가 실행 후 반환하는 값의 타입을 의미한다.
        반환값이 없다면 호출자에게 반환될 값이 없으므로 리턴타입을 void 라고 표현한다.
     */

    // 메소드 이름 규칙
    /*
        낙타등
        숫자로 시작될 수 없고, $,_ 를 제외한 특수문자는 사용할 수 없다.
        (중요)어떤기능을 수행하는지 알 수 있도록 이름을 지어준다.
    */

    // 리턴
    /*
        메소드 선언에 리턴 타입이 있는 메소드는 반드시 리턴문을 사용해서 리턴값을 지정해야 한다.
        리턴문이 없다면 컴파일 에러가 발생한다.
        리턴문이 실행되면, 메소드는 이후 즉시 종료된다.
        리턴키워드 다음에 값이 나오면, 이 값을 호출자에게 반환
     */

    // 리턴값이될 수 있는 것들
    /*
        1. literal
        2. 변수
        3. 표현식
    */

    // 주의할 점
    /*
        리턴문 이후 실행문은 컴파일 오류가 발생한다.
        하지만 if 문으로 실행문이 분기되는 경우는 컴파일 에러가 발생하지 않는다.
        ex)
        boolean isLeftGas(){
            if(gas == 0){
                sout("gas 가 없습니다.");
                return false;
            }
            sout("gas 가 있습니다.");
            return true;
        }// isLeftGas()
    */


    // 리턴값이 없는 메소드(void)
    /*
        void 로 선언된 메소드에서 리턴값을 사용할 수 없다.
    */

    // 메소드 호출
    /*
        메소드는 클래스 내부, 외부의 호출에 의해 실행된다.
        클래스 내부의 다른 메소드에서 호출할 경우, 단순히 메소드 이름으로 호출
        클래스 외부에서 메소드를 호출할 경우
        - 우선 클래스로 부터 객체를 생성한 뒤, 참조변수를 이용해서 메소드를 호출
        - 객체가 존재해야 메소드도 존재한다 !
     */

    public static void main(String[] args) {

        Calculator myCalc = new Calculator(); // 객체생성

        myCalc.powerOn();

        int result1 = myCalc.plus(5,6);
        System.out.println("result1 : " + result1);


        double result2 = myCalc.divide(10, 20);
        System.out.println("result2 : " + result2);

        myCalc.powerOff();

    }// main()
}// end class
