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
	<body class="page2">
		<div>
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
				<div>
					<h3>Administrative Dashboard</h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Order ID</th>
								<th scope="col">First Name</th>
								<th scope="col">Last Name</th>
								<th scope="col">Appointment Date</th>
								<th scope="col">Edit Appointment</th>
								<th scope="col">Cancel Appointment</th>
							</tr>				
						</thead>
						<tbody> <!-- dynamic rendering -->
							<c:forEach var="order" items = "${orders}">  <!-- For Loop -->
								<tr scope="row">
									<td ><c:out value="${order.id}"></c:out></td>
									<td ><c:out value="${order.firstName}"></c:out></td>
									<td ><c:out value="${order.lastName}"></c:out></td>
									<td ><c:out value="${order.appointment}"></c:out></td>
									<td ><a href="/admin/edit/${order.id}">Edit</a></td>
									<td>
										<form action="/admin/delete/${order.id}" method="post"> 
										<input type="hidden" name="_method" value="delete">
		    							<input type="submit" value="Delete">
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>			
					</table>
				</div>			
			</section>
			<section>
				<div class="footer">
					<p class="footer-text">We are not lawyers, and don’t give legal advice, so always check with your own attorneys, advisors, or document recipients if you have unanswered questions about notarization or digitally notarized documents.</p>
				</div>
			</section>
		</div>
	</body>
</html>