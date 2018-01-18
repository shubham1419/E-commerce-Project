<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="springTag" uri="http://www.springframework.org/tags"%>
<springTag:url var="css" value="/resources/css" />
<springTag:url var="js" value="/resources/js" />
<springTag:url var="images" value="/resources/images" />
<s:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping - ${title}</title>
<script>
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- bootswatch styles for this template -->
<link href="${css}/style.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/home.css" rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="${contextRoot}/home">Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="content-height">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
				<div class="jumbotron">
					<h1>${errorTitle}</h1>
					<hr/>
					<blockquote style="word-wrap:break-word;">
					${errorDescription}
					</blockquote>
				</div>
				
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>

</body>

</html>
