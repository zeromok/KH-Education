package Java.src.main.java.Socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

// 파일 주고받기
public class Client02 {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5001);
        // Socket socket = new Socket(서버의 Ip 주소, 서버의 포트);
        // 서버소켓으로 연결요청을 하는 객체 = Socket
        // 클라이언트에서는 연결요청과 통신을 같이 한다.

        OutputStream os = socket.getOutputStream();

        String filePath = "/Users/mokpro/Downloads/예제소스/chap18/src/sec04/exam03_fileoutputstream/house.jpg";
        // 보낼데이터를 정해준다.

        File file = new File(filePath);

        String fileName = file.getName();

        byte[] fileNameBytes = fileName.getBytes("UTF-8");
        // 보낼데이터의 바이트 배열을 얻어낸다. 어떤 문자셋으로 얻어낼지 정하기

        // 파일의 복사본을 보내자
        fileNameBytes = Arrays.copyOf(fileNameBytes, 100);

        os.write(fileNameBytes);
        // outputStream 을 이용해 서버에게 데이터 보내기

        System.out.println("[파일 보내기 시작] " + fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1000];
        int readByteCount = -1;
        while((readByteCount=fis.read(bytes))!=-1) {
            os.write(bytes, 0, readByteCount);
        }

        os.flush();
        // 데이터가 상대방쪽으로 출력
        System.out.println("[파일 보내기 완료]");

        fis.close();
        os.close();
        socket.close();     // 연결끊기

    } // main()

} // end class
