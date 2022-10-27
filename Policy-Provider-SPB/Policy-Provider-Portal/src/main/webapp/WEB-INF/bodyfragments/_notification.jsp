<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>

<c:url var="editUrl" value="/ctl/buyPolicy/renewal?id=" />

<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Notification</li>
  </ol>
</nav>
</div>
<hr>

		<div class="card">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">Notification</h5>
			<div class="card-body">
				<div class="row g-3">
				</div>
				<b><%@ include file="businessMessage.jsp"%></b>
				<br>

				<table class="table table-bordered border-primary">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Policy Name</th>
							<th scope="col">Renewal Date</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="pl" varStatus="policy">
							<tr>
								<td scope="row">${policy.index+1}</td>
								<td scope="row">${pl.policyName}</td>
								<td scope="row">${pl.renawalDate}</td>
								<td><a class="btn btn-sm btn-info" href="${editUrl}${pl.buyPolicyId}"
									>Renewal Policy</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>

		</div>
