<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Policy</li>
  </ol>
</nav>
</div>
<hr>
<div class="container"> 
	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/policy"
		modelAttribute="form">
		<sf:hidden path="id"/>
		<div class="card">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">Policy</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>
				
				<div class="col-md-6">
					<s:bind path="category">
						<label for="inputEmail4" class="form-label">Category</label>
						<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${category}" />
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="name">
						<label for="inputEmail4" class="form-label">Name</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Name" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="price">
						<label for="inputEmail4" class="form-label">Price</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Price" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				<div class="col-md-6">
					<s:bind path="duration">
						<label for="inputEmail4" class="form-label">Duration</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Duration" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="roi">
						<label for="inputEmail4" class="form-label">ROI</label>
						<sf:input path="${status.expression}"
							placeholder="Enter ROI" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="rating">
						<label for="inputEmail4" class="form-label">Rating</label>
						<sf:input path="${status.expression}" placeholder="Enter Rating"
							class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="date">
						<label for="inputEmail4" class="form-label">Renewal Date</label>
						<sf:input path="${status.expression}" placeholder="Enter Renewal Date"
							class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="description">
						<label for="inputEmail4" class="form-label">Description</label>
						<sf:textarea path="${status.expression}"
							placeholder="Enter Description" rows="4" cols="4" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>

				<br>
				<div class="col-12">
					<input type="submit" name="operation"
						class="btn btn-primary pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-primary pull-right"
						value="Reset">
				</div>
			</div>
		</div>
	</sf:form>
</div>