package Java.Stream03;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class StreamTime {

    public static void main(String[] args) throws Exception {

        long start = 0;
        long end = 0;

        FileInputStream fis1 = new FileInputStream("/Users/mokpro/Desktop/Test/source/chap18/src/sec05/exam03_bufferedinputstream/forest.jpg");

        // 실행소요시간 측정 부분 시작
        start = System.currentTimeMillis();  // 현재시간을 밀리세컨드 단위로 반환

        while(fis1.read() != -1);  // 시간측정 대상 코드를...

        end = System.currentTimeMillis();  // 현재시간을 밀리세컨드 단위로 반환
        // 실행소요시간 측정 부분 끝

        System.out.println("사용하지 않았을 때: " + (end-start) + "ms");
        fis1.close();

        // -------------------------------------------------------------------------------------------

//        FileInputStream fis2 = new FileInputStream("/Users/mokpro/Desktop/Test/source/chap18/src/sec05/exam03_bufferedinputstream/forest.jpg");
//
//        // 성능향상 보조 스트림(버퍼기반)을 이용한 테스트 수행
//        BufferedInputStream bis = new BufferedInputStream(fis2);
//
//        start = System.currentTimeMillis();
//
//        while(bis.read() != -1);
//
//        end = System.currentTimeMillis();
//
//        System.out.println("사용했을 때: " + (end-start) + "ms");
//
//        bis.close();
//        fis2.close();

    } // main()

} // end class
