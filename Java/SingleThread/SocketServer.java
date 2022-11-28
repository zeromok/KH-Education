package Java.SingleThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SocketServer {

    // 이게 뭔가요!?... 키보드에서 <엔터키>를 치면 발생하는 "키코드값" 입니다.(2개가 발생합니다)
    // 물론, Mac에서는 CR은 발생하지 않고, LF만 발생합니다.
    private static final int CR = 13;            // Carriage Return (CR): ASCII 13 코드
    private static final int LF = 10;            // Line Feed (LF) : ASCII 10 코드


    public static void main(String[] args) throws IOException {
        System.out.println("main({}) invoked." + Arrays.toString(args));

        int listenPort = 7777;
        int backLog = 100;

//		--------------------------

        // Listen Port 만 지정하면, 서버pc의 모든ip주소를 이용해서 연결요청을 받아들이는 "IP ANY"가 됨
        ServerSocket serverSock = new ServerSocket(listenPort, backLog);
        System.out.println("1. serverSock : " + serverSock);

//		--------------------------

        try (serverSock) {    // try-with-resources block

            while (true) {    // Infinite loop

                System.out.println("---------------------------------------------------------------------");
                System.out.println("2. listening on port {} and addr {} ..." + listenPort + serverSock.getInetAddress());
                System.out.println("---------------------------------------------------------------------");

                serverSock.setSoTimeout(0);                            // Infinitely wait for incomming connection.
//				serverSock.setSoTimeout(5*1000);					// Finitely wait for the specified milliseconds

                Socket sock = serverSock.accept();        // Block I/O

                System.out.println("3. Client Connected.");
                System.out.println("\t3-1. sock : {}" + sock);
                System.out.println("\t3-2. getLocalSocketAddress  : {}" + sock.getLocalSocketAddress());
                System.out.println("\t3-3. getRemoteSocketAddress : {}" + sock.getRemoteSocketAddress());

                // *** 아래의 코드부터는 "자바 입출력(Java I/O) API"를 모르고서는 할 수가 없답니다!!! ***

                // -----------------
                // 1. RECV - Socket 으로 연결된 클라이언트로부터, 데이터를 수신하자!!!!
                // -----------------

                String recvLine = null;
                String sendLine = null;

                try (sock) {

//					InputStream is = sock.getInputStream();
//					OutputStream os = sock.getOutputStream();

                    // HandShake Protocol + Message (and structure)를 정해야 함!!! (통신하기 전에...)
                    // 서버: (1) 메시지 수신
                    //       (2) 받은 메시지를 그대로 클라이언트로 송신(에코)
                    // 고객: (1) 메시지 송신
                    //       (2) 메시지 수신
                    // 메시지 : 문자열

                    try {
                        InputStream is = sock.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        recvLine = br.readLine();			// Block I/O

                        System.out.println("\t3-4. recvLine : {}" + recvLine);
                    } catch(Exception e) {
                        System.out.println("\t* Exception : {} - {}" + e.getClass().getName() + e.getMessage());
                    } finally {
//						sock.shutdownInput();	// Socket 은 양방향인데, 수신작업이 모두 종료되면, 수신만 먼저 닫을 수 있음!
                    } // try-catch-finally

                    // -----------------
                    // 2. SENT - Socket 으로 연결된 클라이언트에게, 데이터를 보내자!!!
                    // -----------------
                    try {
                        sendLine = "Hello, Client!!!";

                        OutputStream os = sock.getOutputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                        bw.write(sendLine);					// Block I/O

                        // 왜 갑자기 엔터키 코드값(2개)까지 전송할까!???
                        bw.write(CR);
                        bw.write(LF);

                        bw.flush();

                        System.out.println("\t3-5. sendLine : {}" + sendLine);
                    } catch(Exception e) {
                        System.out.println("\t* Exception : {} - {}" + e.getClass().getName() + e.getMessage());
                    } finally {
//						sock.shutdownOutput();
                    } // try-catch-finally

                } // try-with-resources : `sock`

                System.out.println("4. Client Disonnected.");

            } // while

        } // try-with-resources : `serverSocket`

    } // main()

} // end class
