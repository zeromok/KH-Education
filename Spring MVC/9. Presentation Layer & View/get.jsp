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

    <title>get.jsp</title>

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

            $('#modifyBtn').click( () => {

                // GET /board/list Requests
                location.href = "/board/modify?bno=${board.bno}";

            })

        }) // .jp

    </script>

</head>
<body>
    <h1>/WEB-INF/views/board/get.jsp</h1>
    <hr>

    <div id="container">

        <form action="#">

            <table>

                <caption>게시글 번호 : ${board.bno}</caption>

                <tr>
                    <td><label for="title">제목</label></td>
                    <td><input type="text" id="title" name="title" size="50" value="${board.title}" readonly ></td>
                </tr>

                <tr>
                    <td><label for="content">내용</label></td>
                    <td><textarea name="content" id="content" cols="52" rows="10" readonly >${board.content}</textarea></td>
                </tr>

                <tr>
                    <td><label for="writer">작성자</label></td>
                    <td><input type="text" id="writer" name="writer" size="20" value="${board.writer}" readonly ></td>
                </tr>

                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>

                <tr>
                    <td colspan="2">

                        <button type="button" id="modifyBtn">MODIFY</button>
                        <button type="button" id="listBtn">LIST</button>

                    </td>
                </tr>

            </table>
        </form>
    </div>

</body>
</html>
