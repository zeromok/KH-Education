package Java.Serializable;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

@ToString
@NoArgsConstructor
public class Child
        extends Parent
            implements Serializable { // serializable 함 즉, 객체의 (역)직렬화 가능

    public String childField; // 자식 클래스의 인스턴스 필드


    // 출처가 애매모호하다 자바언어스펙문서에서만 언급
    // 목적 : 아래의 메소드 내에서, 직렬화 불가능한 부모객체의 필드를 개발자가 직접
    // 목적에 맞게 직렬화 할 수 있는 기회 제공
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Child::writeObject(out) invoked");

        out.writeUTF(field);       // 부모에게서 받은 직렬화 불가능한 필드를 직접 역직렬화 수행

        // 아래의 메소드는 JVM 이 원래 수행하는 직렬화 메소드
        out.defaultWriteObject();   // 기본 직렬화 수행
    }

    // 출처가 애매모호하다 자바언어스펙문서에서만 언급
    // 목적 : 아래의 메소드 내에서, 직렬화 불가능한 부모객체의 필드르르 개발자가 직접
    // 목적에 맞게 직렬화 할 수 있는 기회 제공
    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Child::writeObject(in) invoked");

        field = in.readUTF();      // 부모에게서 받은 직렬화 불가능한 필드를 직접 역직렬화 수행

        // 아래의 메소드는 JVM 이 원래 수행하는 역직렬화 메소드
        in.defaultReadObject();     // 기본 역직렬화 수행
    }


} // end class
