<div class="container">
	<div class="row">
				<div class="col-lg-12">
					
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home / </a></li>
							<li><a href="${contextRoot}/show/all/products">Product / </a></li>
							<li class="active">${product.name}</li>
						</ol>

				</div>
	</div>
	
	<div class="row">
	<!-- product image section -->
		<div class="col-xs-12 col-md-4">
			<img src="${images}/${product.code}.jpg" class="img img-fluid img-thumbnail">
		</div>
	<!-- product information section -->
	<div class="col-xs-12 col-md-8">
		<h3>${product.name}</h3>
		<hr/>
		<h4>${product.description}</h4>
		<hr/>
		<h4>Price: <strong> &#8377; ${product.unitPrice}</strong></h4>
		<h5>Qty. ${product.quantity}</h5>
		<a href="${contextRoot}/cart/add/${product.id}/product"class= "btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"> Add To Cart</i></a>
		<a href="${contextRoot}/all/products"class= "btn btn-success"><i class="fa fa-arrow-left" aria-hidden="true"> Back</i></a>
		</div>
	</div>
	
	</div>

