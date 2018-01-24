<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <sf:form class="form-horizontal" modelAttribute="product"action="${contextRoot}/about" method="POST" enctype="multipart/form-data"> --%>
 <form method="post" action="${contextRoot}/about" enctype="multipart/form-data"  modelAttribute="product">					
name:<input type="text">
<input type="submit" value="submit">

</form>

  <form action="${contextRoot}/manage/products" method="post">
    <table>
      <tr>
        <td>Select File</td>
        <td><input type="file" name="file"></td>
        <td><button type="submit">Upload</button></td>
      </tr>
    </table>
  </form>
  
  <form class="form-horizontal"	action="${contextRoot}/manage/products" method="POST"
					enctype="multipart/form-data">
    <table>
      <tr>
        <td>Select File</td>
        <td><input type="file" name="file"></td>
        <td><button type="submit">Upload</button></td>
      </tr>
    </table>
  </form>
  
  <form method="post" action='${contextRoot}/contact'  modelAttribute="product">
  <table>
      <tr>
        <td>Select File</td>
        <td><input type="file" name="file"></td>
        <td><button type="submit">Upload</button></td>
      </tr>
    </table>
  </form>
  
</body>
</html>