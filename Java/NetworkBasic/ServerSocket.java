package Java.NetworkBasic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ServerSocket {

    public static void main(String[] args) throws IOException {

        int listenPort = 7777;
        int backLog = 100;

//		-----

		java.net.ServerSocket serverSocket00 = new java.net.ServerSocket();

//		serverSocket00.bind(new InetSocketAddress(listenPort));	// 지정된 Listen 포트를 바인딩
//        System.out.println("1. serverSocket00 : " + serverSocket00); // ServerSocket[addr=0.0.0.0/0.0.0.0,localport=7777]

//		serverSocket00.bind(new InetSocketAddress(InetAddress.getLocalHost(), listenPort));
//        System.out.println("2. serverSocket00 : " + serverSocket00); // ServerSocket[addr=mokk-MacBookPro.local/127.0.0.1,localport=7777]

//		serverSocket00.bind(new InetSocketAddress(InetAddress.getLocalHost(), listenPort), backLog);
//        System.out.println("3. serverSocket00 : " + serverSocket00);

//		serverSocket00.bind(new InetSocketAddress("0.0.0.0", listenPort), backLog);
//        System.out.println("4. serverSocket00 : " + serverSocket00);


//		-----

		java.net.ServerSocket serverSocket01 = new java.net.ServerSocket(listenPort);
        // ServerSocket[addr=0.0.0.0/0.0.0.0,localport=7777]

//		-----

//		java.net.ServerSocket serverSocket02 = new java.net.ServerSocket(listenPort, backLog);
        // ServerSocket[addr=0.0.0.0/0.0.0.0,localport=7777]

//		-----

//        java.net.ServerSocket serverSocket03 = new java.net.ServerSocket(listenPort, backLog, InetAddress.getLocalHost());
          // ServerSocket[addr=mokk-MacBookPro.local/127.0.0.1,localport=7777]

//		-----


    }// main()
}// end class
