package Java.Beep;

import java.awt.*;

public class BeepThread extends java.lang.Thread {

    // 스레드를 직접 상속받은 자식클래스에서,
    // 부모클래스로부터 물려받은 메소드 중에, run() 메소드를 오버라이딩 수행
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++) {
            toolkit.beep();

            try {
                java.lang.Thread.sleep(250);
            } catch(Exception e) {
                ;;
            }
        }
    } // run()

} // end class
