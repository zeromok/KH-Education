package org.zerock.myapp.exception;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@Log4j2
@NoArgsConstructor

@ControllerAdvice
// 앱 내에서 발생할 수 있는 예외를 처리하겠다.
public class CommonsExceptionHandler {

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)	// HTTP status code = 405
    // 개발자가 원하는? 상태코드를 날려 보내준다.
    @ExceptionHandler(NoHandlerFoundException.class)
    // 예외를 처리하는 핸들러메소드 적용
    public String NoHandlerFoundException(Exception e, Model model) {

        model.addAttribute("_EXCEPTION_", e);

        return "errorPage";

    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   // HTTP status code = 500
    @ExceptionHandler(Exception.class)
    // 모든예외의 처리 핸들러
    // 위 상세한 예외 핸들러와 충돌 시 누가 처리 할까? 위치에 따라...( 코드 진행방향 )? 이것도 아님 영향없음
    public String  Exception(Exception e, Model model) {

        model.addAttribute("_EXCEPTION_", e);

        return "errorPage";

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)	// HTTP status code = 400
    @ExceptionHandler( ControllerException.class )
    public String handleControllerException(Exception e, Model model) {
        log.trace("handleControllerException({}, {}) invoked.", e, model);

        model.addAttribute("_EXCEPTION_", e);

        return "errorPage";			// 뷰의 이름 반환
    } // handleControllerException

}
