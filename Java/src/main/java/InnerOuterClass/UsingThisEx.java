package InnerOuterClass;

public class UsingThisEx {

    public static void main(String[] args) {

        // 1. 가장 바깥쪽 클래스의 인스턴스 생성
        UsingThis outter = new UsingThis();

        // 2. 멤버클래스의 인스턴스 생성
        UsingThis.Inner inner = outter.new Inner();

        // 3. 멤버클래스에서 생성한 객체의 메소드 호출
        inner.method();

    } // main()

} // end class
