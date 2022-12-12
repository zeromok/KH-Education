package GenericMethod;

public class Util {

    // <- 제네릭 타입 선언부 -> //
    public static <K, V>boolean compare(Pair<K, V>p1, Pair<K, V> p2){
        //public static boolean compare(Pair p1, Pair p2){

        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());
        // equals = 주소비교

        return keyCompare && valueCompare;

    } // compare()

} // end class
