package Java.src.main.java.Stream00;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadServer {

    /*
        CR, LF 는 무엇일까?
            키보드에서 <엔터키>를 치면 발생하는 "키코드값" (2개가 발생)
            ***맥 에서는 LF만 발생
    */
    private static final int CR = 13; // Carriage Return (CR) : 아스키 코드 값 13
    private static final int LF = 10; // Line Feed (LF) : 아스키 코드 값 10

    public static void main(String[] args) throws IOException {

        int listenPort = 7777;
        int backLog = 100;

        // ------------

        // Listen Port 만 지정하면, 서버 PC 의 모든 IP 주소를 이용해서 연결요청을 받아들이는 "IP ANY" 가 됨
        ServerSocket serverSocket = new ServerSocket(listenPort, backLog);
        System.out.println("serverSocket : " + serverSocket);

        // -------------

        try(serverSocket) {
            while (true) {

                System.out.println("listening on Port : " + listenPort);
                System.out.println("listening addr : " + serverSocket.getInetAddress());

                serverSocket.setSoTimeout(0); // Infinitely wait for incomming connection
//                serverSocket.setSoTimeout(5*1000); // Finitely wait for the specified milliseconds

                Socket sock = serverSocket.accept();

                System.out.println("==== Client Connected ====");
                System.out.println("\t - sock : " + sock);
                System.out.println("\t - getLocalSocketAddress : " + sock.getLocalSocketAddress());
                System.out.println("\t - getRemoteSocketAddress : " + sock.getRemoteSocketAddress());

                // 아래의 코드 부터는 "자바 입출력 (JAVA I/O)"

                // =================================================================
                // 1. RECV - Socket 으로 연결된 클라이언트로부터, 데이터를 수신하자
                // =================================================================
                String recvLine = null;
                String sendLine = null;

                try(sock) {
                    try {
                        InputStream is = sock.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        recvLine = br.readLine();
                        System.out.println("\t - recvLine : " + recvLine);

                    } catch (Exception e) {
                        System.out.println("\t - Exception : " + e.getClass().getName());
                        System.out.println("\t - Exception : " + e.getMessage());
                    } finally {
//                        sock.shutdownInput();
                    } // try-catch-finally

                    // =========================================================
                    // SENT - Socket 으로 연결된 클라이언트에게, 데이터를 보내자
                    // =========================================================
                    try {
                        sendLine = recvLine;

                        OutputStream os = sock.getOutputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                        bw.write(sendLine);
                        bw.write(CR);
                        bw.write(LF);

                        bw.flush();
                        System.out.println("\t - sendLine : " + sendLine);

                    } catch (Exception e) {
                        System.out.println("\t - Exception : " + e.getClass().getName());
                        System.out.println("\t - Exception : " + e.getMessage());
                    } finally {
//                        sock.shutdownOutput();
                    } // try-catch-finally
                }

                System.out.println("==== Client Disconnected. ====");

            } // while
        } // try-with-resources

    } // main()

} // end class
