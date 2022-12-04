package Java.src.main.java.Send_Receive;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

public class Client {

    // 연결시도할 서버의 아이피 주소와 포트번호 선언
    private static final String host = "127.0.0.1";
    private static final int port = 7777;

    public static void main(String[] args) {
        System.out.println("main() invoked : " + Arrays.toString(args));
        //System.out.println("main({}) invoked : " +  Arrays.toString(args));

        try {
            // 1. 서버로 연결할 소켓 객체를 우선 생성
            Socket sock = new Socket();
            // 2. 커넥트 메소드로 실제 서버에 연결요청 생성 및 연결생성
            sock.connect(new InetSocketAddress(host, port), 1000);
            // 연결시도 타임아웃 시간 설정가능

            System.out.println("Connected to the server addr : " + host);
            System.out.println("Connected to the server port : " + port);

            // 메시지 보내기
            new SenderEx("SenderEx", sock).start();
//            new Sender02("sender02", sock).start();
//            new Sender03("sender03", sock).start();
//            new Sender04("sender04", sock).start();
//            new Sender05("sender05", sock).start();
//            new Sender06("sender06", sock).start();
//            new Sender07("sender07", sock).start();


            // 메시지 수신
            new ReceiverEx("ReceiverEx",sock).start();

        }catch (IOException e){
            e.printStackTrace();
        }

    } // main()

} // end class
