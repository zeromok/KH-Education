id = prompt('아이디 입력');
/*
    prompt 함수 : 내장함수로, 사용자로부터 정보를 입력 받을 수 있는 팝업창을 띄움
    function prompt(message?: string | undefined, _default?: string | undefined): string | null
    함수의 인자값은 소위 prompt 메시지임(즉, 어떤 정보를 입력해달란 것인지 표현)
*/

if(id == 'admin') {

    password = prompt('비밀번호 입력');

    if(password === '123456') {
        /* 
            왜 3개짜리, 동등비교연산자를 사용해야 할까?
            -> 엄격하게 연산처리를 하기위해서, === 는 데이터타입까지 비교한다.
        */

        location.href = '로그인.html'
        // location.href="http://www.naver.com" 이 방식도 가능
        /* 
            location 객체 : 소위 Browser Object Model 중 하나의 내장객체로,
                            웹브라우저의 주소창을 객체로 만든 것임
                            이 객체의 href 속성의 값을 변경하면, 그 즉시, 웹브라우저는 변경된 URL로 이동됨
        */

    } else {
        location.href = '에러.html'
    }

} else {
    localtion.href = '에러.html'
}