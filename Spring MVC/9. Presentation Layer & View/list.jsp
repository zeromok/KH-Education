<%--
  Created by IntelliJ IDEA.
  User: mokpro
  Date: 2022/08/23
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>list.jsp</title>

    <style>

        * {
            margin: 0 auto;
            padding: 0;
        }
        #wrapper {
            width: 1024px;

            font-family: D2Coding;
            font-size: 16px;
        }
        table {
            width: 100%;
            margin-top: 30px;

            text-align: center;

            border: 1px ridge green;
            border-collapse: collapse;
        }
        tr:hover {
            background-color: bisque;
        }
        th {
            padding: 10px;

            color: white;
            background-color: purple;
            font-size: 18px;
        }
        td {
            padding: 2px;
        }
        caption {
            font-size: 20px;
            font-weight: bold;
            color: black;

            padding: 10px;
        }
        td:nth-child(2) {
            text-align: left;

            width: 40%;
            padding-left: 10px;

            cursor: pointer;
        }
        a, a:link, a:visited {
            text-decoration: none;

            color: black;
        }
        #regBtn {
            width: 150px;
            height: 40px;
            margin-top: 10px;

            border: 0;

            font-size: 20px;
            font-weight: bold;

            color: white;
            background-color: gray;

            cursor: pointer;

            float: right;
        }
        #regBtn {
            content: '';
            display: block;
            clear: both;
        }

    </style>
    <%-- 스타일에 우선순위는 뒤로 미루자 일단 구현 먼저 --%>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" ></script>
    <%-- CDN (Contents Delivery Network) 방식으로 자바스크립트의 라이브러리인 jQuery 사용 선언 --%>

    <script>

        $(function () {
            console.clear()

            $('#regBtn').on('click', function () {

                location.href = "/board/new";
                // GET /board/register Request
                // location.href ="" : 연결된 객체의 위치 즉, click 하면 /board/new 로 이동한다.

            }); // .onclick
            /*
            .on() : 그룹이벤트 등록 방식
            위에서는 이벤트가 하나이므로

                $('#regBtn').click( function () {
                    location.href = "/board/new";
                }); // 익명함수

                ==== OR ====

                $('#regBtn').click( () => {
                    location.href = "/board/new";
                }); // 람다식

            둘중 하나의 방법을 써도 무관하다.
            */

        }) // .jp

    </script>

    <script>

        var result = "${param.result}";
        // 수정 or 삭제 후 다시 list.jsp 로 돌아올 때 전송파라미터를 얻어내 성공했는지 실패했는지 알려준다.

        if(result != null && result.length > 0) {

            alert(result);
            // alert : 지정된 창에 메세지 게시 (알림창)

        }// if

    </script>
</head>
<body>
    <h1>/WEB-INF/views/board/list.jsp</h1>
    <hr>

    <div id="wrapper">

        <button type="button" id="regBtn">REGISTER</button>

    <table>

        <caption>tbl_board</caption>

        <thead>
            <tr>
                <th>bno</th>
                <th>title</th>
                <th>writer</th>
                <th>insertTs</th>
                <th>updateTs</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="board" items="${list}">
            <%--
            1. 향상된포문과 비슷
            2. var 속성이 곧 EL 변수명
            3. list를 통해 얻어진 (var)board = BoardVO
            --%>
                <tr>
                    <td>${board.bno}</td>
                    <td><a href="/board/get?bno=${board.bno}">${board.title}</a></td>
                    <%-- 게시판에 제목을 누르면 get() 메소드를 이용해 해당 컬럼조회 가능 --%>
                    <td>${board.writer}</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.insertTs}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.updateTs}" /></td>
                </tr>
            </c:forEach>
        </tbody>
        <%-- 테이블의 내용 --%>
        <%-- list의 요소만큼 반복을 돌며 태그를 붙여주는 반복문이 필요 --%>

        <tfoot>

        </tfoot>

    </table>

    </div>


</body>
</html>
