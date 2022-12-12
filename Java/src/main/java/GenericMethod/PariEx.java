package GenericMethod;

public class PariEx {

    public static void main(String[] args) {

        // 제네릭 타입 클래스 : Pair<K, V>
        Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
        Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");

        System.out.println(p1 == p2);       // false
        System.out.println(p1.equals(p2));  // false

        // 제네릭 메소드 : <T> boolean compare(...)
        boolean result1 = Util.<Integer, String>compare(p1, p2);

        if(result1){
            System.out.println("논리적으로 동등한 객체입니다.");
        }else {
            System.out.println("논리적으로 동등하지 않은 객체입니다.");
        }


    } // main()

} // end class
