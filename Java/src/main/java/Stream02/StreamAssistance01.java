package Java.src.main.java.Stream02;

import java.io.*;

public class StreamAssistance01 {

    // 프로그램이 다양한 기본타입의 변수를 가지고 입/출력을 수행할 수 있도록
    // 보조해주는 보조스트림으로 DataInput/DataOutput 이 있다.
    public static void main(String[] args) throws IOException {

//        FileOutputStream fos = new FileOutputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream03/StreamAssistance01.txt");
//        DataOutputStream dos = new DataOutputStream(fos);
//
//        dos.writeUTF("홍길동");        // 문자열 출력
//        dos.writeDouble(95.5);        // double 값 출력
//        dos.writeInt(1);              // int 값 출력
//
//        dos.writeUTF("감자바");        // 문자열 출력
//        dos.writeDouble(90.3);        // double 값 출력
//        dos.writeInt(2);              // int 값 출력
//
//        // 자원해제 순서중요 ! 체인으로 묶인 연결순서대로 보조스트림부터 닫고 -> 기본 스트림 닫아야함 !!!
//        dos.flush(); dos.close(); fos.close();

//      -------------------------------------------------------------------------

        FileInputStream fis = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Stream03/StreamAssistance01.txt");
        DataInputStream dis = new DataInputStream(fis);

        for(int i=0; i<2; i++) {
            // 파일에 쓰여진 다양한 타입의 값을 다시 읽어낼 수가 있습니다.
            // 단 !!! 파일에 쓰기한 순서대로 다시 읽어내야 한다.
            String name = dis.readUTF();
            double score = dis.readDouble();
            int order = dis.readInt();
            System.out.println(name + " : " + score + " : " + order);
        }

        dis.close(); fis.close();

    } // main()

} // end class
