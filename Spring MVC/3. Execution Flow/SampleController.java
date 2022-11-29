package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.ParamsDTO;
import org.zerock.myapp.domain.SampleDTO;

import java.util.Date;
import java.util.Set;

@Log4j2
@NoArgsConstructor
@Controller
@RequestMapping("/base/")
public class SampleController00 {


    // 6. .jsp 호출 메커니즘을 알아보자
    /*
        컨트롤러의 핸들러는 아래의 역할 및 값을 반환
        1. 역할 : 요청을 위임받아 처리
        2. 뷰의 이름을 반환
        3. 역할에 따라, 요청을 위임처리한 결과 => Model(비즈니스데이터 / Model = 상자) 생성 및 View 로 전달
    */
    @GetMapping("/ex01")
    // == @RequestMapping(path = "/basicOnlyGet", method = RequestMethod.GET)
    public String ex01(ParamsDTO dto) {
        // DispatcherServlet 에게, 2개의 전송파라미터를 이 매개변수에 넣어주세요! 라고 부탁
        /*
            DispatcherServlet 의 특별한 역할
                1. 모든 전송 파라미터를 수집해 놓는다. 전달가능
                2. 타입까지 맞춰서 전달가능
                3. 전송파라미터의 이름을 맞추지 않으면 500번대 에러
                4. DTO 클래스의 필드에 전송파라미터 넣어줌 (필드의 이름 == 전송파라미터의 이름)
        */
        log.debug("ex01({}) invoked.", dto);

        return "ex01";
         /*
            이게 바로 MVC 패턴에서 View 의 이름
            BY View Resolver Configuration
            /WEB_INF/views/ + ex01 + .jsp == /WEB_INF/views/ex01.jsp
         */
    }


    // 7. with some primitive types parameters
    /*
    전송파라미터의 이름을 바꾸어 받고 싶다면?(내 맘대로 지은 변수)
     [ @RequestParam("파라미터명") 매개변수 ] 어노테이션이 도와준다
     그냥 집어넣어주는게 아니라 될 수 있으면 형변환까지 해서 넣어준다. (String -> int 이런거 말고...)
    */
    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String recvName,
            @RequestParam("age") Integer currentAge) {
        log.debug("ex02({}, {}) invoked.", recvName, currentAge);

        return "ex02";

    }// ex02


    // 8.with multi-values request parameters
    /*
        체크박스 처럼 값이 여러개가 날아오면 어떻게 처리할까? ex) String[] hobby = req.getParameterValues("hobby");
        아래의 예제를 통해 알아보자
        가장 간단하고 확실한 방법은 배열을 쓰자
    */
    @GetMapping("/ex03")
