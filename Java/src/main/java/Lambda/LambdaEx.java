package Lambda;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LambdaEx {

    // ... : 가변인자 -> 여러개의 매개변수를 받을 수 있다.
    public static void main(String...args) {
        log.trace(args);

        Runnable task = () -> {
            log.trace("Anonymous::run() invoked.");
        };

        log.info("task");
        task.run();

    } // main()

} // end class
