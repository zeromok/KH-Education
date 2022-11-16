package Java.Method;

public class Calculator {

    void powerOn() {
        System.out.println("전원이 켜졌습니다.");
    }// powerOn()
    /*
        메소드 선언부를 메소드 시그니처라고 부른다.
        메소드 시그니처란? 메소드의 이름과 매개변수 리스트의 조합
        아래 코드에서 메소드 시그니처는 plus(int x, int y) 이다.
    */
    int plus(int x, int y) {
        int result = x + y;
        return result;
    }// plus()

    double divide(int x, int y) {
        double result = (double)x / (double)y;
        // int 로 입력되었을 때 double 로 반환시켜줘야 하므로

        return result;
    }// divide()

    void powerOff() {
        System.out.println("전원이 꺼졌습니다.");
    }// powerOff()

}// end class
