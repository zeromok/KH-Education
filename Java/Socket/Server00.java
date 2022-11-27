package Java.Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server00 {

    public static void main(String[] args) {

        /*
            서버에서는 연결수락을 위해 사용해야할 API 가 있는데 그게 바로 ServerSocket
            ServerSocket 은 특정 포트를 가지고 실행을 하는데 그 포트가 프로그램 식별번호
            그 포드를 ServerSocket 의 바인딩 포트라고도 부른다.

            ServerSocket 은 특정포트에서 실행이 된 이후에 클라이언트의 연결요청이 들어올때까지 대기해야하는데
            대기하는, 요청을 받는, 연결을 수락하는 메소드가 .accept()
            연결이 완료되면 클라이언트와 통신할 Socket 을 생성한다.
        */
        // Client00 과의 통신
//        ServerSocket serverSocket = null;
//
//        try {
//            serverSocket = new ServerSocket(5001);
//            //serverSocket.bind(new InetSocketAddress("localhost", 5001));
//            while (true){
//                System.out.println("연결을 기다리는 중입니다...");
//                Socket socket = serverSocket.accept();
//
//                InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
//                System.out.println("연결을 수락했습니다!" + isa.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // ----------------------------------------------------------------------------------

        // Client00 과의 통신
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
            // bind 의 매개값으로 InetSocketAddress (생성자) 이 가지고있는 정보를 가지고 serverSocket 이 만들어 진다.

            while (true){   // 클라이언트의 요청을 계속 기다려야하기 때문에 무한루프
                System.out.println("연결 기다림...");
                Socket socket = serverSocket.accept();
                // 연결요청이 오기전까지 대기상태 -> 블로킹
                // 연결요청이 오게되면 클라이언트와 통신할 Socket 을 리턴한다.
                // 이 Socket 을 가지고 클라이언트의 정보를 얻을 수 있고, 데이터를 주고받을 수 있다.

                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                /*
                    클라의 Ip 주소를 얻자, 어떤 클라이언트가 요청을 했는지 정보를 얻는 코드
                     get -> socketAddress 로 리턴 Inet- 으로 형변환
                    그래서 .getRemoteSocketAddress(); = InetSocketAddress 객체를 리턴
                    *객체를 이용해 클라이언트의 정보를 얻을 수 있다*
                    1. isa.getHostName = 클라이언트의 IP 리턴
                    2. isa.getPort = 클라이언트의 포트번호 리턴
                    3. isa.toString = "IP : 포트번호" 형태의 문자열 리턴
                */

                System.out.println("연결 수락함" + isa.toString());
                // isa.getHostName = 클라의 Ip 주소
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if(!serverSocket.isClosed()){   // 서버소켓이 닫혀있지 않다면
            try {
                serverSocket.close();   // 닫아라
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    } // main()

} // end class
