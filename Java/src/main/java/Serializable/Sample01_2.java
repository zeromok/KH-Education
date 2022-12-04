package Java.src.main.java.Serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Sample01_2 {

    public static <sample01> void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");  // 기본출력스트림
        ObjectOutputStream oos = new ObjectOutputStream(fos);                     // 객체출력보조스트림

        // Serializable 하므로, 객체의 (역)직렬화 가능
        Sample01 classA = new Sample01();      // Serializable 꼬리표를 달고 있는 객체 생성

        // 객체의 필드를 직접 초기화
        classA.sample01Field = 1;          // int type field

        classA.field01_1.sample01_1Field = 2;   // other serializable
        // classA(sample2)의 field2는 sample3의 인스턴스 즉, sample3의 field1

        //classA.staticField = 3;        // static field - excluded
        Sample01.staticField = 3;         // static field - excluded
        classA.transientField = 4;          // transient - excluded

        // 객체의 직렬화를 통하여, 파일에 객체저장
        oos.writeObject(classA);

        // 자원정리
        oos.flush();
        oos.close();
        fos.close();

    } // main()

} // end class
