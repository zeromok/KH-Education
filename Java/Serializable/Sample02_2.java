package Java.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Sample02_2 {

    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("/Users/mokpro/Desktop/KH-Education/Java/Serializable/Object.dat");

        ObjectInputStream ois = new ObjectInputStream(fis);

        Sample02 classC = (Sample02) ois.readObject();
        System.out.println("2. sample02 : " + classC);

        //System.out.println("field1: " + classC.field1);

    } // main()

} // end class
