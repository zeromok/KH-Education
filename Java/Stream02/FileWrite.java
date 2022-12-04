package Java.Stream02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) throws IOException {

        // 파일에 써보자...! (없으면 만들어준다.)
        File file = new File("/Users/mokpro/Desktop/KH-Education/Java/Stream03/FileWrite.txt");
        FileWriter fw = new FileWriter(file, true);
        // 파일이 이미 존재할 경우 데이터를 출력하면 파일을 덮어쓰는 단점이있다.
        // 그래서 위와 같은 방법으로 append 처럼 처리 한다.

        fw.write("FileWriter는 한글로된 " + "\r\n");
        fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
        fw.flush();
        fw.close();
        System.out.println("파일에 저장되었습니다.");


//		for(int i=0; i<1000000000; i++);{
//			BeepThread.sleep(1000 * 2);
//
//			System.out.println("done.");
//		}

    } // main()

} // end class
