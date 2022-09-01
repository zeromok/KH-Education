<%--
  Created by IntelliJ IDEA.
  User: mokpro
  Date: 2022/08/18
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>fileUploadPage.jsp</title>
</head>
<body>
    <h1>/WEB-INF/views/fileUpload/fileUploadPage.jsp</h1>
    <hr>

    <form action="/fileUpload/doit"
          method="POST"
          enctype="multipart/form-data">

        <div>Name : <input type="text" size="30" name="myName"></div>
        <br>
        <div>Age : <input type="text" size="30" name="myAge"></div>
        <br><br>
        <div>1. <input type="file" name="files"></div>
        <br>
        <div>2. <input type="file" name="files"></div>
        <br>
        <div>3. <input type="file" name="files"></div>
        <br>
        <div>4. <input type="file" name="files"></div>
        <br>
        <div>5. <input type="file" name="files"></div>

<%--        <div><input type="file" name="files" multiple></div>--%>
            <%-- 위 5개 태그와 같지만 옆에 파일명이 갯수로 표현됨 --%>
        <p>&nbsp;</p>
        <div><input type="submit" value="Upload"></div>

    </form>

</body>
</html>
