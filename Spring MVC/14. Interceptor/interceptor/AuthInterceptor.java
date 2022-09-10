package org.zerock.myapp.interceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.zerock.myapp.common.ShareScopeKeys;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@NoArgsConstructor

@Component
public class AuthInterceptor implements HandlerInterceptor {
    // Authorization(인가) 를 체크하는 역할로, 회원만이 사용가능한 요청에 대해, 가장 기본적인 권한으로 "인증여부" 체크

    private UserService service;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        log.trace("======= preHandle() =======");

//        ============================================================
//        1. 현재 요청을 보낸 웹브라우저에 대응되는 세션을 획득
//        ============================================================
        HttpSession session = req.getSession(); // 현재 브라우저에 대한 세션이 있으면 그 세션을 돌려주고, 없으면 새로 만들어 준다.
        log.info("Session Id : {}", session.getId());


//        ============================================================
//        2. Session Scope에 인증정보(즉, UserVO 객체)가 있으면 -> 요청을 그대로 컨트롤러로 전달
//                                                       없으면 -> 로그인 창으로 이동
//        ============================================================
        UserVO vo = (UserVO) session.getAttribute(ShareScopeKeys.USER_KEY);

        if(vo != null) {                        // 인증된 사용자
            log.info("Authentication Found");

            return true;

        }else {                                 // 인증되지 않은 사용자
            log.info("NO Authentication Found");

//        ============================================================
//        **자동 로그인 처리** 를 위한 필요 처리 2가지

//          1. 자동로그인 쿠기가 들어온 웹브라우저라면, 이 쿠키값으로 tbl_user테이블을 조회하고
//             그 결과 특정 user 정보가 획득되고, 이 정보로 인증객체인 UserVO 객체를 생성해서,
//             Session Scope에 바인딩 시킴***

//          2. 1.에 의해서, Session Scope에 UserVO가 있다면, 무사통과 시켜줘야함
//        ============================================================

//        ============================================================
//        1. 현재 요청을 보낸 웹브라우저의 요청메세지의 헤더(Cookie)에,
//           자동 로그인 쿠키를 획득
//        ============================================================
            Cookie rememberMeCookie = WebUtils.getCookie(req, ShareScopeKeys.REMEMBERME_KEY);
            log.info("\t - rememberMeCookie : {}", rememberMeCookie);

            if(rememberMeCookie != null) {
                // 자동로그인 처리 대상 웹브라우저가 된다. -> 인증정보(UserVO) 객체 복구

    //        ============================================================
    //        2. 1.에서 얻어낸 자동로그인 쿠키값으로 인증객체인 UserVO객체를 복구하고,
    //           이를 Session Scpoe에 바인딩 -> 인증복구
    //        ============================================================
                String cookieName = rememberMeCookie.getName();
                String cookieValue = rememberMeCookie.getValue();
                log.info("\t - cookieName : {}, cookieValue : {}", cookieName, cookieValue);

    //        ============================================================
    //        3. 웹브라우저가 보내온 자동로그인 쿠키값으로 인증정보 객체 UserVO를 획득
    //        ============================================================
                UserVO repairedUserVO = this.service.findUserByRememberMeCookie(cookieValue);
                log.info("\t - repairedUserVO : {}", repairedUserVO);

    //        ============================================================
    //        4. 현재의 웹브라우저에 할당된 Session Scope에 인증정보객체(UserVO)를 바인딩 = 인증복구
    //        ============================================================
                session.setAttribute(ShareScopeKeys.USER_KEY, repairedUserVO);

                if (repairedUserVO != null) {
                    // 컨트롤러로 요청을 위임하지 않는다. -> 무사통과

                    return true;

                }// if
            }// if

            res.sendRedirect("/user/login");
            // 주의 : 자동로그인이 켜져있는 웹브라우저라면, 로그인 창으로 리다이렉트 하면 안됨

        }// else

        return false;

    }// preHandle()
    /*
        preHandle() : Request가 Controller의 Handler Method로 위임되기 직전에 콜백
    */


    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
        log.trace("======= postHandle() =======");
    }
    /*
        postHandle() : Controller의 Handler Method가 수행완료된 직후에 콜백
    */


    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
        log.trace("======= afterCompletion() =======");
    }
    /*
        afterCompletion() : Spring MVC 의 View 가 호출완료된 직후에 콜백
                            단, Controller 의 handler method 에서 예외가 발생하든 안하는 무조건 호출됨
                            -> 예외처리(예외처리패키지)를 하면 충돌된다.
    */


}// end class
