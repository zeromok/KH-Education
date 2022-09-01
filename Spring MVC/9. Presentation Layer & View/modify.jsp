<%--
  Created by IntelliJ IDEA.
  User: mokpro
  Date: 2022/08/25
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>modify.jsp</title>

    <style>
        #container {
            width: 1024px;
            margin: 0 auto;

        }
        #modifyBtn {
            width: 90px;
            height: 35px;

            border: 0;

            font-size: 14px;
            font-weight: bold;
            font-family: D2Coding;

            color: white;
            background-color: gray;

            cursor: pointer;
        }
        #listBtn {
            width: 90px;
            height: 35px;

            border: 0;

            font-size: 14px;
            font-weight: bold;
            font-family: D2Coding;

            color: white;
            background-color: gray;

            cursor: pointer;
        }
        caption {
            font-size: 20px;
            font-weight: bold;
        }
        #removeBtn {
            width: 90px;
            height: 35px;

            border: 0;

            font-size: 14px;
            font-weight: bold;
            font-family: D2Coding;

            color: white;
            background-color: gray;

            cursor: pointer;
        }
        #submitBtn {
            width: 90px;
            height: 35px;

            border: 0;

            font-size: 14px;
            font-weight: bold;
            font-family: D2Coding;

            color: white;
            background-color: gray;

            cursor: pointer;
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" ></script>

    <script>

        $(function () {
            console.clear()

            $('#listBtn').on('click', function () {

                location.href = "/board/list";
                // GET /board/list Request

            }); // .onclick

            $('#removeBtn').click( () => {
                // [ POST /board/remove + bno ]

                // Post 로 보내야하기 때문에 스크립트에서 from 태그를 직접 조작해 보내보자
                let formObj = $('form');

                formObj.attr('action', '/board/remove');
                formObj.attr('method', 'POST');
                // .attr : 속성 조작 메소드
                // form 태그의 속성을 바꿔 보내준다.

                formObj.submit();

            })

        }) // .jp

    </script>

</head>
<body>
<h1>/WEB-INF/views/board/modify.jsp</h1>
<hr>

<div id="container">

    <form action="/board/modify" method="post">
        <input type= "hidden" name="bno" value="${board.bno}">
        <%-- bno 값을 input 태그로 전달하기 위해 사용 --%>

        <table>

            <caption>${board.bno} 번 게시글 수정 중...</caption>

            <tr>
                <td><label for="title">제목</label></td>
                <td><input type="text" id="title" name="title" size="50" value="${board.title}"  ></td>
            </tr>

            <tr>
                <td><label for="content">내용</label></td>
                <td><textarea name="content" id="content" cols="52" rows="10" >${board.content}</textarea></td>
            </tr>

            <tr>
                <td><label for="writer">작성자</label></td>
                <td><input type="text" id="writer" name="writer" size="20" value="${board.writer}" readonly ></td>
                <%-- 작성자는 수정 불가능 == readonly --%>
            </tr>

            <tr>
                <td colspan="2">&nbsp;</td>
            </tr>

            <tr>
                <td colspan="2">

                    <button type="submit" id="submitBtn">SUBMIT</button>
                    <button type="button" id="removeBtn">REMOVE</button>
                    <button type="button" id="listBtn">LIST</button>

                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>