package Java.src.main.java;

import java.io.IOException;
import java.util.Scanner;

public class Sample01 {

    public static void main(String[] args) throws IOException {

        /*
            1.
            예제 : 1 + 2 + 3 + ... + 10 = 구하는 예제
        */
        int i = 1;
        int sum = 0;

        while(i <= 10) {

            System.out.print(i);
            sum += i;
            i++;
            // 증감식은 꼭 실행문 다음에 오도록 하자

        }// end while

        System.out.println();
        System.out.println("1부터" + (i-1) + "까지의 합 = " + sum);


        // 2.
        // 지역변수(local variables) : 특정 block({}) 안에서 선언된 변수
        // 아스키코드 !(문자집합) -> 이제는 UTF-8로 통일, 윈도우 운영체제의 기본 문자집합의 이름 : ms949 (자바에서는 cp949)
        boolean run = true;
        int speed = 0;
        int keyCode = 0;

        while(run) {
            if(keyCode != 13 && keyCode != 10) {	// 두가지의 키코드는 엔터를 의미
                System.out.println("-----------------------------");
                System.out.println("1.증속 | 2.감속 | 3.중지");
                System.out.println("-----------------------------");
                System.out.print("선택: ");
            }

            // 콘솔로부터 사용자가 입력한 1개의 문자(=키 코드값)를 읽음
            keyCode = System.in.read();	 // blocking : 키보드를 누르기 전 상태

            if (keyCode == 49) { //1
                speed++;
                System.out.println("현재 속도=" + speed);
            } else if (keyCode == 50) { //2
                speed--;
                System.out.println("현재 속도=" + speed);
            } else if (keyCode == 51) { //3 : 탈출조건
                run = false;
            }
        }// end while
        System.out.println("==== 프로그램 종료 ==== ");


        // 3.
        System.out.println("==========================================");
        System.out.println("메세지를 입력하세요.");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");
        System.out.println("==========================================");
        // Scanner : 콘솔뷰에서 사용자가 입력한 행을 그대로 스캐닝 해서, 문자열로 만들어줌
        //           사용자의 입력을 유도하는 메시지를 총칭해서 프롬프트, 프롬프트 메세지라고 한다.
        Scanner sc = new Scanner(System.in);
        String inputString;

        /*
            do-while 문
            : 조건에 따라 반복을 계속할지 결정하는 부분문 while 문과 동일
              다만, 무조건 do{} 중괄호 부분울 한번 실행 후 while(조건문)을 검사하여 반복
        */
        do {
            System.out.println(">");

            // 위에서 선언만 되었던 지역변수 초기화
            inputString = sc.nextLine();
            System.out.println(inputString);

        }while ( !inputString.equals("q") );

        System.out.println();
        System.out.println("==== 프로그램 종료 ====");


        // 4.
        System.out.println("==== 3번 프로그램 시작 ====");
        Outter: for(char upper = 'A'; upper<='Z'; upper++) {
            for(char lower='a'; lower<='z'; lower++) {
                System.out.print(upper + "-" + lower + "\s");
                if (upper == 'B') {
                    break Outter;
                }
            }
        }
        System.out.println();
        System.out.println("==== 프로그램 실행 종료 ====");

        // 5.
        for(i=0; i<=10; i++) {
            if(i%2 != 0){
                continue;
                // 아래의 코드는 실행되지 않고 조건식으로 넘어감
            }
            System.out.println(i);
        }

    }// main()
}// end class