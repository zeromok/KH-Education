package Java.Stream;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReadEx02 {

    public static void main(String[] args) throws Exception {

        @Cleanup
        InputStream is = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream/test.txt");

        int readByteNo;
        byte[] readBytes = new byte[8]; // 읽어 낼 바가지 준비
        String data = "";

        while (true) {
            readByteNo = is.read(readBytes, 2, 3);    // 바가지 일부만 사용
            if(readByteNo == -1) {
                break;
            }

            // 바가지를 2, 3까지 사용 했으므로, 변환할 때에도 똑같이 맞춰줌
            data += new String(readBytes, 2, readByteNo);

//		for(int i=0; i<readBytes.length; i++) {
//			System.out.println(readBytes[i]);
//		} // for

            // try-with-resources
        }
        System.out.println(data);


//		is.close();
    } // main

}// end class
