package Java;

import java.util.Arrays;

public class Sample02 {

    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5, 6};

        // =============
        // 배열의 순회
        // =============

        // 1. for 문
        for(int i=0; i<intArray.length; i++){
            System.out.print(intArray[i] + " ");    // 1 2 3 4 5 6
        }

        // 2. 향상된 for 문
        for(int i : intArray){
            System.out.print( i + " ");    // 1 2 3 4 5 6
        }

        // 3. Arrays.toString(arr);
        System.out.print(Arrays.toString(intArray));    // [1, 2, 3, 4, 5, 6]

        System.out.println();
        // ============================================================================================

        /*
            현업에서는 배열을 선언할 때 타입앞에 []를 붙여 선언
            초기화 값 null;로 가능 (참조타입만)
        */

        int[] score; // 배열의 선언
        score = new int[] {83, 90, 87}; // 배열의 할당
        // new 연산자 : 유일한 "객제 생성 연산자"(선언 및 할당을 같이 할 때에는 생략 가능)
        //              int[] score = {83, 90, 87};

        // 1. 배열의 순회를 사용한 "합을 구하는 예제"
        int sum00 = 0;
        for(int i=0; i<3; i++) {
            sum00 += score[i];
        }
        System.out.println("총합 : " + sum00);

        // 2. 메소드를 사용한 "합을 구하는 예제"
        int sum01 = add(score);
        System.out.println("총합 : " + sum01);

        // =============================================================================

        int[] arr00 = new int[3];

        // 인덱싱과 대입연산자를 이용해서 배열의 원소의 값을 변경해보자
        arr00[0] = 10;
        arr00[1] = 20;
        arr00[2] = 30;

        // 1.
//        for(int i : arr00){
//            System.out.println(i);  // 10, 20, 30
//        }

        // 2.
        System.out.println(Arrays.toString(arr00)); // [10, 20, 30]



    }// main()

    /*
        add() 메소드 생성
    */
    public static int add(int[] score) {
        int sum = 0;
        for(int i=0; i<score.length; i++) {
            sum += score[i];
        }
        return sum;
    }

}// end class
