<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/buyPolicy" />

<c:url var="addSearch" value="/ctl/buyPolicy/search" />

<c:url var="editUrl" value="/ctl/buyPolicy?id=" />

<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Buy Policy</li>
  </ol>
</nav>
</div>
<hr>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/buyPolicy/search"
		modelAttribute="form">
		<div class="card">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">Buy Policy</h5>
			<div class="card-body">
				<div class="row g-3">
					
					<s:bind path="policyName">
						<div class="col">
							<sf:input path="${status.expression}" class="form-control form-control-sm"
								placeholder="Search By Policy Name" />
						</div>
					</s:bind>
					
					<s:bind path="firstName">
						<div class="col">
							<sf:input path="${status.expression}" class="form-control form-control-sm"
								placeholder="Search By First Name" />
						</div>
					</s:bind>
					
					<div class="col">
						<input type="submit" class="btn btn-sm btn-outline-primary"
							name="operation" value="Search"></input> or <input type="submit"
							class="btn btn-sm btn-outline-secondary" name="operation"
							value="Reset">
					</div>
				</div>
				<b><%@ include file="businessMessage.jsp"%></b>
				<br>
				<sf:input type="hidden" path="pageNo" />
				<sf:input type="hidden" path="pageSize" />

				<sf:input type="hidden" path="listsize" />
				<sf:input type="hidden" path="total" />
				<sf:input type="hidden" path="pagenosize" />

				<table class="table table-bordered border-primary">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">UserName</th>
							<th scope="col">Email</th>
							<th scope="col">Contact No</th>
							<th scope="col">Policy</th>
							<th scope="col">Price</th>
							<th scope="col">ROI</th>
							<th scope="col">Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="bp" varStatus="buyPolicy">
							<tr>
								<td scope="row">${buyPolicy.index+1}</td>
								<td scope="row">${bp.firstName} ${bp.lastName}</td>
								<td scope="row">${bp.email}</td>
								<td scope="row">${bp.contactNo}</td>
								<td scope="row">${bp.policyName}</td>
								<td scope="row">${bp.price}</td>
								<td scope="row">${bp.roi}</td>
								<td scope="row">${bp.buyDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="clearfix">
			<nav aria-label="Page navigation example float-end">
				<ul class="pagination justify-content-end" style="font-size: 13px">
					<li class="page-item"><input type="submit" name="operation"
								class="page-link" 	<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
								value="Previous"></li>
								 <c:forEach var = "i" begin = "1" end = "${(listsize/10)+1}">
								 <c:if test="${i== pageNo}">
								<li class="page-item active"><a class="page-link activate" href="${addSearch}?pageNo=${i}">${i}</a></li>
								</c:if>
								<c:if test="${i != pageNo}">
								<li class="page-item"><a class="page-link" href="${addSearch}?pageNo=${i}">${i}</a></li>
								</c:if>
								</c:forEach>
					<li class="page-item"><input type="submit" name="operation"
								class="page-link" <c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
								value="Next"></li>
				</ul>
			</nav>
			</div>
				
				
			</div>

		</div>
	</sf:form>
