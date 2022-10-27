<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize"><i class="fa fa-list"></i> <a class="link-dark" href="<c:url value="/ctl/policy/category"/>">Category</a></li>
    <li class="breadcrumb-item linkSize"><i class="fa fa-list-alt"></i> <a class="link-dark" href="<c:url value="/ctl/policy/search"/>">Policy</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Compare Policy Detail</li>
  </ol>
</nav>
</div>
<hr>

<div class="container"> 
		<div class="row">
			<div class="col">
		<div class="card" style="width: 600px">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">Policy Detail 1</h5>
			<div class="card-body">
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"> <h4>Policy Description : </h4></label>
						<p>${dto1.description}</p>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Category : </h6> ${dto1.category}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Name : </h6> ${dto1.name}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Duration : </h6> ${dto1.duration}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Price : </h6> ${dto1.price}</label>
				</div>	
				<hr>		
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> ROI : </h6> ${dto1.roi}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Rating : </h6> ${dto1.rating}</label>
				</div>
				<hr>
				<br>
				<div class="col-12">
					<a class="btn btn-primary pull-right"  href='<c:url value="/ctl/buyPolicy?pId=${dto1.id}" />'>Apply</a>
				</div>
			</div>
		</div>
		</div>
		<br>
		<div class="col">
		<div class="card" style="width: 600px">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">Policy Detail 2</h5>
			<div class="card-body">
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"> <h4>Policy Description : </h4></label>
						<p>${dto2.description}</p>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Category : </h6> ${dto2.category}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Name : </h6> ${dto2.name}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Duration : </h6> ${dto2.duration}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Price : </h6> ${dto2.price}</label>
				</div>	
				<hr>		
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> ROI : </h6> ${dto2.roi}</label>
				</div>
				<hr>
				<div class="col-md-6">
						<label for="inputEmail4" class="form-label"><h6> Rating : </h6> ${dto2.rating}</label>
				</div>
				<hr>
				<br>
				<div class="col-12">
					<a class="btn btn-primary pull-right"  href='<c:url value="/ctl/buyPolicy?pId=${dto2.id}" />'>Apply</a>
				</div>
			</div>
		</div>
		</div>
	</div>
	</div>
	<br>