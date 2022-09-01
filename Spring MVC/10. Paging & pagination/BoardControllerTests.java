package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.BoardVO;

import java.util.concurrent.TimeUnit;


@ExtendWith(SpringExtension.class)
// Spring Beans Container & DI 수행시키는 어노테이션
@ContextConfiguration(locations = {
        /*
        필요한 스프링 설정파일을 등록해준다.
        이때 file: 이 사용되는데, 이 file: == 프로젝트폴더
        공백없이 설정한다.
        */
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

// Spring MVC Framework 구동시키는 어노테이션 ***
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Log4j2
@NoArgsConstructor
public class BoardControllerTests {

    /*
    WAS 구동없이 테스트 하려는 대상이 BoardController 이니,
    이 컨트롤러를 주입받아, 메소드 호출로 테스트 할 생각은 틀렸다.
    */
//    @Setter(onMethod_= {@Autowired} )
//    private BoardController controller;

    // Spring Beans Container (type : WebApplicationContext) 자체를 주입
    @Setter(onMethod_= {@Autowired} )
    private WebApplicationContext ctx;

    @BeforeAll
    void beforeAll() {
        log.trace("beforeAll() invoked.");

        assert this.ctx != null;
        log.info("\t - ctx : {}", this.ctx);
    }

    @Test
    @Order(1)
    @DisplayName("1. testList()")
    @Timeout(value = 15, unit = TimeUnit.SECONDS)
    void testList() throws Exception {
        log.trace("testList() invoked.");

         /*
         1. WAS 구동없이, 컨트롤러의 핸들러메소드를 테스트 하려면, spring-test 의존성에 포함된MocMVC 객체가 필요하다.
            이 객체를 생성하기 위해서, 바로 위에서 주입받은 Spring Beans Container 가 필요하다.
         2. 아래의 MockMvc 의 메소드들은, fluent-api, method-chaining 기법으로 사용하게 됨
         */

//        // 1. MockMvcBuilder 얻기
//        MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
//        log.debug("\t - mockMvcBuilder : {}", mockMvcBuilder);
//
//        // 2. MockMvc 객체 생성하기
//        MockMvc mockMvc = mockMvcBuilder.build();
//        log.debug("\t - mockMvc : {}", mockMvc);
//
//        // 3. RequestBuilder 객체 생성 (컨트롤러가 받는 전송방식과 매핑 URI 를 만들어주는...)
//
//        // 3-1. 전송파라미터가 없는 경우에는 아래와 같이
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/list");
//        log.debug("\t - requestBuilder : {}", requestBuilder);
//
//
//        // 3-2. 전송파라미터까지 보내야하는 경우에는, 아래와 같이 자식메소드(MockHttpServletRequestBuilder) 의 메소드 이용
//        /*
//        MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/list");
//        // reqBuilder.param(전송파라미터이름, 전송값들(가변인자ㄴ))
//        reqBuilder.param("name", "mokk");
//        reqBuilder.param("age", "30");
//        reqBuilder.param("hobby", "book", "movie");
//        */
//
//        // 4. 실제 Controller 로 요청 보내기 -> 요청을 보낸 결과로, 5. Model & View 이름을 받을 수 있다.
//        ResultActions resultActions = mockMvc.perform(requestBuilder);
//        log.debug("\t - resultActions : {}", resultActions);
//
//        // 5. Model & View 이름을 받음
//        MvcResult mvcResult = resultActions.andReturn();
//        log.debug("\t - mvcResult : {}", mvcResult);
//
//        // 6. 5. 에서 얻어낸 MvcResult 의 getter 메소드를 이용해 Test Target 인 BoardController handler 메소드의 수행결과를 얻어냄
//        ModelAndView modelAndView = mvcResult.getModelAndView();
//        log.debug("\t - modelAndView : {}", modelAndView);
//
//        // 7. ModelAndView 객체로부터, 아래의 2가지 정보를 획득하여 출력
//        // 1. 반환된 뷰의 이름 2. 반환된 비지니스데이터(즉, Model 객체)
//        assert modelAndView != null;
//        String viewName = modelAndView.getViewName();
//        ModelMap modelMap = modelAndView.getModelMap();
//
//        log.info("\t - viewName : {}", viewName);
//        log.info("\t - modelMap : {}", modelMap);


        //========================================================================================================


        MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
        MockMvc mockMvc = mockMvcBuilder.build();

        MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/list");
        reqBuilder.param("currPage", "1");
        // 전송파라미터는 모두 문자열
        reqBuilder.param("amount", "20");

        //MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/list");
        // reqBuilder.param(전송파라미터이름, 전송값들(가변인자ㄴ))
//        reqBuilder.param("name", "mokk");
//        reqBuilder.param("age", "30");
//        reqBuilder.param("hobby", "book", "movie");

        // Fluent-API 기반의 메소드체이닝을 이용하여 간략하게 요청에 대한 응답결과 획득
       ModelAndView modelAndView =
               mockMvc.
                    perform(reqBuilder).
                    andReturn().
                    getModelAndView();

       log.info("\t - modelAndView : {}", modelAndView);


    } // testList()

    @Test
    @Order(2)
    @DisplayName("2. testGet()")
    @Timeout(value = 15, unit = TimeUnit.SECONDS)
    void testGet() throws Exception {
        log.trace("testGet() invoked.");

        MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
        MockMvc mockMvc = mockMvcBuilder.build();

        MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/get");
        reqBuilder.param("bno", "84");
        // 전송파라미터는 모두 문자열
        reqBuilder.param("currPage", "3");

        //MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/board/list");
        // reqBuilder.param(전송파라미터이름, 전송값들(가변인자ㄴ))
//        reqBuilder.param("name", "mokk");
//        reqBuilder.param("age", "30");
//        reqBuilder.param("hobby", "book", "movie");

        // Fluent-API 기반의 메소드체이닝을 이용하여 간략하게 요청에 대한 응답결과 획득
        ModelAndView modelAndView =
                mockMvc.
                        perform(reqBuilder).
                        andReturn().
                        getModelAndView();

        log.info("\t - modelAndView : {}", modelAndView);

    }


} // end class
