package Java.src.main.java.Send_Receive;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Server {

    private static final int port=7777;

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("main() invoked. : " + Arrays.toString(args));

        ServerSocket serverSocket = new ServerSocket(port);

        try (serverSocket){
            while (true){

                System.out.println("Listening on ... " + serverSocket);
                //System.out.println("Listening on {} ...." +  serverSocket);

                Socket sock = serverSocket.accept();
                System.out.println("\t + Client connected from : " + sock);
                //System.out.println("\t + Client connected from {}" +  sock);

//                ---------------------------------------------------------------------

                new ReceiverEx("ReceiverEx", sock).start();
                //new Receiver02("Receiver02", sock).start();

//                ---------------------------------------------------------------------

                new SenderEx("SenderEx", sock).start();

            }
        }

    } // main()

} // end class
