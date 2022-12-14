package Lambda;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LambdaEx {

    // ... : 가변인자 -> 여러개의 매개변수를 받을 수 있다.
    public static void main(String...args) {
        log.trace(args);

        // 람다식을 이용한 익명구현객체 생성
        Runnable task = () -> {
            log.trace("Anonymous::run() invoked.");
        };

        log.info("-- task --");

        // 람다식으로 추상메소드를 구현
        task.run();

    } // main()

} // end class
