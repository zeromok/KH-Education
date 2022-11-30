package Java.SingleThread;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ObjectSocketClient {

    public static void main(String[] args) throws IOException {

        Member member = new Member();
        member.setId(0);
        member.setName("mokk");
        member.setAge(30);

        String serverAddress = "localhost";
        int serverPort = 7777;

        Socket socket = new Socket();

        socket.connect(new InetSocketAddress(serverAddress, serverPort));

        //		--------------------------
//		SEND
//		--------------------------

        try (socket) {

            try {
                Object sendObject = member;

                OutputStream os = socket.getOutputStream();
                ObjectOutputStream bw = new ObjectOutputStream(os);

                bw.writeObject(sendObject);				// Block I/O

                // 왜? 엔터키 코드값을 전송할까요!?
//                bw.write(CR);
//                bw.write(LF);

                bw.flush();

                System.out.println("2. sendLine : " + sendObject);
            } catch(Exception e) {
                System.out.println("* Exception : {} - {}" + e.getClass().getName() + e.getMessage());
            }
//            finally {
//				sock.shutdownOutput();	// Socket 객체는 입/출력을 선택적으로 닫을 수 있습니다!
//            } // try-catch-finally


//			-----------------------
//			RECV
//			-----------------------

            try {

                InputStream is = socket.getInputStream();
                ObjectInputStream br = new ObjectInputStream(is);

                Object recvLine = br.readObject();		// Block I/O

                System.out.println("3. recvLine : " + recvLine);
            } catch(Exception e) {
                System.out.println("* Exception : {} - {}" + e.getClass().getName() + e.getMessage());
            }
//            finally {
//				sock.shutdownInput();
//            } // try-catch-finally

        } // try-with-resources
//
        System.out.println("4. Disconnected.");

    } // main()

} // end class
