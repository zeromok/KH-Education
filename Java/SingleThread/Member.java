package Java.SingleThread;

import lombok.Data;

import java.io.Serializable;

// 이 클래스가 데이터를 저장하는 클래스로 바꾸어줌.(즉, 소위 "값객체" 생성용 클래스로 변환)
// 아래의 롬복어노테이션 하나로 통합시킨 것
// 1.@NoArgsConstrutor 2.@Getter 3.@Setter 4.@ToString 5.@EqualsAndHashCode
@Data
public class Member implements Serializable {           // 직렬화 가능해야 함을 표시(tagging)
    private static final long seralVersionUID = 1L;      // 클래스의 버전을 명시적으로 선언

    private Integer id;
    private String name;
    private Integer age;

} // end class
