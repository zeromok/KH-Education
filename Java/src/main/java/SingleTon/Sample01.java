package Java.src.main.java.SingleTon;

/*
    특수한 기능을 수행하도록 클래스를 설계하는 패턴을 "설계패턴"이라 하며, 대략 30가지가 있는데, 그 중에 하나가 "Singleton Pattern"
    목적은, 오로지 단한번 객체가 생성되어서, JVM 이 죽을 때까지 계속 하나의 객체로만 유지되어야 할 이유가 있을 때 적용
*/
/*
    =================
    싱글톤 패턴이란?
    =================
    어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴
    즉, 생성자의 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 최초 생성된 객체를 반환 해주는것
*/
public class Sample01 {    // 싱글톤의 기본패턴

    // 핵심 - 2
    // 접근제한자는 클래스 내부에서는 아무런 효력이 없다.
    private static Sample01 singleton;

    static {
        System.out.println();
        singleton = new Sample01(); // class loader
    } // ??? - static initializer = 정적멤버(필드)를 여기서 초기화

    // 핵심 - 1
    // 외부 클래스에서 임의로 객체를 생성하지 못하도록,
    // Private 생성자로 선언 -> new 생성자(); 구문아 성립되지 못함 (왜? 생성자가 안보이니깐.)
    private Sample01(){;;}   // default constructor
    // 생성자의 목적 - 인스턴스 필드의 초기화

    // 클래스의 필드인 Singleton 의 값을 반환
    public static Sample01 getInstance(){
        return Sample01.singleton;
    }

}// end class

