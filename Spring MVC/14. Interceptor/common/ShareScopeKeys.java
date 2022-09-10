package org.zerock.myapp.common;


public class ShareScopeKeys {
    /*
        모든패키지에서 공통으로 사용하는 클래스나, 기타 열거타입 등을 저장하는 common 패키지 생성 ->
        모든 모델상자나 임시상자에 저장할 키 이름을 상수로 선언해 다른 클래스에서 활용하기위한 클래스 생성
    */

    public static final String LOGIN_KEY = "__LOGIN__";

    public static final String LOGIN_RESULT = "__RESULT__";

    public static final String USER_KEY = "__USER__";
    /*
        Session Scope 에 UserVO 인증정보객체를 올려 놓을때 이 키를 사용하겠다.
        인증정보를 올려놓을 때 사용할 키
    */

    public static final String REMEMBERME_KEY = "__REMEMBERME__";
    /*
        FOR 자동로그인
    */


}// end class
