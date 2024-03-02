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
		<div class="intro">
			<h1>Welcome!</h1>
			<p>Join our growing community.</p>
		</div>
			<form:form class="container mt-5" action="/registration" method="post" modelAttribute="user">
				<div class="row">
					<h1 class="header">Register</h1>
				</div>		
				<form:errors path="*" type="text"/>		
				<div class="row">
					<form:label class = "col-md-6" for="username" path="username">User Name: </form:label>
					<form:input class = "col-md-6" path="username" type="text"/>
					
				</div>
				<div class="row">
					<form:label class = "col-md-6" for="email" path="email">Email: </form:label>
					<form:input class = "col-md-6" path="email" type="text"/>
					
				</div>
				<div class="row">
					<form:label class = "col-md-6" for="password" path="password">Password: </form:label>
					<form:input class = "col-md-6" path="password" type="text"/>
					
				</div>
				<div class="row">
					<form:label class = "col-md-6" for="confirmPassword" path="confirmPassword">Confirm Password: </form:label>
					<form:input class = "col-md-6" path="confirmPassword" type="text"/>
					
				</div>
				<div class="d-flex justify-content-center">
					<button class="custom-btn">Submit</button>
				</div>
			</form:form>
			<form:form class="container mt-5" action="/welcome" method="post" modelAttribute="loginUser">
				<div class="row">
					<h1 class="header">Log In</h1>
				</div>	
				<form:errors path="*" type="text"/>						
				<div class="row">
					<form:label class = "col-md-6" for="email" path="email">Email: </form:label>
					<form:input class = "col-md-6" path="email" type="text"/>
					
				</div>
				<div class="row">
					<form:label class = "col-md-6" for="password" path="password">Password: </form:label>
					<form:input class = "col-md-6" path="password" type="text"/>
					
				</div>
				<div class="d-flex justify-content-center">
					<button class="custom-btn">Submit</button>
				</div>
			</form:form>   
	</body>
</html>