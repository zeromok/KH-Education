package Java.src.main.java.Stream02;

import java.io.FileOutputStream;

public class PrintStream {

    // 마치 프린터로 출력하듯이 할 수 있게 도와주는 보조 스트림 예제
    // PrintStream, PrintWriter
    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream03/PrintStream.txt");
        java.io.PrintStream ps = new java.io.PrintStream(fos);

        // 보조스트림의 다양한 출력 메소드를 통한, 기본타입(문자열 포함) 출력
        ps.println("[프린터 보조 스트림]");
        ps.print("마치 ");
        ps.println("프린터가 출력하는 것처럼 ");
        ps.println("데이터를 출력합니다.");

        ps.flush();

        ps.close();
        fos.close();

    } // main()

} // end class
