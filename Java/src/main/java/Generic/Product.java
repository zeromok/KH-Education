package Generic;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
// 제네릭타입 중, "제네릭 클래스"를 "선언" -> 타입파라미터를 선언
public class Product <T, M>{    // 다중(멀티)타입파라미터

    private T kind; // 종류
    private M model; // 모델

} // end class
