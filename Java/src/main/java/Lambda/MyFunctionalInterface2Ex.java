package Lambda;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterface2Ex {

    public static void main(String[] args) {

        MyFunctionalInterface2 f2;

        // 매개변수가 오직 1개면, 매개변수의 타입 생략 가능
        f2 = (x) -> {
            int result = x * 2;
            log.info(result);
        };

        f2.Method(2);

        // ---------------------------------------------------------------

        // 실행문장이 1개면, 중괄호 생략 가능
        f2 = (x) -> {
            log.info(x*3);
        };

        f2.Method(3);

        // ----------------------------------------------------------------

        // 매개변수가 1개면, 소괄호 생략 가능
        f2 = x -> log.info(x * 4);

        f2.Method(4);


    } // main()

} // end class
