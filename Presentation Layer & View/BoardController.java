package org.zerock.myapp.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.service.BoardService;

import java.text.DateFormat;
import java.util.List;

@Log4j2
@AllArgsConstructor
// 아래의 이유로 바꿔준다.

@Controller
@RequestMapping("/board/")
public class BoardController{

    // Spring v4.3  이후부턴, 주입받을 필드가 1개이고, 이 필드 1개를 매개변로수 가지는
    // 생성자를 만들면, 주입시그널을 보내지 않았도, 자동으로 주입을 해줌
    private BoardService service;

//    =========================================================

    // 1. 목록을 얻어야 한다.(보여줘야 한다.)
    @GetMapping("/list")
    public void list(Model model) throws ControllerException{
        log.trace("list() invoked.");

        try {
            List<BoardVO> list = this.service.getList();

            model.addAttribute("list", list);
            // JSP 로 전달할 데이터를 model 에 넣어 전달

        } catch (Exception e) {
            throw new ControllerException(e);
        }// try-catch

    }// list()

    @PostMapping("/register")
    public String  register(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
        log.trace("register() invoked.");

        try {

            boolean isRegister = this.service.register(dto);
            log.debug("\t - isRegister : {}", isRegister);

            // 1. Session Scope 에 아래의 이름과 값으로 바인딩해서 전달(공유)
//            rttrs.addFlashAttribute("result", (isRegister) ? "SUCCESS (" + dto.getBno() + ")" : "FAILURE");

            // 2. Get 방식의 전송파라미터 (즉, Query String 형태로 전달 예) ?result="FAILURE")
            rttrs.addAttribute("result", (isRegister) ? "SUCCESS" : "FAILURE");

            // 두 방법중에 어느게 더 효울적이고 명확할까? 2번

            return "redirect:/board/list";     // Re-direct to the board list.

        } catch (Exception e) {
            throw new ControllerException(e);
        }// try-catch

    }// register()

    /*
    위 핸들러 메소드의 리턴값은 "redirect:/board/list" 이므로 리다이랙트 되기 전 register 화면을 띄워줘야한다.(등록화면에서 사용자 입력 후 리다이랙트)
    아래의 2가지 방식으로 해결한다.
    */
    // 1.
//    @GetMapping("/register")
//    public void register() {
//        log.trace("register() invoked.");
//
//    }// register

    // 2. (이 방법으로 실행해보았다.)
    // servlet-context.xml 에서 처리
    // <view-controller path="/board/new" view-name="/board/new" status-code="200" />


    @PostMapping("/modify")
    public String  modify(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
        log.trace("modify() invoked.");

        try {

            boolean isModify = this.service.modify(dto);
            log.debug("\t - isModify : {}", isModify);

            rttrs.addAttribute("result", (isModify) ? "SUCCESS" : "FAILURE");

            return "redirect:/board/list";

        } catch (Exception e) {
            throw new ControllerException(e);
        }

    }// modify()


//    @GetMapping("/modify")
//    public void modify() {
//        log.trace("modify() invoked.");
//
//    }// register

    // 3. 메소드 수행결과 가 같을 때 사용
    // 아래 get 핸들러에서 URI 를 병합했으므로 필요없다.


    @PostMapping("/remove")
    public String  remove(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
        log.trace("remove() invoked.");

        try {

            boolean isRemove = this.service.remove(dto);
            log.debug("\t - isremove : {}", isRemove);

            rttrs.addAttribute("result", (isRemove)? "SUCCESS("+dto.getBno()+")" : "FAILURE");

            return "redirect:/board/list";

        } catch (Exception e) {
            throw new ControllerException(e);
        }

    }// remove()


    @GetMapping( {"/get" , "/modify"} )
    public void  get(BoardDTO dto, Model model) throws ControllerException {
        log.trace("get() invoked.");

        try {

            BoardVO vo = this.service.get(dto);
            log.debug("\t - vo : {}", vo);

            model.addAttribute("board", vo);

        } catch (Exception e) {
            throw new ControllerException(e);
        }

    }// remove()

}// end class
