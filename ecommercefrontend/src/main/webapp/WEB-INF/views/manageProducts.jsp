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
		<div classiv class="card bg-light text-dark">
			<div class="card-header">
				<h3>Manage Products</h3>
			</div>
			<div class="card-body">
<%-- 				<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products" method="POST"
					enctype="multipart/form-data"> --%>
					
<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST"	>
					

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

					<%-- <div class="form-group">
						<label class="control-label col-md-4" for="file">Upload
							Image </label>
						<div class="col-md-8">
							<sf:input type="file" path="file" id="file" class="form-control" />
							<sf:errors path="file" cssClass="help-block" element="em" />
						</div>
					</div>
 --%>
					<div class="form-group">
						<label class="control-label col-md-4" for="catedoryId">Select
							Category: </label>
						<div class="col-md-8">
							<!-- items ="${categories}" same name as given in modal attribute -->
							<!-- itemsLabel = "name"" what we want to show in select option -->
							<!-- iitemValue="id" for value in option -->


							<sf:select class="form-control" id="categoryId" path="categoryId"
								items="${categories}" itemLabel="name" itemValue="id" />
								<s:if test="${product.id == 0}">	
									<div class="text-right">
									<br/>
									<button type="button" data-toggle="modal" data-target="#myCategoryModel" class="btn btn-outline- btn-sm">Add Category</button>
									</div>
								</s:if>
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
	
	 <div class="row">
	 	<div class="col-md-12">
	 	<h3>Avalable Products</h3>
	 	<hr/>
	 	</div>
	 	
	 	<div class="col-md-12">
	 		<div style="overflow:auto">
	 		<div class="table-responsive">
	 		<table id="adminProductsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
	 		</div>
	 		</div>
	 			
	 	</div>
	 </div>
	<div class="row">
	
		<div class="modal fade" id="myCategoryModel">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Add New Category</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        	<sf:form modelAttribute="category" id="categoryForm" class="form-horizontal" action="${contextRoot}/manage/category" method= "POST">
        		<div class="form-group">
        			<label for="category_name" class="control-label col-md-4">Category Name</label> 
        			<div class="col-md-8">
        			<sf:input type="text" path="name" id="category_name" placeholder="Enter Category Name" />
        			</div>
        		</div>
        		
        		<div class="form-group">
        			<label for="category_description" class="control-label col-md-4">Category Description</label> 
        			<div class="col-md-8">
        			<sf:textarea path="description" cols="" rows="4" id="category_description" placeholder="Enter Category Description"></sf:textarea>
        			</div>
        		</div>
        		<div class="form-group">
        			<div class="col-md-offset-4 col-md-8">
						<input type="submit" value ="Add Category" class="btn btn-primary">
        			</div>
        		</div>
        		
        	</sf:form>  
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
	
	</div>
</div>