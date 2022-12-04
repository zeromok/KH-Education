package MultiChat;

import lombok.extern.log4j.Log4j2;

import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Map;

@Log4j2
public class Server {

    private static final int port=7777;

    private static final Charset charset = Charset.forName("UTF-8");
//    private static final Charset charset = Charset.forName("MS949");      // OK
//    private static final Charset charset = StandardCharsets.UTF_8;		// XX
//    private static final Charset charset = Charset.defaultCharset();	    // XX

    // 대량의 데이터를 키=값 쌍의 형태로 보관하는 저장소(= 진짜 이름은 컬렉션)
    private static Map<String, Socket> clients;

    public Server() {
        log.trace("Default constructor invoked.");
    }




} // end class
