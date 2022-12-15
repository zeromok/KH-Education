package Lambda;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterface1Ex {

    public static void main(String[] args) {

        MyFunctionalInterface1 f1;

        // 익명구현객체코딩기법
        f1 = new MyFunctionalInterface1() {
            @Override
            public void Method() {
                String str = "f1 Method call-1-";
                log.info(str);
            }
        };

        f1.Method();

        //---------------------------------------------------------

        // void method(); -> 매개변수선언부를 그대로 가져오라=(), 중괄호블록 생성={}
        // 람다식을 이용한, 함수적 인터페이스에 대한 "익명구현객체"의 생성
        f1 = () -> {
            String str = "f1 Method call-2-";
            log.info(str);
        };

        // 인터페이스에 선언된 추상메소드 호출 -> 다형성 2
        f1.Method();

        //-------------------------------------------------------

        // 람다식의 실행블록의 실행문장을 1개로 줄임
        f1 = () -> {
            log.info("f1 Method call-3-");
        };

        f1.Method();

        //-------------------------------------------------------

        // 람다식의 실행블록안의 실행문장이 단 1개라면, 중괄호기호 생략 가능 하다.
        f1 = () -> log.info("f1 Method call-4-");

        f1.Method();

    } // main()

} // end class
