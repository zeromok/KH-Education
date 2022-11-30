package Java.SingleThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ObjectSocketServer {

    public static void main(String[] args) throws IOException {

        int listenPort = 7777;
        int backLog = 100;

//		-----------------------

        ServerSocket serverSocket = new ServerSocket(listenPort, backLog);
        System.out.println("1. serverSocket : " + serverSocket);

//		-----------------------

        try (serverSocket) {

            while (true) {

                System.out.println("-----------------");
                System.out.println("2. Server lostening on address : " + serverSocket.getLocalSocketAddress());
                System.out.println("-----------------");

                Socket socket = serverSocket.accept();

                System.out.println("3. Clent connected from address : " + socket.getRemoteSocketAddress());

//				-----------------------
//				Recv
//				-----------------------
                try (socket) {

                    InputStream is = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);

                    Member member = (Member) ois.readObject();
                    System.out.println("4. Received a member from client : " + member);

//					-----------------------
//					Sent
//					-----------------------
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);

                    member.setId(2);
                    member.setName("Trinity");
                    member.setAge(33);

                    oos.writeObject(member);
                    oos.flush();


                    System.out.println("5. Sended a modified member to client : " + member);
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                } // try-with-resources : 'socket'

            } // while

        }// try-with-resources : 'serverSocket'

    } // main()

} // end class
