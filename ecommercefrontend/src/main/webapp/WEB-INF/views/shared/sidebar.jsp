<h1 class="my-4">Products</h1>
<div class="list-group">
	<s:forEach items="${allCategories}" var="category">
		<a href="${contextRoot}/all/${category.id}/products" id ="a_${category.name}" class="list-group-item">${category.name}</a>
	</s:forEach>
</div>