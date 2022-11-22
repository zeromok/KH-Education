package Java.Stream00;

import lombok.Cleanup;

public class Read {

    // try-with-resources block 을 이용하면, 예외발생여부와 상관없이
    // 안전하게 자원객체(들)을 close 할 수 있다!!!(그래서 매우 중요하다!!!!)
    public static void main(String[] args) throws Exception {

        @Cleanup
        UserDefinedResource1 res1 = new UserDefinedResource1();
        @Cleanup
        UserDefinedResource2 res2 = new UserDefinedResource2();
        @Cleanup
        UserDefinedResource3 res3 = new UserDefinedResource3();

//        try(res1; res2; res3) { // @since8 and above
        // @Cleanup 으로 대체 할 수 있다.

            String movie300 = "300";
            int i300 = Integer.parseInt(movie300);
            System.out.println("i300 : " + i300);

//        } // try

    }// main

}// end class

class UserDefinedResource1 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("UserDefinedResource1 :: close() invoked.");
    } // close()

} // end class

class UserDefinedResource2 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("UserDefinedResource2 :: close() invoked.");
    } // close()

} // end class

class UserDefinedResource3 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("UserDefinedResource3 :: close() invoked.");
    } // close()

} // end class
