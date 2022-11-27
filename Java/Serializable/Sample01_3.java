package Java.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Sample01_3 {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");
        // 기본 스트림 생성

        ObjectInputStream ois = new ObjectInputStream(fis);     // 객체입력보조스트림 생성

        Sample01 obj = (Sample01) ois.readObject();               // 파일에 저장된 객체 복원

        System.out.println("field1: " + obj.sample01Field);                         // int
        System.out.println("field2.field1: " + obj.field01_1.sample01_1Field);      // ClassB
        System.out.println("field3: " + Sample01.staticField);                      // static
        System.out.println("field4: " + obj.transientField);                        // transient
    }

} // end class
