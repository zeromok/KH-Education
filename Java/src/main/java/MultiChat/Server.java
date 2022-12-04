package MultiChat;

import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.*;

@Log4j2
public class Server {

    private static final int port = 7777;

    private static final Charset charset = Charset.forName("UTF-8");
//    private static final Charset charset = Charset.forName("MS949");      // OK
//    private static final Charset charset = StandardCharsets.UTF_8;		// XX
//    private static final Charset charset = Charset.defaultCharset();	    // XX

    // 대량의 데이터를 키=값 쌍의 형태로 보관하는 저장소(= 진짜 이름은 컬렉션)
    private static Map<String, Socket> clients;

    public Server() {
        log.trace("Server.Default constructor() 호출");

        // Map 컬렉션(collection) 생성
        clients = new HashMap<>();

        // Map 컬렉션을 Critical Section(임계영역) 내에서도, 다수의 쓰레드에 의한
        // 데이터의 조작을 무결성 있게 처리가능하도록, Thread-Safe 하게 만들어 줌
        clients = Collections.<String, Socket> synchronizedMap(clients);

        log.debug("Synchronized client list created. type: {}", clients.getClass().getName());

    } // Default constructor()


    private void start () {
        log.trace("Server.start() invoked.");

        try (ServerSocket serverSock = new ServerSocket(port);) {
            log.debug("Server started.");

            while(true) {

                log.debug("Listening on {} .....", serverSock);
                Socket sock = serverSock.accept();
                log.debug("Client Connected From {}", sock);

//				---

                ServerReceiver receiver = new ServerReceiver(sock);
                receiver.start();

            } // while

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            log.info("Server finished.");
        } // try-with-resources

    } // start()


    static class ServerReceiver extends Thread {
        final Socket sock;
        final String clientKey;


        ServerReceiver(Socket sock) {
            log.trace("ServerReceiver.Constructor({}) invoked.", sock);

            this.sock = sock;
            this.clientKey = sock.getRemoteSocketAddress().toString();

            // Map.put(key, value) 메소드를 이용하여,
            // 새로이 클라이언트가 연결될 때마다, 해당 클라이언트의 키와 Socket 객체 쌍으로
            // Map 객체에 저장
            clients.put(this.clientKey, sock);
            log.debug("clients: {}", clients);

            try {
                // 새로이 클라이언트가 연결되면, 나머지 모든 살이있는 클라이언트에게
                // Welcome 메시지를 Broadcasting 수행
                String WELCOME = String.format("<<< Client Key: %s Entered. Welcome !!!", this.clientKey);

                publish("SERVER", WELCOME, true);	// Welcome 메시지를 Broadcasting 수행
            } catch (IOException e) {
//				e.printStackTrace();

                clients.remove(this.clientKey);
                log.debug("clients: {}", clients);

                try {
                    // 새로이 클라이언트가 연결되면, 나머지 모든 살이있는 클라이언트에게
                    // BYE 메시지를 Broadcasting 수행
                    String BYE = String.format(">>> Client Key: %s Exited. Bye !!!", this.clientKey);

                    publish("SERVER", BYE, true);	// BYE 메시지를 Broadcasting 수행
                } catch (IOException e1) {;;}
            } // try-finally
        } // Constructor


        @Override
        public void run() {
            log.trace("ServerReceiver.run() invoked.");

            try (this.sock) {

                InputStream is = this.sock.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                try (is; baos;) {

//					----------------------------
//					1. RECEIVE MESSAGES FROM ALL CLIENTS
//					----------------------------

                    int CR=13, LF=10;

                    int ch;
                    String RECV = null;

                    while((ch = is.read()) != -1) {	// Blocking I/O

//						log.info("ch: {}", ch);

                        if(ch != CR && ch != LF) {
                            baos.write(ch);				// Blocking I/O
                        } else {

//							log.info("\t+ excluded: {}", ch);

                            if(ch == LF) {

                                RECV = baos.toString(charset);
//								log.info("RECV: {}", RECV);
                                log.info("RECV from {}: {}", this.clientKey, RECV);

                                baos.reset();

//								----------------------------
//								2. PUBLISH MESSAGES TO ALL ALIVE CLIENTS (Broadcasting)
//								----------------------------
//								publish(this.sock.getRemoteSocketAddress().toString(), RECV, false);

                                String clientKey = this.sock.getRemoteSocketAddress().toString();
                                publish(clientKey, RECV, false);

                            } // if

                        } // if-else

                    } // while : is.read() != 1

                } // try-with-resources : is, baos

            } catch(IOException e) {
//				e.printStackTrace();
            } finally {
                log.info("Client {} Disconnected", this.sock);

                clients.remove(this.clientKey, this.sock);
                log.debug("clients: {}", clients);

                try {
                    String BYE = String.format(">>> Client Key: %s Exited. Bye !!!", this.clientKey);

                    publish("SERVER", BYE, true);
                } catch (IOException e1) {;;}
            } // try-with-resources : this.sock

        } // run

    } // end class : ServerReceiver


    private static void publish(String fromKey, String message, boolean toSelf) throws IOException {
        log.trace("Server.publish({}, {}) invoked.", fromKey, message);

        Set<String> keys = clients.keySet();

        for(String key : keys) {

            log.debug("publish to the client key: {}", key);

            if(!key.equals(fromKey) || toSelf) {

                int CR=13, LF=10;

                Socket sock = clients.get(key);
                OutputStream os = sock.getOutputStream();

                os.write((fromKey+": "+message).getBytes(charset));
                os.write(CR);
                os.write(LF);

                os.flush();

//				log.info("SENT: {}", message);
                log.info("SENT from {}: {}", fromKey, message);

            } else {
                log.debug("Excluding client itself key: {} to publish.", fromKey);
            } // if-else

        } // enhanced for

    } // publish()


    public static void main(String[] args) {
        log.trace("main({}) invoked", Arrays.toString(args));

//		Charset.availableCharsets().forEach((key, cs) -> {
//			log.debug("{}", key);
//		});

        new Server().start();

    } // main()

} // end class
