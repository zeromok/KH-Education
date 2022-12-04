package Java.Send_Receive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ReceiverEx extends Thread{

    private Socket socket;
    private InputStream is;

    public ReceiverEx(String ThreadName, Socket socket) {
        System.out.println("ReceiverEx Constructor invoked. : " + socket);

        this.socket = socket;

        super.setName(ThreadName + "-" + super.getName());

        try {
            this.is = this.socket.getInputStream();
        }catch (IOException e){
            ;;
        }

    } // Constructor

    @Override
    public void run() {
        System.out.println("run() invoked : ");

        // 바이트배열 기반의 보조스트림 : 주로 메모리에, 바이트로 구성된 데이터를 저장하는 용도로 사용
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (baos){
            int ch;
            int LF = 10;
            // 엔터키를 누르면, 두개의 키코드 발생 CRLF -> 코드값으로 하면, 13/10 2개의 코드값 발생
            // 맥, 리눅스, 유닉스 에서는 1개의 코드값만 발생 LF=10

            while ( (ch=is.read()) != -1 ){
                // 입력스트림의 EOF 를 만나기까지 계속 바이트를 읽어냄

                //log.info("ch: {}", ch);
                if(ch != LF){
                    baos.write(ch);
                }else {
                    if (ch == LF){
                        String recv = baos.toString(StandardCharsets.UTF_8);
                        System.out.println("RECV : " + recv);

                        baos.reset();
                    }
                }
            }
        }catch (Exception e){
            ;;
        }finally {
            try {
                baos.close();
            } catch (IOException e) {
                ;;
            }

        }
    }

} // end class
