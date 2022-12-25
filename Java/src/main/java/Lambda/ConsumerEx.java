package Lambda;

import lombok.extern.log4j.Log4j2;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

@Log4j2
public class ConsumerEx {
    /*
        JAVA 8 에서 도입된 Consumer
            - 데이터(매개변수)를 소비(사용)하고 아무것도 생성(반환)하지 않음
            - 함수형 인터페이스
            - 제네릭 타입의 매개변수를 전달받아 특정 작업을 수행해야 하는 경우 사용
    */

    public static void main(String[] args) {
        // void accept(T t);
        Consumer<String> consumer = t -> System.out.println(t + "8");
        consumer.accept("java");    // 추상메소드 호출


        // void accept(T t, U u);
        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
        biConsumer.accept("java", "8");


        // void accept(double value);
        DoubleConsumer doubleConsumer = d -> System.out.println("java" + d);
        doubleConsumer.accept(8.0);


        // void accept(T t, int value)
        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
        objIntConsumer.accept("java", 8);

    } // main()

} // end class
