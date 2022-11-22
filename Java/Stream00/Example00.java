package Java.Stream00;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Example00 {

    public static void main(String[] args) throws IOException {

        int listenPort = 7777;
        int backLog = 100;

        ServerSocket serverSocket = new ServerSocket(listenPort, backLog, InetAddress.getLocalHost());
        System.out.println("serverSocket : " + serverSocket); // ServerSocket[addr=mokk-MacBookPro.local/127.0.0.1,localport=7777]

        /*
            try(serverSocket) { // ()안에, 반드시 close 해야 할 자원객체의 참조변수를 넣어라
                ;;
            } // try-with-resources

            serverSocket.close(); // 자원해제 수행
        */

        // --------------------------------------------------------

        try(serverSocket) {

            System.out.println("Server listening on Port : " + listenPort);
            System.out.println("Server listening on addr : " + serverSocket);

            while (true) {

                Socket socket = serverSocket.accept(); // Block I/O

                try(socket) {
                    System.out.println("socket : " + socket);
                    System.out.println("\t - getInetAddress : " + socket.getInetAddress());
                    System.out.println("\t - getPort : " + socket.getPort());
                    System.out.println("\t - getLocalPort : " + socket.getLocalPort());
                    System.out.println("\t - getRemoteSocketAddress : " + socket.getRemoteSocketAddress());
                } // try-with-resources
            } // while
        } // try-with-resources

    }// main()

}// end class
