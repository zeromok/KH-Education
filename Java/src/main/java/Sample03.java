package Java.src.main.java;

import java.util.Arrays;

public class Sample03 {

    public static void main(String[] args) {

        // 1.
        int[][] arr00 = { {1}, {3, 4, 6} }; // 2차원 배열
        System.out.println("1-1. " + arr00.length);       // 2
        System.out.println("1-2. " + arr00[0].length);    // 1
        System.out.println("1-3. " + arr00[1].length);    // 3

        // 2.
        int[][] arr01 = new int[2][];
        System.out.println("2-1. " + arr01.length);      // 2
//        System.out.println("2. " + arr01[0].length); // X
//        System.out.println("3. " + arr01[1].length); // X

        // 3.
        int[][] arr02 = { {1}, {3, 4, 6} };	// 2차원배열
        System.out.println("3-1. " + arr02.length);     // 2
        System.out.println("3-2. " + arr02[0].length);  // 1
        System.out.println("3-3. " + arr02[1].length);  // 3

        // 4.
		int[][] arr03 = new int[2][];
        // = { {null}, {null} };		= 배열의 크기를 모르니 null을 넣는다.
		System.out.println("4-1. " + arr03.length);
//		System.out.println("2. " + arr03[0].length); // X
//		System.out.println("3. " + arr03[1].length); // X

        // 5.
        int[][] arr04 = new int[2][3];
        // = { {0, 0}, {0, 0, 0} }  = 배열의 크기는 알지만 값은 모르므로 정수형 기본타입인 0 을 넣는다.

        // ===============================================================================================

        // 6.
        String[] languages = new String[3];
        System.out.println("languages : " + languages);
        // [Ljava.lang.String;@2f92e0f4
        // L = 배열, String = 원소의 타입

        languages[0] = "언어1";
        languages[1] = "언어2";
        languages[2] = "언어3";   // 문자열 리터럴(객체) : languages[2] 의 주소로 들어간다.

        // Literal(리터럴) : 순수한 값 + Immutable(수정 불가능)
        languages[0] = "언어1";
		languages[1] = "언어1";
		languages[2] = "언어1";	// 객체 하나로 참조한다. 즉, 같은 주소값?

		System.out.println(languages[0].hashCode());	// hashcode = 고유번호 같은 번호면 객체하나로 참조
		System.out.println(languages[1].hashCode());
		System.out.println(languages[2].hashCode());

        // =============================================================================================

        // 기존배열을 직접 새로운 배열에 복사하는 예제
        int[] oldArr = { 1, 2, 3};
        int[] newArr = new int[5];

        /*
            기존 배열의 원소를 새로운 배열에 복사
            인덱스가 필요없다면 향상된 포문 사용가능
            여기에선 인덱스가 인덱싱 과정에서 필요하므로 포문 사용
        */
        for(int i=0; i<oldArr.length; i++){
            newArr[i] = oldArr[i];
        }

        System.out.println(Arrays.toString(newArr)); // 새로운 배열의 출력 : [1, 2, 3, 0, 0]

        // =============================================================================================

        String[] oldStrArray = { "java", "array", "copy" };
        String[] newStrArray = new String[5];

        // 새로운 배열에, 기존 배열을 복사하는 더 간단한 방법
        // src : 원본 배열
        // srcPos : 원본 배열의 복사할 시작점
        // dest : 카피 배열
        // destPos : 카피 배열의 붙여넣기 시작점
        // length : 원본 배열에서 가져올 길이
        // System.arraycopy(src, srcPos, dest, destPos, length);
        // offset 의미 : 시작위치

        System.arraycopy( oldStrArray, 0, newStrArray, 0, oldStrArray.length);
        System.out.println("arraycopy" + Arrays.toString(newStrArray));

//		for(int i=0; i<newStrArray.length; i++) {
//			System.out.print(newStrArray[i] + ", ");
//		}

        String[] newStrArr = Arrays.copyOf(oldStrArray, newStrArray.length);
        System.out.println("copyOf" + Arrays.toString(newStrArr));


    }// main()
}// end class
