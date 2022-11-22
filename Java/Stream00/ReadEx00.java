package Java.Stream00;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadEx00 {

    // 바이트 기반 파일 입력스트림을 통해서, 파일의 데이터를 read 하자!!!
    public static void main(String[] args) throws Exception {
        // 바이트 기반의 파일 입력스트림 객체 생성
        InputStream is = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream/Read.java");

        int readByte;	// 실제 입력스트림에서 read 한 바이트 개수를 저장하는 변수

        while(true) {	// 무한루프
            readByte = is.read();			// 손가락으로 스트림에서 한 바이트씩 read 하자!!

            if(readByte == -1) {			// 파일의 끝(EOF, End-Of-File) 을 만나면(-1)
                break;		//				// 무한루프 탈출
            }// if

            System.out.print((char)readByte);	// 실제 읽어낸 1바이트를 문자로 변환
        } // while

        is.close();	// 자원객체는 다 사용하고 나면 반드시 닫자!!
    } // main

}// end class
