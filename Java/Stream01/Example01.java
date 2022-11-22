package Java.Stream01;

import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Example01 {

    public static void main(String[] args) throws IOException {

        @Cleanup
        Reader reader = new FileReader("/Users/mokpro/Desktop/KH-Education/Java/Stream01/test.txt");

        int readCharNo;
        char[] cbuf = new char[2]; // 바가지 준비
        String data = "";

        while( true ) {
            readCharNo = reader.read(cbuf);

            if(readCharNo == -1) {
                break;
            }

            //읽어낸 문자배열 -> String 으로 변환
            data += new String(cbuf, 0, readCharNo);
        }
        System.out.println(data);

        reader.close();

    } // main()
} // end class
