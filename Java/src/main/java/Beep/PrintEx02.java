package Java.src.main.java.Beep;

public class PrintEx02 {

    public static void main(String[] args) {

        //how1
//        Thread thread = new BeepThread();

        // ------------------------------------------------

        // how1-1
        BeepThread thread = new BeepThread();

        // ------------------------------------------------

        // how2 - 익명객체 이용
//        Thread thread = new BeepThread() {
//
//            @Override
//            public void run() {
//                Toolkit toolkit = Toolkit.getDefaultToolkit();
//
//                for (int i=0; i<5; i++) {
//                    toolkit.beep();
//
//                    try {
//                        java.lang.Thread.sleep(250);
//                    } catch (Exception e){;;}
//                }
//            }
//        };

        // result
        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try {
                java.lang.Thread.sleep(250);
            } catch(Exception e) {;;}
        }

    } // main()

}// end class
