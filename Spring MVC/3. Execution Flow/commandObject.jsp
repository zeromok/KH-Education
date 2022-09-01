<%--
  Created by IntelliJ IDEA.
  User: mokpro
  Date: 2022/08/17
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%-- 필요없음 web.xml 파일에 공통속성으로 들어가 있다. --%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>commandObject.jsp</title>
</head>
<body>
    <h1>/WEB-INF/views/commandObject.jsp</h1>
    <hr>

    <h1>SampleDTO</h1>
    <h2>1. name : ${sampleDTO.name}</h2>
    <h2>2. age : ${sampleDTO.age}</h2>
    <h2>3. SampleDTO : ${sampleDTO}</h2>
    <hr>

    <h1>page</h1>
    <h2>4. page : ${page}</h2>
    <hr>
</body>
</html>