<%--
  Created by IntelliJ IDEA.
  User: mokpro
  Date: 2022/08/24
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>new.jsp</title>

    <style>

        #wrapper {
            width: 1024px;
            margin: 0 auto;

            font-family: D2Coding;
            font-size: 16px;
        }
        #submitBtn {
            width: 100px;
            height: 40px;

            border: 0;

            font-size: 14px;
            font-weight: bold;
            font-family: D2Coding;

            color: white;
            background-color: gray;

            cursor: pointer;
        }
        #listBtn {
            width: 100px;
            height: 40px;

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

                location.href = "/board/list?currPage=${param.currPage}";
                // GET /board/list Request

            }); // .onclick

        }) // .jp

    </script>

</head>
<body>
    <h1>/WEB-INF/views/board/new.jsp</h1>
    <hr>

    <div id="wrapper">
        <form action="/board/register " method="post">
        <%-- 입력양식(데이터)를 post 방식으로 /board/register 로 보내겠다. --%>
<%--            <input type= "hidden" name="currPage" value="${ct.currPage}">&ndash;%&gt;--%>
            <%-- 기준값 전송파라미터 전달 하지만 등록 처리시에는, 같이 전송하면 안됨
                 게시판 목록의 가장 처음페이지로 이동해야함--%>

            <table>

                <tr>
                    <td><label for="title">제목</label></td>
                    <td><input type="text" id="title" name="title" size="50" placeholder="내용을 입력하세요." required ></td>
                </tr>

                <tr>
                    <td><label for="content">내용</label></td>
                    <td><textarea name="content" id="content" cols="52" rows="10" placeholder="내용을 입력하세요." required ></textarea></td>
                </tr>

                <tr>
                    <td><label for="writer">작성자</label></td>
                    <td><input type="text" id="writer" name="writer" size="20" placeholder="작성자" required ></td>
                </tr>

                <tr>
                    <td colspan="2">&nbsp;</td>
                    <%-- cloapan : 위 <td>를 병합해줘서 사이의 간격을 줄여 준다. --%>
                </tr>

                <tr>
                    <td colspan="2">
                        <button type="submit" id="submitBtn">SUBMIT</button>
                        <button type="button" id="listBtn">LIST</button>
                    </td>
                </tr>

                </table>
        </form>
    </div>



</body>
</html>
