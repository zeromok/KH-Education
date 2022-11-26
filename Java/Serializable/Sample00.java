package Java.Serializable;

import java.io.*;
import java.util.Arrays;

public class Sample00 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");

        //보조스트림을 연결
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // oos.writeObject 메소드가 "객체의 직렬화" 수행
        // oos.writeObject(new Integer(10));  // 취소선 : deprecated (당장은 가능 어느순간 없어지니 쓰지말라)
        // oos.writeObject(new Double(3.14));
        oos.writeObject(10);        // Auto-boxing (어떠한 객체를 줘도 그 타입으로 바꿔준다.)
        oos.writeObject(3.14);      // Auto-boxing
        oos.writeObject(new int[] { 1, 2, 3 });
        oos.writeObject(new String("홍길동"));

//        Integer intObj = 10;    // Auto-boxing
//        int i = intObj;         // Auto-unboxing

        oos.flush();
        oos.close();
        fos.close();

        //진수변환메소드는 인트타입에만 있다.
        String 이진수 = Integer.toBinaryString(100);
        System.out.println("1. 이진수 : " + 이진수);
        String 팔진수 = Integer.toOctalString(100);
        System.out.println("2. 팔진수 : " + 팔진수);
        String 십육진수 = Integer.toHexString(100);
        System.out.println("3. 십육진수 : " + 십육진수);

        // -------------------------------------------------------------------------------------

        // 역직렬화
        FileInputStream fis = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);     // 객체입력보조스트림 생성

        // ois.readObject 메소드 : 객체의 역직렬화 수행(일련의 바이트들 -> 자바객체로 역변환)
        Integer obj1 = (Integer) ois.readObject();
        Double obj2 = (Double) ois.readObject();
        int[] obj3 = (int[]) ois.readObject();
        String obj4 = (String) ois.readObject();

        ois.close();
        fis.close();

        System.out.println(obj1);
        System.out.println(obj2);
        //System.out.println(obj3[0] + "," + obj3[1] + "," + obj3[2]);
        System.out.println(Arrays.toString(obj3));
        System.out.println(obj4);

    } // main()

} // end class
