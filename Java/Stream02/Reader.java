package Java.Stream02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Reader {

    public static void main(String[] args) throws IOException {

        InputStream is = System.in;  //기본 스트림 (표준입력) : 데이터를 입력받기 위한...

        java.io.Reader reader = new InputStreamReader(is);  // 보조스트림 연결

        int readCharNo;

        char[] cbuf = new char[30];

        System.out.print("Prompt>>> ");

        while ( ( readCharNo = reader.read(cbuf) ) != -1 ) {

            String data = new String(cbuf, 0, readCharNo);
            System.out.println("1. cbuf :" + Arrays.toString(cbuf));
            System.out.println(data);

        } // while()

        reader.close();

    } // main()

} // end class
