<div class="container">

	<div class="row">
		<!-- 		sidebar	 -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- 		Product list	 -->
		<div class="col-md-3">
			<div class="row">
				<!-- 			breadcrum component -->
				<div class="col-md-12">
					<c:if test="${userClickAllProducts == true }">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts == true }">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name }</li>
						</ol>
					</c:if>
				</div>
			</div>

		</div>
	</div>

</div>