package Java.src.main.java.Beep;

import java.awt.*;

public class BeepTask implements Runnable{

    @Override
    public void run() {
        // 이 메소드가 바로, 각각의 worker thread 의 엔트리포인트 역할 수행
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++) {
            toolkit.beep();

            try {
                BeepThread.sleep(250);
            } catch(Exception e) {
                ;;
            }
        }
    }//run : 이 블록을 만나면 작업종료 / 해당 스레드 종료

} // end class
