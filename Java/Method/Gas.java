package Java.Method;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Getter @Setter
/*
    클래스 위에 붙으면 클래스 전체영역에 영향
    필드 옆에 붙으면 선택한 필드만 영향
*/
@NoArgsConstructor
public class Gas {

    // 1. 필드
    private int gas;

    // 2. 생성자 - 롬복으로 기본생성자 생성 (@NoArgsConstructor)

    // 3. Getter / Setter 메소드

    // 3-1. Getter : 필드의 값을 반환해주는 메소드
    // "Get" + 필드명(){}
//    public int getGas(){ // 'gas' 이름의 프로퍼티 생성
//        return this.gas;
//    }

    // 3-2. Setter : 필드의 값을 반환해주는 메소드
    // "Set" + 필드명(){}
//    public void setGas(int gas){
//        this.gas = gas;
//    }

    // 3. 메소드
    void setGas(int gas){
        this.gas = gas; // 리턴값이 없는 메소드로 매개값을 받아서 gas 필드값을 변경
    }

    // 4. 모델링 대상 객체의 기능(행위)를 메소드로 구현
    boolean isLeftGas(){
        if(gas == 0){
            System.out.println("gas가 없습니다.");
            return false; // false 리턴
        }
        System.out.println("gas가 있습니다.");
        return true; // true 리턴
    }
    void run(){ // 리턴값이 없는 메소드
        while (true){
            if(gas>0){
                System.out.println("달립니다. (gas 잔량 : " + gas + ")");
                gas -=1;
            }else {
                System.out.println("멈춥니다. (gas 잔량 : " + gas + ")");
                return; // 메소드 실행 종료
            }
        }
    }

}// end class
