package org.zerock.myapp.interceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Log4j2
@NoArgsConstructor
public class SampleInterceptor implements HandlerInterceptor {
    /*
        Interceptor클래스의 기본 골격
        이 클래스에서는 @Component 를 사용해 빈에 자동등록을 시키지 않고
        servlet-context.xml 을 이용해 수동으로 등록해주고, 어떤 클래스를 가로챌지 등록
        + HandlerInterceptor클래스의 메소드 오버라이드
    */


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        log.trace("======= Interceptor > preHandle() =======");

        log.info("handler : {}", handler);                              // handler 가 뭘까?
        // org.zerock.myapp.controller.SampleController#doA()

        log.info("\t - type : {}", handler.getClass().getName());       // 타입도 찍어보자
        // org.springframework.web.method.HandlerMethod

        HandlerMethod requestHandler = (HandlerMethod) handler;
        log.info("requestHandler : {}", requestHandler);
        /*
            매개변수 handler를 이용해 HandlerMethod를 얻어보자
            org.zerock.myapp.controller.SampleController#doA()
        */

        Object Controller = requestHandler.getBean();
        log.info("\t - Controller : {}", Controller);
        /*
            위에서 얻은 HandlerMethod를 이용해 Bean을 얻어보자
            org.zerock.myapp.controller.SampleController@118fddf
        */

        Method Method = requestHandler.getMethod();
        log.info("\t - Method : {}", Method);
        /*
            위에서 얻은 HandlerMethod를 이용해 Method를 얻어보자
            public void org.zerock.myapp.controller.SampleController.doA()
        */

        //================================================================================
        // 예제 : 요청을 보낸 클라이언트의 IP주소를 체크하여, 위험한 소스에서 온 요청이면
        //        그 즉시 요청처리를 끝내버림
        //================================================================================
        String clientAddr = req.getRemoteAddr();
        log.info("clientAddr : {}", clientAddr);

        return ("192.168.0.2".equals(clientAddr) ? false : true);
        /*
            If return false, incoming request 를 뒤로 넘기지 않음 (체인이 있든 없든)
            If return true, incoming request 를 뒤로 넘김 (체인이 있든 없든)
        */




        //return true;
    }// preHandle()
    /*
        Request가 Controller의 Handler method로 위임되기 직전에 콜백
    */


    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
        log.trace("======= Interceptor > postHandle() =======");

        log.info("modelAndView : {}", modelAndView);        // modelAndView를 알아보자
        //  modelAndView : ModelAndView [view="sample/doA"; model={}]

        ModelMap model = modelAndView.getModelMap();
        String viewName = modelAndView.getViewName();
        HttpStatus status = modelAndView.getStatus();

        log.info("\t - model : {}", model);
        log.info("\t - viewName : {}", viewName);
        log.info("\t - status : {}", status);

        //---

        /*
            위에서 알아본 modelAndView에 model이나 view를
            필요하면 임의대로 바꾸어줄 수도, 추가할 수도 있다.
            왜 이런 기능이? 처리에 따라 추가될 model 이나 다른 처리가 필요하기 때문에
        */
        modelAndView.setViewName("redirect:/login");        // 뷰의 이름 수정
        model.put("serverTime", "Hi");                      // model 데이터 추가(Key, Value)
        modelAndView.setStatus(HttpStatus.OK);              // 응답 상태코드 수정

        log.info("\t + add model : {}", model);
        log.info("update > modelAndView : {}", modelAndView);
        // update > modelAndView : ModelAndView [view="redirect:/login"; model={serverTime=Hi}]

    }// postHandle()
    /*
        Controller의 Handler method가 수행완료된 직후에 콜백
        메소드에서 오류가 난다면 콜백되지 않는다.
    */


    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e) throws Exception {
        log.trace("======= Interceptor > afterCompletion() =======");

        log.trace(" Exception : {}", e); // 예외가 발생한다면 찍어주자.

    }// afterCompletion()
    /*
        Spring MVC의 View가 호출완료된 직후에 콜백
        단, Controller의 Handler method에서 예외가 발생하든 안하든 무조건 호출된다. -> 개발자가 명시적으로 예외처리(예외처리패키지)를 하면 충돌된다.
    */


}//end class
