

public class Sample00 {
    public static void main(String[] args) {


        // ============================================================
//        double : 배정도(Double Precision) 실수   - 배정밀도 64 비트
//        float : 단정도(Single Precision) 실수    - 단정밀도 32 비트
        // ============================================================

        int a = 1;  // 1
        double b = a * 10; // 10.0


        // ============================================================
        // 정수리터럴은 뒤에 l/L이 없는한, 무조건 int 정수타입으로 가정
		// 실수리터럴은 뒤에 f/F가 없는한, 무조건 double 실수타입으로 가정
        // ============================================================


        // ============================================================
        // char 타입에 대해 알아보자..! - 문자하나를 저장하는 정수타입(2바이트)
		// 리터럴은 형변환의 대상이 되지 않는다.
		// 하지만 변수는 피연산자의 자료타입에 맞춰야 한다.
        // ============================================================
		char c1 = 'A' + 1;  // B why? A의 유니코드 값 + 1
		char c2 = 'A';
		//char c3 = c2 + 1;    //컴파일 에러


        // ============================================================
        // 오버 플로우 : 보관가능한 최대값을 뛰어넘는 현상
        // ============================================================

        int x = 1000000;
        int y = 1000000;
        int result = x * y; // -727379968

        System.out.println(Integer.MAX_VALUE);  // int 의 최대값 : 2147483647
        System.out.println(Integer.MIN_VALUE);  // int 의 최소값 : -2147483648


        // ============================================================
        // 수학의 정의 : 수학에서는, 0으로 나누는 것을 허용하지 않는다.
        // ============================================================
        int num1 = 5;
        double num2 = 0.0;

//        double result = num1 / num2;  // Infinity 무한대
//        double result = num1 % num2   // NaN (Not a Number) : 숫자로 표현 불가

        //변수를 넣었을때 그 변수가 무한대이면 true/false 로 출력해준다.
		System.out.println(Double.isInfinite(result));   // double result = x / y;를 체크
		System.out.println(Double.isNaN(result));		// double result = x % y;를 체크


        // ============================================================
        // 그 어떤 기본타입보다, 문자열 타입이 더 크다 즉, 기본타입 < 문자열타입
        // ============================================================
        String str00 = "JDK" + 6.0;     // 연산자마다, 피연산자의 타입은 맞추어 실행 = JDK6.0(문자열)
        String str01 = 3 + 3.0 + "JDK"; // 6.0JDK

        String str02 = "자바";
        String str03 = new String("자바");
        System.out.println(str02 == str03);         // false    - 강력한 비교
        System.out.println(str02.equals(str03));    // true     - 널널한 비교
        // equals() : 문자열을(str02) 지정된 개체(str03)와 비교


    }// main()
}// end class
