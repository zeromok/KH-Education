<%--
  Created by IntelliJ IDEA.
  User: mokpro
  Date: 2022/09/09
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edg e">
  <title>Login Form</title>

  <style>
    form {
      border: 5px solid gray;
    }
  </style>

  <script>
    var result = "${__RESULT__}";

    if(result != null && result.length > 0) {
      alert(result);
    }
  </script>
  <%-- 로그인이 되지 않았을때 전달된 데이터를 alert 해주는 스크립트 코드 --%>

</head>
<body>
<h1>/WEB-IMF/views/user/login.jsp</h1>
<hr>

<form action="/user/loginPost" method="POST">

  <legend>Login Form</legend>

  <div><input type="text" name="userid" placeholder="user id"></div>
  <div><input type="password" name="userpw" placeholder="User Password"></div>
  <div> Remember-me <input type="checkbox" name="rememberMe"></div>

  <p></p>

  <div>
    <button type="submit">Sing-in</button>
  </div>
</form>
</body>
</html>
