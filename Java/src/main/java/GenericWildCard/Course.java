package GenericWildCard;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Course<T> {

    private String name;    // 과정명
    private T[] students;   // 수강생을 관리할 배열(T 타입)

    public Course(String name, int capacity) {

        this.name = name;

        /*
            타입파라미터를 원소의 타입으로 가지는 배열객체를 생성하려면
            아래와 같이, 먼저 Object 타입의 배열을 생성한 이후에,
            강제 형변환을 통해, T[] 배열을 만들어야 한다.(문법)
        */
        students = (T[])(new Object[capacity]);

    } // Course()

    // 새로운 수강생을 등록하는 메소드
    public void add(T t) {

        for(int i=0; i< students.length; i++) {

            if(students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }

} // end class
