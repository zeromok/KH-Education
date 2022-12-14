package GenericWildCard;

import java.util.Arrays;

public class WildCardEx {

    // 제네릭타입이 매개변수의 타입으로 지정되면 -> 사용이다.
    public static void registerCourse(Course<?> course) {

        // ? = 와일드카드 타입(구체타입으로 그 어떤 참조타입이든 수용하겠다 하는 의미)
        System.out.println(course.getName() + " [ 수강생 : " + Arrays.toString(course.getStudents()) + " ]");

    } // registerCourse()

    public static void main(String[] args) {

        // 제네릭 클래스 : Course<T>
        Course<Person> personCourse = new Course<Person>("일반인 과정", 5);

        // add<T t> -> add(Person t)
        // 다형성-1 : 부모타입의 참조변수에는, 모든 자식객체가 대입 가능
//        personCourse.add(new Person("일반인"));
//        personCourse.add(new Worker("직장인"));
//        personCourse.add(new Student("학생"));
//        personCourse.add(new HighStudent("고등학생"));

//        System.out.println(personCourse);

        // -------------------------------------------------------------------------------------------------

//        Course<Worker> workerCourse = new Course<Worker>("직장인 과정", 5);
//        Course<Worker> workerCourse = new Course<>("직장인 과정", 5);
//
//        workerCourse.add(new Worker("직장인"));
//
//        System.out.println(workerCourse);

        // -------------------------------------------------------------------------------------------------

//        Course<Student> studentCourse = new Course<>("학생 과정", 5);
//        studentCourse.add(new Student("학생"));
//        studentCourse.add(new HighStudent("고등학생"));   // XX

//        System.out.println(studentCourse);

        // -------------------------------------------------------------------------------------------------

//        Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
//        highStudentCourse.add(new HighStudent("고등학생"));
//
//        System.out.println(highStudentCourse);

        // -------------------------------------------------------------------------------------------------

        // 과정등록 메소드를 이용해보자 !
        registerCourse(personCourse);
//        registerCourse(workerCourse);
//        registerCourse(studentCourse);
//        registerCourse(highStudentCourse);
        System.out.println();
//
//        //registerCourseStudent(personCourse); 			(x)
//        //registerCourseStudent(workerCourse); 			(x)
//        registerCourseStudent(studentCourse);
//        registerCourseStudent(highStudentCourse);
//        System.out.println();
//
//        registerCourseWorker(personCourse);
//        registerCourseWorker(workerCourse);
//        //registerCourseWorker(studentCourse); 			(x)
//        //registerCourseWorker(highStudentCourse); 		(x)


    } // main()

} // end class
