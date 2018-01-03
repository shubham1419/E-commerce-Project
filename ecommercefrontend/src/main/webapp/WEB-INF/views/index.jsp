<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="springTag" uri="http://www.springframework.org/tags" %>
<springTag:url var="css" value="/resources/css" />
<springTag:url var="js" value="/resources/js" />
<springTag:url var="images" value="/resources/images" />
<s:set var= "contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shopping - ${title}</title>
	<script>
		window.menu = '${title}';		
	</script>
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/homepage.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
	<%@include file="./shared/navigation.jsp" %>

    <!-- Page Content -->
    
    <!-- for home page -->
    <s:if test="${userClickHome== true}">
	<%@include file="home.jsp" %>
	</s:if>
	<!-- for about page -->
	<s:if test="${userClickAbout== true }">
	<%@include file="about.jsp" %>
	</s:if>
	<!-- for contact page -->
	<s:if test="${userClickContact== true}">
	<%@include file="contact.jsp"%>
	</s:if>
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <!-- my custom js -->
     <script src="${js}/myweb.js"></script>

  </body>

</html>
