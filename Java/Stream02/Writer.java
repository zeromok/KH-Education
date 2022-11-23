package Java.Stream02;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Writer {

    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream03/Writer.txt");

        // 바이크기반의 output stream -> 문자기반의  writer 로 변환해주는 보조 스트림
        //Writer writer = new OutputStreamWriter(fos);
        java.io.Writer writer = new OutputStreamWriter(fos, "UTF-8");
        // 소문자로해도, 하이픈을 없애도 다 실행가능

        // Charset 타입의 객체를 얻는 방법 :
        Charset utf81 = Charset.defaultCharset();        // ms949 (for windows)
        Charset utf82 = Charset.forName("UTF-8");        // utf-8
        Charset utf83 = StandardCharsets.UTF_8;


        String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
        writer.write(data);

        writer.flush();

        writer.close();

        System.out.println("파일 저장이 끝났습니다.");

    } // main()

} // end class
