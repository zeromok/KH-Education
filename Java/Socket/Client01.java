package Java.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// 문자열 주고 받기
public class Client01 {

    public static void main(String[] args) throws IOException {

        Socket socket = null;   // 변수선언
        try {
            socket = new Socket();
            // 소켓 객체 생성

            System.out.println("연결 요청");
            socket.connect(new InetSocketAddress("localhost", 5001));
            // .connect = 연결요청을 해주는 메소드
            // InetSocketAddress = 서버를 가르키는 것 같다.
            // 주소는 문자열로 지정해주자 !

            System.out.println("연결 성공");

            byte[] bytes = null;
            String message = null;
            // 1. 서버로 데이터를 보낼 변수 선언

            OutputStream os = socket.getOutputStream();
            // 2. output 스트림을 이용하자

            message = "Hello server";
            // 3. 보낼 문자열 작성

            bytes = message.getBytes(StandardCharsets.UTF_8);
            // 4. 문자열을 데이터로 바꾸어 줘

            os.write(bytes);
            // 5. 출력 메소드

            os.flush();
            // 6. 완전한 출력

            System.out.println("데이터 전송 완료");


            // 서버로부터 데이터 받기
            InputStream is = socket.getInputStream();
            bytes = new byte[100];
            int readCount = is.read(bytes);
            message = new String(bytes, 0, readCount, StandardCharsets.UTF_8);
            System.out.println("데이터 받기 완료 : " + message);

            os.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!socket.isClosed()) {       // 닫혀있지않다면
            try {
                socket.close();         // 닫아라
            } catch (IOException e) {

            }
        }


    } // main()

} // end class
