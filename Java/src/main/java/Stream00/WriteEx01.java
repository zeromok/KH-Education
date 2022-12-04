package Java.src.main.java.Stream00;

import lombok.Cleanup;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx01 {

    public static void main(String[] args) throws Exception {
        // 기존파일에 계속해서 추가해서 write 작업을 하려면,
        // 생성자의 두번째 매개변수로, true 추가하면 됨!!
        @Cleanup
        OutputStream os = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream/test.txt");

        try(os) {
            // os 라는 자원객체를 사용하는 실행문자들을 넣음.
        }

        // String > byte[] 로 변환 -> 바가지 준비
        byte[] data = "나는 소년이다.".getBytes();

        // 출력버퍼(8K)에 바가지채로 쓰기 수행!
        os.write(data);

        // 출력스트림을 닫기 전에 반드시 최소 1번은 강제 flushing 해야 함!
        // 왜? 출력버퍼(8KB)에 잔류한 바이트들이 존재할 수 있기 때문
        os.flush();

    } // main

}// end class
