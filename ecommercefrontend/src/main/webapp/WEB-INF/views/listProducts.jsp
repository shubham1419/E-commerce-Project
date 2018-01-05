<div class="container">
	<div class="row">
		<div class="col-md-3">
		<%@include file="./shared/sidebar.jsp" %>
		</div>
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
				<s:if test="${userClickAllProducts == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home / </a></li>
						<li class="active">All Products</li> 
					</ol>	
				</s:if>
				<s:if test="${userClickCategoryProducts == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home / </a></li>
						<li class="active">All Products - </li> 
						<li class="active">${category}</li> 
					</ol>	
				</s:if>	
					
				</div>
			</div>
		</div>
		
	</div>

</div>