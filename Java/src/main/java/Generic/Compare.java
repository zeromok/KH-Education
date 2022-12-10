package Generic;

public class Compare {

    public static <T extends Number> int compare(T t1, T t2) {

        // doubleValue(); = Number 클래스에 정의되어있는 메소드
        // 숫자 -> double 타입
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        // Double.compare(); = 첫번째 매개값이 작으면 -1
        // 같으면 0
        // 크면 1을 반환
        return Double.compare(v1, v2);

    } // compare()

}  // end class
