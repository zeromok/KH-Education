package org.zerock.myapp.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.common.ShareScopeKeys;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.service.UserService;


@Log4j2
//@NoArgsConstructor
@AllArgsConstructor

@Controller
@RequestMapping("/user/")
public class LoginController {
    /*
        어떻게 요청이 들어오면 로그인 처리를 할까?
        컨트롤러에서는 Test하지 말자 (ex : check code)
    */

    private UserService service;

    @PostMapping("/loginPost")
    public String loginpost(LoginDTO dto, Model model, RedirectAttributes rttrs) throws Exception {
        log.trace("======= loginPost() =======");

        UserVO vo = this.service.findUser(dto);
        /*
            매개변수로 들어온 dto를 service객체의 메소드에 넣어 UserVO타입인 vo에 넣었다.
        */

        if(vo != null) { // vo != null : 즉, 로그인에 성공했다면

            model.addAttribute(ShareScopeKeys.LOGIN_KEY,vo);
            /*
                addAttribute : 맵 객체로 넣어줘야 한다.
                model에 키, 값 형태로 객체를 넣어주고 자동으로 Command Object(dto)도 담아 뷰(JSP)로 전달
            */

            return "/user/loginPost";
            // 로그인에 성공했다면 로그인 후 페이지로 이동


        } else { // 로그인에 실패했다면, 실패원인과 함께 로그인 화면으로 이동

            rttrs.addFlashAttribute(ShareScopeKeys.LOGIN_RESULT,"로그인에 실패했습니다.");

            return"redirect:/user/login";
        }

    }// loginPost()
    /*
        login.jsp 에서 사용자가 아이디와 비밀번호 입력후 전송 어디로? -> list.jsp
        -> LoginDTO 가 입력된 데이터 수집(Command Object) -> Model 에 담겨 (자동으로)View 까지 전달
           어떻게? 키,값 형태로 Model 에 담긴다. ("loginDTO", dto) 첫문자 소문자.
        -> if 에 맞게 사용자를 찾아내면 vo 도 함께 들어간다.
    */


//    @GetMapping("/login")
//    public void login() {
//        log.trace("===== login() =====");
//        // 로그인 jsp 를 띄우는 단순한 핸들러 메소드
//    }
    /*
        스프링은 단순화면을 띄워주는 Get 방식의 핸들러 메소드에 대해서 태그를 제공
        servlet-context.xml -> <view-controller path="/user/login" view-name="/user/login" status-code="200" />
        BUT 리쿼스트매핑 테이블에는 나오지않는 단점이 있다.
    */


}//end class
