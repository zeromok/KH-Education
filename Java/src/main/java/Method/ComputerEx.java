package Java.src.main.java.Method;

public class ComputerEx {

    public static void main(String[] args) {
        // public static void main(String... args) -> 가변인자로 바꾸어 주기

        Computer myCom = new Computer();

        int[] values1 = {1, 2, 3};
        int result1 = myCom.sum1(values1); // 이미 생성되어있는 배열 전달
        System.out.println("result1 : " + result1); // 6

        int result2 = myCom.sum1(new int[]{1, 2, 3, 4, 5}); // 새로운 베열을 생성해 전달
        System.out.println("result2 : " + result2); // 15

        int result3 = myCom.sum2(1, 2, 3); // 가변인자 == 배열
        // 배열을 생성하지 않고, 값의 리스트만 넘기는 방법
        // 메소드의 매개변수를 "..."을 사용해 선언하면, 메소드 호출 시 넘겨준 값의 수에 따라 자동으로 배열이 생성, 매개값으로 사용
        // "..."으로 생성된 매개 형태는 이미 생성된 배열도 받을 수 있다.
        System.out.println("result3 : " + result3); // 6

        int result4 = myCom.sum2(1, 2, 3, 4, 5);
        System.out.println("result4 : " + result4); // 15

    }

}// end class
