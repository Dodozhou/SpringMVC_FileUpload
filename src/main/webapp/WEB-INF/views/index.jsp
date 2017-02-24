<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h2>Hello Multipart!</h2>

<form action="<s:url value="/upload"/>" method="post" enctype="multipart/form-data">
    <label>选择您要上传的图片：</label>
    <input type="file" name="image" accept="image/jpeg,image/png,image/gif"><br/>
    <input type="submit" value="提交">
</form>


</body>
</html>
