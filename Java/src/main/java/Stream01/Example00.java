package Java.src.main.java.Stream01;

import lombok.Cleanup;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Example00 {

    public static void main(String[] args) throws IOException {

        /*
            Reader
                : 문자 스트림을 읽기 위한 추상클래스
                : 하위 클래스가 구현해야 하는 유일한 메소드는 .read(), close() 이다.
        */
        @Cleanup
        Reader reader = new FileReader("/Users/mokpro/Desktop/KH-Education/Java/Stream01/test.txt");

        int readData;

        while ( true ) {
            readData = reader.read();

            if(readData == -1) {    // EOF(End-Of-File, -1)
                break;
            }

            System.out.print((char)readData);
            // 캐스팅이 들어간 이유? = int 타입으로 반환되어서
            // 숫자를 다룰땐 기본적으로 int 타입

        } // while()

        reader.close();

    } // main()

} // end class
