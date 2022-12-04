package Java.src.main.java.Stream02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StreamAssistance00 {

    public static void main(String[] args) throws Exception {

        InputStream is = System.in;

        // InputStream -> Reader 로 변환하는 보조스트림 #1
        Reader reader = new InputStreamReader(is);

        // Reader -> BufferedReader 로 변환하는 보조스트림 #2
        BufferedReader br = new BufferedReader(reader);

        System.out.print("입력: ");
        String lineString = br.readLine();

        System.out.println("출력: " + lineString);

    } // main()

} // end class
