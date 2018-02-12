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

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextRoot}/home">Online
					Shopping</a>
			</div>
		</div>
	</nav>
	<!-- Page Content -->
	<div class="content-height">

<s:if test="${not empty message}">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="alert alert-${mclass} alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">
						&times;</button>${message}
				</div>
			</div>
		</div>
	</s:if>


		<form action="${contextRoot}/login" method="POST"
			class="form-horizontal" id="loginForm">
			<div class="form-group">
				<label for="username" class="col-md-4 control-label">Email:
				</label>
				<div class="col-md-8">
					<input type="text" name="username" id="username"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-md-4 control-label">Password:
				</label>
				<div class="col-md-8">
					<input type="password" name="password" id="password"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				
				<div class="col-md-8">
					<input type="submit" name="Login" class="form-control" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</div>
			</div>


			<%-- 			<div class="form-group">
				<div class="col-md-offset-4 col-md-8">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="submit" value="Login"
						class="btn btn-primary" />
				</div>
			</div> --%>
		</form>

		<div class="panel-footer">
			<div class="text-right">
				New User - <a href="${contextRoot}/register">Register Here</a>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>


	<!--Form Validation script -->
	<script src="${js}/jquery.validate.js"></script>

	<!-- my custom js -->
	<script src="${js}/myweb.js"></script>

</body>

</html>
