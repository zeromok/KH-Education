package Java.Stream03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) throws IOException {
        // sourceFileName 를 읽어 targetFileName 으로 복사하는 예제

        String sourceFileName = "/Users/mokpro/Desktop/Test/jdk-17_macos-x64_bin.tar.gz";
        String targetFileName = "/Users/mokpro/Desktop/Test/jdk-17_macos-x64_bin.tar.gz";

        // 2개의 입,출력 스트림 필요 : 복사를 위해,
        // 바이트단위입출력, 하위 스트림을 이용하였다.
        FileInputStream fis = new FileInputStream(sourceFileName);
        FileOutputStream fos = new FileOutputStream(targetFileName);

        int readByteNo; // 실제 읽어낸 바이트의 개수
        byte[] readBytes = new byte[100];  // 바가지 생성, 실무에서는 30,40,100정도
        // byte[] readBytes = new byte[fis.available()];  // 딱 맞게 맞춰 쓰는 메소드, 좋지않은방법
        while( (readByteNo = fis.read(readBytes)) != -1 ) {  // EOF(-1)
            fos.write(readBytes, 0, readByteNo);
        }  // while

        fos.flush();  // 출력버퍼 잔류 데이터 강제 flush(방출)

        // 자원 반납
        fos.close();
        fis.close();

        System.out.println("복사가 잘 되었습니다.");

    } // main()

} // end class
