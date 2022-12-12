package GenericWildCard;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Student extends Person {

    public Student(String name) {

        // super() : 부모클래스의 생성자를 호출
        //         : 항상 맨 처음에 작성해줘야 한다.
        // 자식클래스의 생성자에 넘어온 매개변수를 부모클래스의 생성자를 호출하며, 매개변수에 넣어준다.
        super(name);

        log.trace("자식 클래스 등장");
        log.info("자식 say : {}", name);

    } // Student()

    public static void main(String[] args) {

        Student student = new Student("나다.");

    } // main()

} // end class
