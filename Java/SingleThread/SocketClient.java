package Java.SingleThread;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class SocketClient {

    private static final int CR = 13;
    private static final int LF = 10;


    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("main() invoked." + Arrays.toString(args));

//		--------------------------

        String serverAddress = "localhost";		// 127.0.0.1 (Loopback Address)
        int serverPort = 7777;

        int connectTimeout = 1000;	// milliseconds

//		--------------------------
//		Socket 객체 생성시, 내부에서 실제 얻어낸 서버의 IP 주소와 port 를 가지고 접속요청을 보냄!
//		실무에서는 잘 사용하지 않음
//		--------------------------

        // 1st. method : 'localhost' 란 이름에 대응되는 IP 주소를 생성자 내부에서, DNS 서비스를 이용해서 얻어냄
//		Socket socket = new Socket(serverAddress, serverPort);

        // 2nd. method : 명시적으로, 'localhost' 란 이름에 대응되는 IP 주소를 DNS 서비스를 이용해서 얻어냄
//		Socket socket = new Socket(InetAddress.getByName(serverAddress), serverPort);

//		--------------------------
//		실무에서는 아래의 방법을 통해서, 클라이언트가 진짜 접속을 원할 때, 명시적으로 연결시도함!
//		--------------------------

        Socket socket = new Socket();	// 먼저 기본생성자로 Socket 객체를 생성하고

        // 실제 서버로의 연결요청시도는 connect() 메소드를 통해서 명시적으로 수행!!!
        //socket.connect(new InetSocketAddress(serverAddress, serverPort));
        socket.connect(new InetSocketAddress(serverAddress, serverPort), connectTimeout);

//		--------------------------

        System.out.println("1. socket : " + socket);

        System.out.println("\t1-1. getLocalSocketAddress  : " + socket.getLocalSocketAddress());
        System.out.println("\t1-2. getRemoteSocketAddress : " + socket.getRemoteSocketAddress());


//		--------------------------
//		SEND
//		--------------------------

        try (socket) {

            try {
                String sendLine = "Hello, Server!!!";

                OutputStream os = socket.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                bw.write(sendLine);						// Block I/O

                // 왜? 엔터키 코드값을 전송할까요!?
//				bw.write(CR);
//				bw.write(LF);

                bw.flush();

                System.out.println("2. sendLine : " + sendLine);
            } catch(Exception e) {
                System.out.println("* Exception : {} - {}" + e.getClass().getName() + e.getMessage());
            } finally {
//				sock.shutdownOutput();	// Socket 객체는 입/출력을 선택적으로 닫을 수 있습니다!
            } // try-catch-finally


//			-----------------------
//			RECV
//			-----------------------

            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String recvLine = br.readLine();		// Block I/O

                System.out.println("3. recvLine : " + recvLine);
            } catch(Exception e) {
                System.out.println("* Exception : {} - {}" + e.getClass().getName() + e.getMessage());
            } finally {
//				sock.shutdownInput();
            } // try-catch-finally

        } // try-with-resources
//
        System.out.println("4. Disconnected.");

    } // main

} // end class
