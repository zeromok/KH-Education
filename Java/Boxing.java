package Java;

public class Boxing {

    // Auto-Boxing / Auto-UnBoxing
    public static void main(String[] args) {

        // -------------------------- //
        // 기본타입    |     Wrapper Types(참조타입)
        // -------------------------- //


        // Box --> 객체
        // Box 안에 담을 물건 --> 기본타입의 값
        //

        byte b = 10;
//		Byte byteObj = new Byte(b); 	// 취소선 : Deprecated (더이상 사용하지 말아라!!!)
        Byte byteObj1 = 10; 				// Auto-boxing

        System.out.println(byteObj1); 					// Auto-unboxing


        // -----------------------

        int i = 1000;
        Integer intObj = i;

        System.out.println(intObj);

        // -------------------------

        boolean bool = true;
        Boolean boolObj = bool;

        System.out.println(boolObj);

        // ---------------------------

        byte bValue = Byte.parseByte(null);
        Byte byteObj = Byte.valueOf(bValue);

//        System.out.println(byteObj); // : Cannot parse null string

    } // main

} // end class
