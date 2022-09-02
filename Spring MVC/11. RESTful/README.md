# RESTful API

REpresentational State Transfer 의 약자

시대와 기술이 발전하면서 등장한 새로운 서비스 개발방식이다. 

> 더이상 정보를 전달하는 대상이, PC 웹브라우저보다, 스마트폰의 앱/모바일 웹브라우저가 대세가 되어가면서 (이를 Mobile First 라고 부름..)
더이상 Back-end 서버의 역할이, 웹브라우저를 위한 웹서비스만을 위한게 아니라, 순수한 데이터(XML, JSON, 문자열)를 전달하는 역할로 변하고 있다.

즉, 사용하는 HTTP 프로토콜 안에 아래와 같은 데이터가 존재 가능 하다는 말이다.
- XML
- JSON
- String

위와같이 클라이언트가 요청을 벡엔드에 보내려면,
(1) HTTP method (전송방식)가 확장됨 - GET (R) / POST (U) / PUT (C) / DELETE (D)
(2) HTTP request URI - 위 (1)의 대상이 되는 자원을 표시

예: http:// ~~~~~~/board/new + PUT (C) => 게시판에 새로운 글을 등록해달라는 요청 --> 순수한 데이터를 응답으로 전송

    http:// ~~~~~~/board/123 + GET (R) => 123번 게시글을 읽어서 보내달라는 요청 --> 순수한 데이터를 응답으로 전송
    
    http:// ~~~~~~/board/77  + POST(U) => 77번 게시글을 업데이트 해달라는 요청 --> 순수한 데이터를 응답으로 전송
    
    http:// ~~~~~~/board/45  + DELETE (D) => 45번 게시글을 삭제해달라는 요청 --> 순수한 데이터를 응답으로 전송

RESTful 서비스 개발방식은 결국, HTTP method + HTTP re
quest URI 이 두가지의 조합으로 어떤 자원에 대해서, 어떤 행위를 요청하는 것인지 표현(Representational)할 수 있어야 한다.

RESTful 서비스의 대표적인 예 =====> OpenAPI (개방형API) ==> 공공데이터포털

