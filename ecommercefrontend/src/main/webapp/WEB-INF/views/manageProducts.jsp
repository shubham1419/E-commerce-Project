<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

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
	<div class="row">
		<div class="card bg-light text-dark">
			<div class="card-header">
				<h3>Manage Products</h3>
			</div>
			<div class="card-body">
				<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products" method="POST"
					enctype="multipart/form-data">

					<div class="form-group">
						<label class="control-label col-md-4" for="name">Enter
							Product Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="name"
								placeholder="Product Name" class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Enter
							Product Brand: </label>
						<div class="col-md-8">
							<sf:input type="text" path="brand" id="brand"
								placeholder="Product Brand" class="form-control" />
							<sf:errors path="brand" cssClass="help-block" element="em" />

						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="description">Enter
							Product Description: </label>
						<div class="col-md-8">
							<sf:textarea path="description" id="description"
								placeholder="Product Description" class="form-control"></sf:textarea>
							<sf:errors path="description" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="price">Enter
							Product Price: </label>
						<div class="col-md-8">
							<sf:input type="text" path="unitPrice" id="unitPrice"
								placeholder="Product Price" class="form-control" />
							<sf:errors path="unitPrice" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Qty
							Available: </label>
						<div class="col-md-8">
							<sf:input type="text" path="quantity" id="quantity"
								placeholder="Product Quantity" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="file">Upload
							Image </label>
						<div class="col-md-8">
							<sf:input type="file" path="file" id="file" class="form-control" />
							<sf:errors path="file" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="catedoryId">Select
							Category: </label>
						<div class="col-md-8">
							<!-- items ="${categories}" same name as given in modal attribute -->
							<!-- itemsLabel = "name"" what we want to show in select option -->
							<!-- iitemValue="id" for value in option -->


							<sf:select class="form-control" id="categoryId" path="categoryId"
								items="${categories}" itemLabel="name" itemValue="id" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="submit" id="submit" value="submit"
								class="btn btn-primary">
						</div>
					</div>
					<!-- Hidden fields -->
					<sf:hidden path="id" />
					<sf:hidden path="code" />
					<sf:hidden path="active" />
					<sf:hidden path="supplierId" />
					<sf:hidden path="purchases" />
					<sf:hidden path="views" />
				</sf:form>
			</div>
		</div>
	</div>
</div>