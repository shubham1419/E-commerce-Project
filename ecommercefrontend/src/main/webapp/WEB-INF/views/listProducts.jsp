<div class="container">
	<div class="row">
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- to display products in product page -->
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<s:if test="${userClickAllProducts == true}">
					<script>
					window.categoryId = '';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home / </a></li>
							<li class="active">All Products</li>
						</ol>
					</s:if>
					<s:if test="${userClickCategoryProducts == true}">
					<script>
					window.categoryId = '${category.id}';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home / </a></li>
							<li class="active">All Products -</li>
							<li class="active">${category.name}</li>
						</ol>
					</s:if>

				</div>
			</div>

			<div class="row">
				<div class="col-xs-12 col-md-12 col-lg-12">
				<div class="table-responsive">
					<table id="productTable" class="table table-stripe table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty.</th>
								<th></th>
							</tr>
						</thead>

							<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty.</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>
			</div>
		</div>

	</div>

</div>