package Java.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// 문자열 주고 받기
public class Server01 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            // 서버 소켓 객체 생성
            // 예외가 생길 수 있어 예외처리를 해준다.

            serverSocket.bind(new InetSocketAddress("localhost", 5001));
            // 바인드 메소드로 localhost 의 컴퓨터와 5001번 포트 바인드 한다.
            //  InetSocketAddress = 클라이언트를 가르키는 것 같다.

            while (true){
                // 클라이언트의 요청을 계속 기다려야하기 때문에 무한루프

                System.out.println("연결 기다림...");
                Socket socket = serverSocket.accept();
                // 연결요청이 오기전까지 대기상태 -> 블로킹
                // 클라이언트의 연결요청을 수락하는 역할
                // 요청이 들어오게 되면 Socket 이라는 통신용객체(Socket)를 만들어 리턴해준다.

                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                // 클라의 Ip 주소를 얻자,
                // get -> socketAddress 로 리턴 Inet- 으로 형변환

                System.out.println("연결 수락함" + isa.getHostName());
                // isa.getHostName = 클라의 Ip 주소
                // .toString 하면 아이피 주소 그대로 나옴 포트번호 까지?

                byte[] bytes = null;
                // 1. 데이터를 받을 장소 선언
                String message = null;
                // 2. 문자열로 변환해 저장할 변수 선언

                InputStream is = socket.getInputStream();
                // 3. InputStream 을 이용해 클라가 보낸 데이터를 받도록 하자

                bytes = new byte[100];
                // 4. 배열의 초기화, 생성

                int readByteCount = is.read(bytes);
                // 5. 데이터 읽기
                // 데이터를 보내기전 까지는 블로킹 상태이다.
                // 데이터가 오게되면 bytes 에 저장되고 읽은 바이트 수는 readByteCount 에 저장됨

                message = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
                // 6. 문자열로 변환 = 읽은 수 만큼...

                System.out.println("데이터 받기 성공 : " + message);


                // 클라이언트로 데이터 보내기
                OutputStream os = socket.getOutputStream();
                message = "Hello client";
                bytes = message.getBytes(StandardCharsets.UTF_8);
                os.write(bytes);
                os.flush();
                System.out.println("데이터 전송 완료");


                is.close();
                os.close();
                socket.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        // 더이상 서버를 실행시키지 않는다면 닫아줄 코드를 작성해줘야 한다.
        if(!serverSocket.isClosed()){   // 서버소켓이 닫혀있지 않다면
            try {
                serverSocket.close();   // 닫아라
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }// main()

} // end class
