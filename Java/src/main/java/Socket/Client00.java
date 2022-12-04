package Java.src.main.java.Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client00 {

    public static void main(String[] args) {

        /*
            서버에게 연결요청을 하는 객체가 Socket 이다.
            서버에서는 Socket 이 통신용 이지만 클라이언트에서는 연결요청도, 통신도 같이 한다.
        */
        Socket socket = null;   // 변수선언
        try {
            socket = new Socket("localhost", 5001);
            System.out.println("연결 요청");
//            socket.connect(new InetSocketAddress("localhost", 5001));   // 연결요청
            System.out.println("연결 성공");

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!socket.isClosed()) {       // 닫혀있지않다면
            try {
                socket.close();         // 닫아라
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } // main()

} // end class
