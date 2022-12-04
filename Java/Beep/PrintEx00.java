package Java.Beep;

import java.awt.*;

public class PrintEx00 {

    // ====================
    // 싱글스레드 작업 예제
    // ====================

    // 2개의 작업( BeepTask )을 순차실행 할 수 밖에 없다.
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++) {
            toolkit.beep();
            try {
                BeepThread.sleep(500);
            } catch(Exception e) {
                ;;
            }
        }
// -------------------------------------------------------------------

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try {
                BeepThread.sleep(500);
            } catch(Exception e) {
                ;;
            }
        }

    } // main()

} // end class