//    public String ex03List(List<String> hobby)  {                                // XX
//    public String ex03List(@RequestParam("hobby") List<String> hobby)  {         // OO
//    public String ex03List(ArrayList<String> hobby)  {                           // OX : 받긴했지만, 값이 비어있다.
//    public String ex03List(@RequestParam("hobby") ArrayList<String> hobby)  {    // OO
//    public String ex03List(String[] hobby)  {                                    // OO : 배열로는 정상적으로 다중값 전송파라미터 수신 완료
    public String ex03List(@RequestParam("hobby") Set<String> hobby)  {            // OO
//        log.debug("ex03({}) invoked.", Arrays.toString(hobby));

        log.debug("ex03({}) invoked.", hobby);
        log.info("\t - type : {}", hobby.getClass().getName());     // 타입을 찍어보자 => LinkedHashSet

        return "ex03";

    }// ex03


    // 9. @DateTimeFormat
    // 전송파라미터의 값이 날짜포맷형식(String)으로 전달될 때,
    // 컨트롤러의 핸들러 메소드의 매개변수로 아예 처음부터, Data 객체로 얻을 수 있다.
    /*
        입자일자를 전송한다고 하자 매개변수의 타입으로 Date 로 받을 수 있을까? XX
        @DateTimeFormat 을 붙여보자
        - 날짜형식의 String 타입을 Date 타입으로 변환시켜준다. yyyy-MM-dd 형태로 들어왔다는걸 알려주면...속성인 (pattern="")에게
        - 여러 형식이 있으니 상황에 맞게 찾아 쓰면 될 것 같다.
    */
    @GetMapping("/ex04")
    public String ex04( @DateTimeFormat(pattern = "yyyy-MM-dd") Date hireDate) {
        log.debug("ex04({}) invoked.", hireDate);

        return "ex04";

    }// ex04


    // 10. Predefined Model parameter
    // to transfer request parameter into the View
    /*
        Model 을 이용한 예제 DTO 객체 만들어 실습 ( SampleDTO.java )
        Model 객체는 직접 만들지 않고 요청한다 to DispatcherServlet (매개변수 자리에서...)
        로직을 수행한 결과 데이터가 안에 들어간다. 실제타입은 Map 객체 키,값 형태로 들어간다.
        RequestScope 에 바인딩되는 결과
        model 객체 안에 객체를 넣는 순간 그 객체는 공유속성이 되며 RequestScope 에 바인딩된다.
        .jsp 파일에서 끄집어내보자
    */
    @GetMapping("/ex05")
    public String ex05(String name, Integer age, Integer page, Model model) {
        // 각 전송파라미터의 값 획득 from DispatcherServlet
        // model : 핵심 비지니스 로직의 수행 결과데이터를 저장 및 View 에 전달하는 상자***
        log.debug("ex05({}, {}, {}, {}) invoked.", name, age, page, model);

        log.info("\t - model type : {}", model.getClass().getName()); // Map

        // Model 상자에 저장할 객체 생성
        SampleDTO dto = new SampleDTO();
        dto.setName(name);
        dto.setAge(age);

        // 비지니스 데이터를 저장하는 상자 역할을 하는 Model 객체에 넣어보자
        model.addAttribute("SampleDTO", dto);
        model.addAttribute("page", page);

        return "commandObject";
        /*
            Spring MVC 의 Controller 의 Handler Method 에서, 전송파라미터들을 수집하는 용도로 지정한 객체(DTO)를
                ==> Spring 에서는 Command Object 라고 부름
                ==> Command Object 의 특징 : MVC 패턴에서 마지막에 호출될 View(즉, .jsp)까지 자동으로 전달됨*** Model 데이터와 함께...
        */
    }


    // 11. 10번예제 응용
    /*
        jsp 파일에서 출력될 때 10번과는 EL 표현식이 좀 다른것 같다.
        10번 : ${SampleDTO}
        11번 : ${sampleDTO} => 첫문자 소문자
    */
    @GetMapping("/ex06")
    public String ex05( SampleDTO dto, Integer page, Model model ) {
        log.debug("ex05({}, {}, {}) invoked.", dto, page, model);

        log.info("\t - model type : {}", model.getClass().getName());

        // Model 상자에 저장할 객체를 매개변수에서 바로 받아보자
//        SampleDTO dto = new SampleDTO();
//        dto.setName(name);
//        dto.setAge(age);

        model.addAttribute("SampleDTO", dto);
        model.addAttribute("page", page);

        return "commandObject";
        // 자동으로 View 까지 전달됨

    }


    // 12. @ModelAttribute(Key) to transfer data into the View
    /*
    page 는 모델상자에 넣지 않았지만 어떻게 공유될 수 있을까?
    [ @ModelAttribute("공유속성명") 매개변수 ]
    */
    @PostMapping("/ex07")
//    public String ex07(SampleDTO dto, Integer page) {
    public String ex07(SampleDTO dto, @ModelAttribute("page") Integer page) {
        log.debug("ex07({},{}) invoked.", dto, page);


        return "commandObject";

    }


    // 13. Predefined RedirectAttributes to redirect a req into the target url
    /*
    Redirection *** 잘못된 요청이 들어왔을때 올바른 방향으로 다시 보내주는...
    */
    @GetMapping("/ex08")
    public String ex08(String name, Integer age, RedirectAttributes rttrs) {
        // rtts : Model 상자와 비슷한 역할 - 임시상자역할 : 리다이렉션의 Target URI 에 전달할 전송파라미터를 만들어내는 역할
        log.debug("ex08({}, {}, {}) invoked.",name, age, rttrs);

        log.info(String.format("\t - name : %s, age : %d", name, age));

        // 1. 1회성 데이터 전달 => Request Scope 에 공유속성으로 올려서 전달(공유)
//        rttrs.addFlashAttribute("name", name);
//        rttrs.addFlashAttribute("age", age);


        // 2. 전송파라미터로 전달 => GET 방식의 Query String 형태로 전달
        rttrs.addAttribute("name", name);
        rttrs.addAttribute("age", age);


//        return "redirect:http://localhost:7007";
        return "redirect:/base/ex02";
        // redirect: 특수문자열 뒤에는, 재요청을 보낼 Target URI 지정
        // 이 반환된 문자열은 View 의 이름이 아니다. 바로, 307 Redirect 응답문서가 즉시 전송
    }


}//end class
