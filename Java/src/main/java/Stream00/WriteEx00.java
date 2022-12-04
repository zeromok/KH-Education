package Java.src.main.java.Stream00;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx00 {

    //지정된 경로의 파일에 문자열을 출력해보자!
    public static void main(String[] args) throws Exception {

        OutputStream os = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream/test.txt");

        // String -> byte[] 로 변환(왜? 바이트 기반이니까...)
        byte[] data = "ABC".getBytes();			// ***

        for(int i=0; i<data.length; i++) {
            os.write(data[i]);

            // 바가지 째로 쏟아붇기
//			os.write(data);
        } // for

        // 자원객체를 닫기 전에 반드시 최소 한번은 수행해야 함!
        os.flush();					// 강제 flushing(***)

        os.close();					// 자원 닫기
    } // main

} // end class
