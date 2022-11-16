package Java.Method;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter // set 메소드 생성
@RequiredArgsConstructor
// 기본값을 가지지 않는 생성자를 만들어 준다. 매개변수로는 @NonNull 로 정한다.
// 객체가 생성될 때 반드시 @NonNull 가 붙어 있는 필드는 초기화 해줘야한다는 의미
public class Car {

    // 필드
    @NonNull    // 이 어노테이션을 붙이면, 해당 필드는 값으로 절대 null 을 가져서는 안된다는 의미
    String model;

    int speed;

    String color;

    //생성자
//    public Car(String model){
//        this.model = model;
//    }

    // 메소드
    void run(){
        for(int i=10; i<=50; i+=10){
            this.setSpeed(i);
        }

    }

}// end class
