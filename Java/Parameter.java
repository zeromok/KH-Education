package Java;

public class Parameter {

    public static void main(String[] args) {

        // ... : 가변인자 매개변수를 선언할 때 사용
        // 0개 이상의 인자값을 받는다는 의미
        // (String format, Object ... args)
        String name = "mokk";
        int age = 30;

        String format = "저의 이름은 %s 이구요, 나이는 %s 입니다.";
        // %s : printf 의 출력서식 중 하나 (문자열)

        System.out.printf(format, name, age);
        System.out.println();

        // ---------------------------------------------

        varargs();
        varargs(1);
        varargs(1,2,3,4,5);         // 여러개의 인자값을 한번에 전달하는 방법 #1
        varargs(new int[]{1, 2, 3, 4, 5});      // 여러개의 인자값을 한번에 전달하는 방법 #2

    } // main()

    static int varargs(int ... numbers) {
        // 메소드 블록 안 가변인자 매개변수는 곧 배열 객체이다.

        int sum = 0;

        for(int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
        return sum;

    } // varargs()

} // end class

