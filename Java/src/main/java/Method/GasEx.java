package Java.src.main.java.Method;

public class GasEx {

    public static void main(String[] args) {
        Gas myGas = new Gas();

        myGas.setGas(5); // 메소드 호출

        boolean gasState = myGas.isLeftGas(); // 메소드 호출
        if(gasState){
            System.out.println("출발합니다.");
            myGas.run(); // 메소드 호출
        }
        if(myGas.isLeftGas()){ // 메소드 호출
            System.out.println("gas를 주입할 필요가 없습니다.");
        }else {
            System.out.println("gas를 주입해 주세요.");
        }
    }

}// end class
