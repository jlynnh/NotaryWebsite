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
		<div>
			<section>
				<div>
					<h1 class="header">Notary Express</h1>
				</div>
			</section>
			<section>
				<div>
					<ul class="main-nav">
						<li><a href="/">Home</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Feedback</a></li>
					</ul>
				</div>
			</section>
		</div>
		<div>
			<section>
				<div>
					<img src="<c:url value='/css/bodypicv1.jpg' />" alt="background image" class="background-image">
					<h4>Experience our mobile notary business today servicing the greater Phoenix area!</h4>					
				</div>
			</section>
			<section>
				<div class="signup">
					<p class="login-text1">Login and Order Today!</p>
					<p class="login-text">--------------------------Sign In-----------------------------</p>
					<form:form action="/welcome2" method="post" modelAttribute="loginUser">
						<form:errors path="*" type="text"/>						
						<div class="row">
							<form:label class = "col-md-3" for="email" path="email">Email: </form:label>
							<form:input class = "col-md-4" path="email" type="text"/>	
						</div>
						<div class="row">
							<form:label class = "col-md-3" for="password" path="password">Password: </form:label>
							<form:input class = "col-md-4" path="password" type="text"/>
						</div>
						<div>
							<button class="custom-btn">Submit</button>
						</div>
					</form:form>					
					<p class="login-text1">Quick Sign Up!</p>
					<p class="login-text">--------------------------Register-----------------------------</p>
					<form:form action="/registration" method="post" modelAttribute="user">
						<form:errors path="*" type="text"/>		
						<div class="row">
							<form:label class = "col-md-3" for="username" path="username">User Name: </form:label>
							<form:input class = "col-md-4" path="username" type="text"/>
							
						</div>
						<div class="row">
							<form:label class = "col-md-3" for="email" path="email">Email: </form:label>
							<form:input class = "col-md-4" path="email" type="text"/>
							
						</div>
						<div class="row">
							<form:label class = "col-md-3" for="password" path="password">Password: </form:label>
							<form:input class = "col-md-4" path="password" type="text"/>
							
						</div>
						<div class="row">
							<form:label class = "col-md-3" for="confirmPassword" path="confirmPassword">Confirm Password: </form:label>
							<form:input class = "col-md-4" path="confirmPassword" type="text"/>	
						</div>
						<div>
							<button class="custom-btn">Submit</button>
						</div>
					</form:form>
				</div>
			</section>
			<section>	
				<div class="feedback">
					<div class="row1">
						<div class="col1">
							<img src="<c:url value='/css/Personav1.png' />" alt="personav1-image" class="persona">
								<div class="persona-text">
									<h5>Love Notary Express!</h5>
									<p class="p1">"Thank you Notary Express for the quick and efficient service!"  -  Hannah Collins</p>
								</div>
						</div>
						<div class="col1">
							<img src="<c:url value='/css/Personav2.png' />" alt="personav2-image" class="persona">
							<div class="persona-text">
								<h5>Happy with the Service!</h5>
								<p class="p1">"They met me at work on my lunch break!  It was quick and easy."  - Stacey Aktin</p>
							</div>
						</div>
					</div>
					<div class="row1">
						<div class="col1">
							<img src="<c:url value='/css/Personav3.png' />" alt="personav3-image" class="persona">
							<div class="persona-text">
								<h5>So quick!</h5>
								<p class="p1">"I thought it would take hours, but the notary was done in under an hour!"  - Matthew Carey</p>
							</div>
						</div>
						<div class="col1">
							<img src="<c:url value='/css/Personav4.png' />" alt="personav4-image" class="persona">
							<div class="persona-text">
								<h5>Will use again!</h5>
								<p class="p1">"Great prices and great service!  I will be calling again."  -Taylor Raymond</p>
								
							</div>
						</div>
					</div>
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