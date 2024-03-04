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
						<li><a href="/logout">Logout</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Feedback</a></li>
					</ul>
				</div>
			</section>
			<section>
				<div>
					<h1>Welcome to Notary Express, <c:out value="${username}"></c:out>!</h1>
					<p>Please tell us how we can assist you today by filling out the below form.  Thank you!</p>
				</div>
			</section>
			<section>
				<div>
					<form:form action="/orders" method="post" modelAttribute="order">
						<form:input type="hidden" path="user" value= "${userId}" />
						<form:errors path="*" type="text"/>		
						
						<section class="customer-info">
							<h6>Customer Information</h6>
							<div class="row">
								<div class="col">
									<form:label for="firstName" path="firstName">First Name: </form:label>
									<form:input path="firstName" type="text"/>	
								</div>
								<div class="col">
									<form:label for="lastName" path="lastName">Last Name: </form:label>
									<form:input path="lastName" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form:label for="address" path="address">Street Address: </form:label>
									<form:input path="address" type="text"/>	
								</div>
								<div class="col">
									<form:label for="unit" path="unit">Unit: </form:label>
									<form:input path="unit" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form:label for="city" path="city">City: </form:label>
									<form:input path="city" type="text"/>	
								</div>
								<div class="col">
									<form:label for="zip" path="zip">Zip Code: </form:label>
									<form:input path="zip" type="text"/>	
								</div>
							</div>
						</section>
						<section class="document-info">
							<h6>Document Information</h6>
							<div class="row">
								<div class="col">
									<form:label for="type" path="type">Document Type: </form:label>
									<form:select name="type" path="type">
										<option value="acknowledgments">Acknowledgments A.R.S. § 41-251(1)</option>
										<option value="verification">Verification on Oath or Affirmation (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="oaths">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
										<option value="certification">Certifications A.R.S. § 41-253(D)</option>
									</form:select>	
								</div>
								<div class="col">
									<form:label for="name" path="name">Document Name: </form:label>
									<form:input path="pages" type="text"/>
								</div>
								<div class="col">
									<form:label for="pages" path="pages"># of Pages: </form:label>
									<form:input path="pages" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form:label for="type" path="type">Document Type: </form:label>
									<form:select name="type" path="type">
										<option value="acknowledgments">Acknowledgments A.R.S. § 41-251(1)</option>
										<option value="verification">Verification on Oath or Affirmation (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="oaths">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
										<option value="certification">Certifications A.R.S. § 41-253(D)</option>
									</form:select>	
								</div>
								<div class="col">
									<form:label for="name" path="name">Document Name: </form:label>
									<form:input path="pages" type="text"/>
								</div>
								<div class="col">
									<form:label for="pages" path="pages"># of Pages: </form:label>
									<form:input path="pages" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form:label for="type" path="type">Document Type: </form:label>
									<form:select name="type" path="type">
										<option value="acknowledgments">Acknowledgments A.R.S. § 41-251(1)</option>
										<option value="verification">Verification on Oath or Affirmation (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="oaths">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
										<option value="certification">Certifications A.R.S. § 41-253(D)</option>
									</form:select>	
								</div>
								<div class="col">
									<form:label for="name" path="name">Document Name: </form:label>
									<form:input path="pages" type="text"/>
								</div>
								<div class="col">
									<form:label for="pages" path="pages"># of Pages: </form:label>
									<form:input path="pages" type="text"/>	
								</div>
							</div>
						</section>
						<section class="appointment-selection">
							<h6>Date and Time Selection</h6>
							<div class="row">
								<div class="col">
									<form:label for="appointmentDay" path="appointmentDay">Appointment Day: </form:label>
									<form:input path="appointmentDay" type="date"/>	
								</div>
								<div class="col">
									<form:label for="appointmentTime" path="appointmentTime">Appointment Time: </form:label>
									<form:input path="appointmentTime" type="time"/>	
								</div>
							</div>
						</section>
						<div>
							<button class="save">Submit</button>
						</div>	
					</form:form>
				</div>
		</section>
	</body>
</html>