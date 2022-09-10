package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class LoginDTO {

    private String userid;
    private String userpw;

    private Boolean rememberme;
    /*
        로그인 화면에서, "자동로그인" 체크여부에 따라
        on/off를 표현해줌, default는 false가 되어야 한다.
    */

}
