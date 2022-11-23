package Java.Stream03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("/Users/mokpro/Desktop/Test/source/chap18/src/sec04/exam04_file_reader/FileReaderExample.java");


        int readCharNo;

        // 문자기반 입출력 스트림에서는 , 바가지의 타입만 byte -> char 로 변경
        char[] cbuf = new char[100];
        while ((readCharNo=fr.read(cbuf)) != -1) {  // EOF(-1)

            // offset, length 기반
            String data = new String(cbuf, 0, readCharNo);
            System.out.print(data);
        }
        fr.close();

    } // main()

} // end class
