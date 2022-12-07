package Generic;


import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class BoxingMethodEx {

    public static void main(String[] args) {
        // 제네릭 메소드를 호출하는 것은, 사용에 해당 -> So, 구체타입지정
        //Box<Integer> box1 = Util.<Integer>boxing(100);
        Box<Integer> box1 = Util.boxing(100);
        int intValue = box1.get();

        System.out.println(box1);

        // -----------------------

        // 제네릭 메소드 호출 -> 사용 : 구체타입 지정하면서, 메소드 호춯
        // Box<String> box2 = Util.<String>boxing("홍길동");
//        Box<String> box2 = Util.boxing("홍길동");
//        String stringValue = box2.get();
//
//        System.out.println(box2);
    }

} // end class
