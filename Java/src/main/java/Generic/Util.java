package Generic;

public class Util {

    // Generic Method : 리턴타입, 매개변수의 타입이 T(타입파라미터)를 갖는 메소드
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }

} // end class
