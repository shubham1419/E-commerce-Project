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
		window.contextRoot = '${contextRoot}';	
	</script>
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- font-awesome CSS -->
    <link href="${css}/font-awesome.css" rel="stylesheet">

    <!-- bootswatch styles for this template -->
    <link href="${css}/style.css" rel="stylesheet">

    <!-- data Table css -->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
    
     <!-- Custom styles for this template -->
    <link href="${css}/home.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
	<%@include file="./shared/navigation.jsp" %>

    <!-- Page Content -->
    <div class="content-height">
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
	<!-- for Allproducts/categoryproducts page -->
	<s:if test="${userClickAllProducts== true or userClickCategoryProducts== true}">
	<%@include file="listProducts.jsp"%>
	</s:if>
	<!-- for single product page -->
	<s:if test="${userClickShowProduct== true}">
	<%@include file="singleProduct.jsp"%>
	</s:if>
	<!-- for Management product page -->
	<s:if test="${userClickManageProduct== true}">
	<%@include file="manageProducts.jsp"%>
	</s:if>
	</div>	
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

	
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    
    <!!-- Data Table js-->
     <script src="${js}/jquery.dataTables.js"></script>
     <script src="${js}/dataTables.bootstrap4.js"></script>
    
    <!-- my custom js -->
     <script src="${js}/myweb.js"></script>

  </body>

</html>
