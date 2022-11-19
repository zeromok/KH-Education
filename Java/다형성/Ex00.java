package Java.다형성;

public class Ex00 {

    public static void main(String[] args) {

        int grade = 6;
        String memberType = null;

        switch (grade) {
            case 1:
                memberType = "VVIP";
                break;
            case 2:
                memberType = "VIP";
                break;
            case 3:
                memberType = "General";
                break;
            case 4:
                memberType = "General";
                break;
            case 5:
                memberType = "General";
                break;
        }// switch()

        // =============================
        // 새로운 스위치 문 -> 값을 반환
        // =============================
        memberType = switch (grade) {
            case 1 -> "VVIP";
            case 2 -> "VIP";
            case 3, 4, 5 -> "General";
            default -> "Not Member";
        }; // switch Expression

        // 실행문장을 생략, 디폴트 생략
        // -> 표현 오른쪽은 꼭 단일수행이 아니여도 된다. {} 중괄호 사용
        memberType = switch (grade) {
          case 1 -> { System.out.println("VVIP"); }
          case 2 -> { System.out.println("VIP"); }
          case 3, 4, 5 -> { System.out.println("General"); }
        };

        // switch 의 반환 = yield
        // yield = break value; 와 값다.
        boolean result = switch (grade) {
            case 1 -> {
                System.out.println("VVIP");
                yield true;
            }
            case 2 -> {
                System.out.println("VIP");
                yield true;
            }
            case 3, 4, 5 -> {
                System.out.println("General");
                yield true;
            }
            default -> { yield false; }
        };

    }// main()
}// end class
