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
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Categories</li>
  </ol>
</nav>
</div>
<hr>

<div class="container"> 
<div class="row row-cols-1 row-cols-md-2 g-4">
  <div class="col">
    <div class="card">
     <a href="${pageContext.request.contextPath}/ctl/policy/search?category=Life">
      <img height="320px" width="200px" src="${pageContext.request.contextPath}/resources/images/hands-in-hands-protecting-paper-family.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <h5 class="card-title">Life</h5>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <a href="${pageContext.request.contextPath}/ctl/policy/search?category=Health">
      <img height="320px" width="200px" src="${pageContext.request.contextPath}/resources/images/Health.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <h5 class="card-title">Health</h5>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
    <a href="${pageContext.request.contextPath}/ctl/policy/search?category=Electronics">
      <img height="320px" width="200px" src="${pageContext.request.contextPath}/resources/images/insuranceElecronics.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <h5 class="card-title">Electronics</h5>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
    <a href="${pageContext.request.contextPath}/ctl/policy/search?category=Vehicle">
      <img height="320px" width="200px"  src="${pageContext.request.contextPath}/resources/images/affordable-car-insurance-1024x682.jpg" class="card-img-top" alt="..."></a>
      <div class="card-body">
        <h5 class="card-title">Vehicle</h5>
      </div>
    </div>
  </div>
</div>
</div>
<br>