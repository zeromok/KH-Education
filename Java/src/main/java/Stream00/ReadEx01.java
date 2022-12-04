package Java.src.main.java.Stream00;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadEx01 {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream/test.txt");

        int readByteNo;

        byte[] readBytes = new byte[3];	// 이번에는, 바가지를 준비해서, 한번에 많이 읽어내자!
        String data = "";

        while( true ) {
            // 바가지로 읽어내면, 실제로 스트림에서 읽어낸 바이트 개수를 반환
            readByteNo = is.read(readBytes);	// 바가지로 읽어내자!
            if(readByteNo == -1) {
                break;							// EOF를 만나면, 탈출
            } // if

            // 바가지의 바이트 배열을 문자열로 변환하여, 누적(연결)
            data += new String(readBytes, 0, readByteNo);
        } // while

        System.out.println(data);

    } // main

}// end class
