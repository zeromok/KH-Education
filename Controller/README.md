# Contorller 기초에 대해 공부하고 정리해보았다.


Model 1 Architecture ==> 1개의 request를, 1개의 servlet or jsp가 다처리해서, 응답까지 전송하는 설계방식


public class XXXServlet extends HttpServlet {
	
	protected .. service(req, res) {
		// 1~4까지의 단계의 흐름을 제어 ==> Controller
		// 1. 전송 파라미터 수집
		// 2. 요청식별
		// 3. 핵심비지로직 처리 => 데이터발생 => Model
		// 4. 발생데이터 이용해서 화면제작 => View
	}
}


==> 이래서는 도저히 개발의 품질, 효율, 유지보수 어렵다...! 실패할 확률 높아짐 ==> MVC패턴(=Model2 Aechitecture, ==> Best Practice : 역할을 나누자)

==> 1개의 요청이 들어왔을 때,
	1. Controller (요청 ~ 응답이 나가기까지의 전체 처리흐름을 제어하는 역할)
	2. Model (핵심 비지니스 로직을 수행하고, 그 수행결과 데이터를 발생하는 역할)
	3. View (Model을 이용해서, 출력화면을 만드는 역할)

==> 위와같이 MVC패턴에 따라, 역할을 나누면 뭐하냐 ==> MVC패턴을 강제 ==> HOW? ==> 프레임워크의 도입 이유가 된다. ==> Spring MVC framework 사용


Web 3계층
 (1) Presentation(표현) - 화면을 만들어 내는 계층
     - Spring MVC framework
     - User-defined Controller (@Controller), JSP

 (2) Business (== Service) - 핵심 비지니스로직 수행 및 Model 생성
      - @Service 서비스 객체가 해당
      - 핵심 비지니스로직 수행 및 Model 생성

 (3) Persistence(== DAO) - Database 조작 
      - @Repository DAO객체가 해당
      - 대신, MyBatis's Mapper Interface 로 단방에 구현("자동실행규칙"필요)
      
      
URI는 맞고 전송방식이 다르면 405오류가 날아옴
URI가 다르고 전송방식은 맞으면 root-context.xml 에 설정해둔 NoHandlerException 오류가 날아온다.

요청이 들어오면 DispatcherServlet 에서 먼저 받아
            HandlerMapping 에게 넘겨 어떤방식으로 넘어오고 어떤 컨트롤러로 넘겨줘야하는지 정보를 DispatcherServlet 로 받은 후
            HamdlerAdapter 에게 그 정보를 넘겨 Controller에게 전달
            Controller 는 데이터상자인 Model 과 View 의 이름을 반환(String 형태로...) 정보를 DispatcherServlet 로 받은 후
            ViewResolver 에게 정보를 넘겨 최종화면을 만들어낼 jsp 확인  정보를 DispatcherServlet 로 받은 후
            View 에서 jsp호출 == 최종응답화면
            
      
      
## SampleController.java

Cotroller를 만들어 @RequestMapping 에 대해 이해하고 예제를 통해 활용법을 알아보았다.

            



