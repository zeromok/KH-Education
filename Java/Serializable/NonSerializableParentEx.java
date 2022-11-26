package Java.Serializable;

import java.io.*;

public class NonSerializableParentEx {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");

        // 객체출력보조스트임 객체 생성
        ObjectOutputStream os = new ObjectOutputStream(fos);

        // 자식객체 생성 -> 잊지말자 이때 부모객체부터 먼저 생성 된다.
        Child child = new Child();      // 직렬화 대상 객체 생성 및 필드 초기화
        child.field = "홍길동";
        child.childField = "홍삼원";

        System.out.println(child);          // Child(childField=홍삼원)
        System.out.println(child.field);    // 홍길동


        // 객체를 직렬화 할 때 직렬화 대상 객체가 부모/자식 상속관계를 가진다면,
        // 상속관계를 따라서, 부모객체까지 직렬화 대상에 포함시켜 수행
        os.writeObject(child);     // 객체의 직렬화 수행

        os.flush();
        os.close();
        fos.close();

        FileInputStream fis = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");

        ObjectInputStream ois = new ObjectInputStream(fis);  // 객체입력보조스트림 생성
        Child child2 = (Child) ois.readObject();             // 객체의 역직렬화 수행

        System.out.println(child2);         // Child(childField=홍삼원)
        System.out.println(child2.field);   // 홍길동


        ois.close();
        fis.close();

    } // main()

} // end class
