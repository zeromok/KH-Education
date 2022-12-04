package Java.Beep;

import java.awt.*;

public class PrintEx01 {

    // ===========================================================
    // 이번 예제는 2개의 작업을 각각 담당하는 멀티스레드를 만들어
    // 병렬로 동시에 각각 작업을 수행시키는 예제
    // ===========================================================

    public static void main(String[] args) {

        //how1 - 새로운 worker thread 를 생성하는 방법(1)
//        Runnable beepTask = new BeepTask();
//        // worker thread 수행할 작업을 정의한 객체 생성
//
//        BeepThread thread = new BeepThread(beepTask);
//        // worker thread 객체 생성
//
//        thread.start();
//        // worker thread 실행(시작)

        // ---------------------------------------------------------------------

        //how2
        // 익명구현객체코딩 기법을 통한, 익명구현객체 생성
//		BeepThread thread = new BeepThread(new Runnable() {
//			// 매개값에 바로 넣어주었다,  메인에서 오버라이딩
//			@Override
//			public void run() {
//                // 새로운 스레드의 엔트리 포인트
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//
//				for(int i=0; i<5; i++) {
//					toolkit.beep();
//
//					try {
//					BeepThread.sleep(250);
//					} catch(Exception e){
//                        ;;
//					}
//				}
//			}
//		});
//
//        thread.start();

        // -------------------------------------------------------------------

        //how3
        Thread thread = new Thread(() -> {
            // () = run()
            // {} = run 의 실행문
            Toolkit toolkit = Toolkit.getDefaultToolkit();

            for(int i=0; i<5; i++) {
                toolkit.beep();

                try {
                    BeepThread.sleep(250);
                } catch(Exception e) {
                    ;;
                }
            }
        });// 람다표현식 -> 생성 : 익명구현객체

        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try {
                BeepThread.sleep(250);
            } catch(Exception e) {
                ;;
            }
        }

    } // main()

} // end class
