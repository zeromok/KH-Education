package GenericMethod;

public class Util {

    // <- 제네릭 타입 선언부 -> //
    public static <K, V>boolean compare(Pair<K, V>p1, Pair<K, V> p2){
        //public static boolean compare(Pair p1, Pair p2){

        // equals : 비교하는 대상의 내용 자체를 비교
//        boolean keyCompare = p1.getKey().equals(p2.getKey());
//        boolean valueCompare = p1.getValue().equals(p2.getValue());

        // == : 비교하는 대상의 주소값을 비교
        boolean keyCompare = p1.getKey() == p2.getKey();
        boolean valueCompare = p1.getValue() == p2.getValue();

        return keyCompare && valueCompare;

    } // compare()

} // end class
