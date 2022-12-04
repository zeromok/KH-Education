package Java.src.main.java;

import java.util.Calendar;

public class Sample03_1 {

    public enum Week {

        MONDAY,     // 하나, 하나 다 객체 -> 열거상수
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY

    }// end class

    enum Months {
        JANUARY
    }
    // 지금은 가독성을 위해 enum을 메인 메소드 위로 올렸지만 원래는 변수명과 같은이름의 클래스를 설정해 저장

    public static void main(String[] args) {

        Week day = Week.MONDAY;
        // day변수의 값은 객체이다.
        System.out.println("day : " + day);
        System.out.println("day.hashCode : " + day.hashCode());	// 객체의 고유번호

        day = Week.FRIDAY;
        System.out.println("day : " + day);

        switch (day) {
            case MONDAY: System.out.println("ㅜ.ㅜ");
                break;
            case FRIDAY: System.out.println("^.^");
                break;
            default:
                System.out.println("ㅡ.ㅡ");
        }

        System.out.println(day == Week.FRIDAY);


        Months season = Months.JANUARY;
        System.out.println("season : " + season);

        // ==============================================================================================

        Week today = null;
        // null : 현재 객체의 주소를 가지고 있지 않다.
        // 지역변수 = 반드시 초기화 해줘야한다.

        Calendar cal = Calendar.getInstance();
        System.out.println("cal : " + cal);

        int week = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("week : " + week);

        // switch문 으로 비교가능한 타입은 아래와 같습니다.
        // 1. 정수	2. 문자	3. 문자열 4. 열거타입
        switch(week) {
            case 1:
                today = Week.SUNDAY; break;
            case 2:
                today = Week.MONDAY; break;
            case 3:
                today = Week.TUESDAY; break;
            case 4:
                today = Week.WEDNESDAY; break;
            case 5:
                today = Week.THURSDAY; break;
            case 6:
                today = Week.FRIDAY; break;
            case 7:
                today = Week.SATURDAY; break;
        }

        System.out.println("오늘 요일: "+ today);

        if(today == Week.SUNDAY) {
            System.out.println("일요일에는 축구를 합니다.");
        } else {
            System.out.println("열심히 자바 공부합니다.");
        }


    }// main()
}// end class
