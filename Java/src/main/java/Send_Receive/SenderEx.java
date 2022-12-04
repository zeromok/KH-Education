package Java.src.main.java.Send_Receive;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SenderEx extends Thread{

    private Socket socket;
    private OutputStream os;

    public SenderEx(String threadName, Socket socket) {
        System.out.println("SendEx Constructor() invoked. : " + socket);

        this.socket = socket;

        // super.setName() : 부모클래스 Thread(super) 의 이름 설정
        super.setName(threadName + "-" + super.getName());

        try{
            this.os = this.socket.getOutputStream();
        }catch (IOException e) {
            ;;
        }

    } // Constructor

    @Override
    public void run() {
        System.out.println("run() invoked.");


        try {
//        int CR = 13;
            int LF = 10;

            for (int i = 0; i < 10; i++) {
                String message = "클라이언트 메시지 - " + i;
                os.write(message.getBytes(StandardCharsets.UTF_8));

//                os.write(CR);
                os.write(LF);

                os.flush();

                System.out.println("SEND : " + message);

                Thread.sleep(1000*1);
            }
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                this.os.close();
            }catch (IOException e) {
                ;;
            }
        }
        System.out.println(" == DONE ==");

    } // run()

} // end class
