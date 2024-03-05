<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Notary Website</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/Style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
	    
	</head>
	<body>
			<section>
				<div>
					<h1 class="header">Notary Express</h1>
				</div>
			</section>
			<section>
				<div>
					<ul class="main-nav">
						<li><a href="/logout">Logout</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Feedback</a></li>
					</ul>
				</div>
			</section>
			<section>
				<h1 class = "receipt-text">Thank you for your business!</h1>
				<p class = "receipt-text2">We will be in touch shortly to confirm your day and time.</p>
				<p class = "receipt-text2">Confirmation #A0000543</p>
			</section>
			<section>
				<div>
					<p>Contact Information:</p>
					<p><c:out value="${order.firstName}"></c:out><c:out value="${order.lastName}"></c:out></p>
					<p>Username:  <c:out value="${order.user.username}"></c:out></p>
					<p>Email Address:<c:out value="${order.user.email}"></c:out></p>
					
					<p>Appointment Address:</p>
					<p><c:out value="${order.address}"></c:out>  #<c:out value="${order.unit}"></c:out></p>
					<p><c:out value="${order.city}"></c:out>, AZ, <c:out value="${order.zip}"></c:out></p>
					
					<p>Document(s):</p>
					<ul>
						<li><c:out value="${order.type}"></c:out></li>
						<li><c:out value="${order.name}"></c:out></li>
						<li>Page Count:  <c:out value="${order.pages}"></c:out></li>
						<li><c:out value="${order.typeTwo}"></c:out></li>
						<li><c:out value="${order.nameTwo}"></c:out></li>
						<li>Page Count:  <c:out value="${order.pagesTwo}"></c:out></li>
						<li><c:out value="${order.typeThree}"></c:out></li>
						<li><c:out value="${order.nameThree}"></c:out></li>
						<li>Page Count:  <c:out value="${order.pagesThree}"></c:out></li>
					</ul>
					
					
					<p>Appointment:</p>
					<p>We will email you shortly to  confirm your appointment date and time.</p>
					<p>Proposed Date: <c:out value="${order.appointment}"></c:out></p>
					<p>Proposed Time: <c:out value="${order.timing}"></c:out></p>
					
				</div>
			</section>
	
	</body>
</html>