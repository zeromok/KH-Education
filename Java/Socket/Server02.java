package Java.Socket;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 파일 주고받기
public class Server02 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        // 클라이언트의 socket 으로부터 연결요청이 오게되면 serverSocket 에서 받아준다.
        // 특정포트를 통해...5001 = 프로그램 식별번호

        serverSocket.bind(new InetSocketAddress("localhost", 5001));
        // 5001 포트가 serverSocket 의 bind 포트라고 부른다.

        System.out.println("[서버 시작]");

        while(true) {
            try {       // 연결수락 코드
                Socket socket = serverSocket.accept();
                // 연결수락이 되기 전에 대기하는 메소드 = .accept(); = 연결을 수락하는 역할을 한다.
                // 통신소켓이 만들어졌다고 볼 수 있다.

                InputStream is = socket.getInputStream();
                // 데이터를 받기위해 InputStream 을 선언

                byte[] bytes = new byte[100];
                // 데이터를 받기위해 바이트 배열을 생성 했다.

                int readByteCount = -1;

                is.read(bytes, 0, 100);
                // 스트림의 read 메소드를 이용 / 매개값으로 바이트 배열을 준다.
                // read 는 읽은 데이터를 배열에 저장하고 앍은 바이트 수를 리턴
                // read 메소드는 상대방이 데이터를 보내기 전까지 대기상태 -> 블로킹

                // 블로킹이 해제되는 경우
                // 1. 상대방이 데이터를 보냈을때 = 읽은 바이트 수를 리턴 한다.
                // 2. 상대방이 정상적으로 소켓을 닫았을때 (.close()) = -1
                // 3. 상대방이 비정상적으로 종료 = IOException 발생

                String fileName = new String(bytes, 0, 100, "UTF-8");
                // 받은 데이터를 문자열로 변환
                // bytes 의 배열의 크기를 정해 정해진 문자셋으로 변환 (주는쪽과 받는쪽의 문자셋은 같아야 한다.)

                // trim() : 모든 공백이 제거된 문자열 반환
                fileName = fileName.trim();

                System.out.println("[파일 받기 시작] " + fileName);

                FileOutputStream fos = new FileOutputStream("/Users/mokpro/Temp/" + fileName);

                while((readByteCount=is.read(bytes))!=-1) {
                    fos.write(bytes, 0, readByteCount);
                }
                fos.flush();
                System.out.println("[파일 받기 완료]");

                fos.close();
                is.close();
                socket.close();
            } catch(Exception e) {
                break;
            }
        }

        serverSocket.close();       // 서버 종료 메소드
        System.out.println("[서버 종료]");

    } // main()

} // end class
