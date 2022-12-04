package Java.src.main.java.Serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Sample02_1 {

    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //
        Sample02 classC = new Sample02();
        classC.sample02Field = 1;      // 필드값 초기화(당연히 직렬화 대상)

        oos.writeObject(classC);        // 파일에 객체 직렬화 수행
        System.out.println("1. sample02 : " + classC);

        oos.flush();
        oos.close();
        fos.close();

    } //main()

} // end class
