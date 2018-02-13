<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="container">
	<div class="row">
		<div class="col-lg-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home / </a></li>
				<li><a href="${contextRoot}/all/products">Product / </a></li>
				<li class="active">${product.name}</li>
			</ol>

		</div>
	</div>

	<div class="row">
		<!-- product image section -->
		<div class="col-xs-12 col-md-4">
			<img src="${images}/${product.code}.jpg"
				class="img img-fluid img-thumbnail">
		</div>
		<!-- product information section -->
		<div class="col-xs-12 col-md-8">
			<h3>${product.name}</h3>
			<hr />
			<h4>${product.description}</h4>
			<hr />
			<h4>
				Price: <strong> &#8377; ${product.unitPrice}</strong>
			</h4>

			<s:choose>
				<s:when test="${product.quantity < 1 }">
					<h5>
						<span style = "color:red">Out of Stock</span>
					</h5>
				</s:when>
				<s:otherwise>
					<h5>Qty. ${product.quantity}</h5>
				</s:otherwise>
			</s:choose>
			<security:authorize access="hasAuthority('USER')">
				<s:choose>
					<s:when test="${product.quantity < 1 }">
						<a href="javascriptvoid(0)" class="btn btn-success disabled"><strike><i
								class="fa fa-shopping-cart" aria-hidden="true"> Add To Cart</i></strike></a>
					</s:when>
					<s:otherwise>
						<a href="${contextRoot}/cart/add/${product.id}/product"
							class="btn btn-success"><i class="fa fa-shopping-cart"
							aria-hidden="true"> Add To Cart</i></a>
					</s:otherwise>
				</s:choose>
			</security:authorize>
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product"
							class="btn btn-success"><i class="fa fa-pencil"
							aria-hidden="true">Edit</i></a>
			</security:authorize>
			
			<a href="${contextRoot}/all/products" class="btn btn-success"><i
				class="fa fa-arrow-left" aria-hidden="true"> Back</i></a>
		</div>
	</div>

</div>

