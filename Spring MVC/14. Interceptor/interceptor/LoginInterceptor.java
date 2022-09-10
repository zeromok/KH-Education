package org.zerock.myapp.interceptor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.common.ShareScopeKeys;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Log4j2
//@NoArgsConstructor
@AllArgsConstructor

@Component
public class LoginInterceptor implements HandlerInterceptor {
    // 인증수행 Interceptor

    private UserService service;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        log.trace("======= LoginInterceptor > preHandle() =======");

//        ============================================================
//        1. Session Scope에 접근할 수 있는 HttpSession 객체 획득
//        ============================================================
        HttpSession session = req.getSession(); // 현재 브라우저에 대한 세션이 있으면 그 세션을 돌려주고, 없으면 새로 만들어 준다.
        log.info("Session Id : {}", session.getId());

//        ============================================================
//        2. Session Scope에서 UserVO 인증정보객체를 파괴
//        ============================================================
        session.removeAttribute(ShareScopeKeys.USER_KEY);
        log.info("UserVO 인증정보 파괴");
//        session.invalidate(); // 세션상자 마저 다 파괴 쓸 때 주의하자.

        return true;
    }
    /*
        preHandle() : Request가 Controller의 Handler Method로 위임되기 직전에 콜백
    */

    /*
        Incoming Request 가 Controller Handler Method 로 위임되기 직전에 가로채는 부분
        Session Scope 에 저장되어 있던 모든 정보 파괴 수행
        왜? 로그인처리 요청이오면 전에 Session Scope 에 저장되어 있던 정보(전 로그인 데이터들)는 파괴해야한다.
        (*주의*) 명시적으로 로그아웃 요청을 보내지 않는 한, 세션 자체를 파괴(갱신)해서는 안됨
    */


    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
        log.trace("======= LoginInterceptor > postHandle() =======");

//        ============================================================
//        1. Session Scope에 접근할 수 있는 HttpSession 객체 획득
//        ============================================================
        HttpSession session = req.getSession();
        log.info("Session Id : {}", session.getId());


//        ============================================================
//        2. 매개변수 modelAndView 를 조사해서, UserVO 가 들어 있는지 확인
//           있으면, UserVO 를 인증객체로 Session Scope 에 올려 놓자
//        ============================================================
        ModelMap modelMap = modelAndView.getModelMap();
        log.info("modelMap : {}", modelMap);

        UserVO vo = (UserVO) modelMap.get(ShareScopeKeys.LOGIN_KEY);

        if (vo != null) {

        }else {

        }

    }
    /*
        postHandle() : Controller의 Handler Method가 수행완료된 직후에 콜백
    */


    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
    }
    /*
        afterCompletion() : Spring MVC 의 View 가 호출완료된 직후에 콜백
                            단, Controller 의 handler method 에서 예외가 발생하든 안하는 무조건 호출됨
                            -> 예외처리(예외처리패키지)를 하면 충돌된다.
    */


}// end class
