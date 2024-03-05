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
				<div class="page">
					<h1 class="welcome-text">Welcome to Notary Express, <c:out value="${username}"></c:out>!</h1>
					<p class="welcome-text2">Please tell us how we can assist you today by filling out the below form.  Thank you!</p>
				</div>
			</section>
			<section>
				<div class="page">
					<form:form action="/orders" method="post" modelAttribute="order">
						<form:input type="hidden" path="user" value= "${userId}" />
						<form:errors path="*" type="text"/>		
						
						<h6>Customer Information</h6>
						<section class="customer-info">
							
							<div class="row">
								<div class="col-md-5">
									<form:label class="title" for="firstName" path="firstName">First Name: </form:label>
									<form:input class="field" path="firstName" type="text"/>	
								</div>
								<div class="col-md-5">
									<form:label class="title" for="lastName" path="lastName">Last Name: </form:label>
									<form:input class="field" path="lastName" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col-md-5">
									<form:label class="title" for="address" path="address">Street Address: </form:label>
									<form:input class="field" path="address" type="text"/>	
								</div>
								<div class="col-md-5">
									<form:label class="title" for="unit" path="unit">Unit: </form:label>
									<form:input class="field" path="unit" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col-md-5">
									<form:label class="title" for="city" path="city">City: </form:label>
									<form:input class="field" path="city" type="text"/>	
								</div>
								<div class="col-md-5">
									<form:label class="title" for="zip" path="zip">Zip Code: </form:label>
									<form:input class="field" path="zip" type="text"/>	
								</div>
							</div>
						</section>
						<h6>Document Information</h6>
						<section class="document-info">
							
							<div class="row">
								<div class="col">
									<form:label class="title1" for="type" path="type">Type: </form:label>
									<form:select class="field1" name="type" path="type">
										<option value="into">Choose From List</option>
										<option value="acknowledgments">Acknowledgments A.R.S. § 41-251(1)</option>
										<option value="verification">Verification on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="affirmation">Affirmation on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="oaths">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
										<option value="certification">Certifications A.R.S. § 41-253(D)</option>
									</form:select>	
								</div>
								<div class="col">
									<form:label class="title2" for="name" path="name">Name: </form:label>
									<form:input class="field2" path="name" type="text"/>
								</div>
								<div class="col">
									<form:label class="title3" for="pages" path="pages"># Pages: </form:label>
									<form:input class="field3" path="pages" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form:label class="title1" for="typeTwo" path="typeTwo">Type: </form:label>
									<form:select class="field1" name="typeTwo" path="typeTwo">
										<option value="into">Choose From List</option>
										<option value="acknowledgments">Acknowledgments A.R.S. § 41-251(1)</option>
										<option value="verification">Verification on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="affirmation">Affirmation on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="oaths">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
										<option value="certification">Certifications A.R.S. § 41-253(D)</option>
									</form:select>	
								</div>
								<div class="col">
									<form:label class="title2" for="nameTwo" path="nameTwo">Name: </form:label>
									<form:input class="field2" path="nameTwo" type="text"/>
								</div>
								<div class="col">
									<form:label class="title3" for="pagesTwo" path="pagesTwo"># Pages: </form:label>
									<form:input class="field3" path="pagesTwo" type="text"/>	
								</div>
							</div>
							<div class="row">
								<div class="col">
									<form:label class="title1" for="typeThree" path="typeThree">Type: </form:label>
									<form:select class="field1" name="typeThree" path="typeThree">
										<option value="into">Choose From List</option>
										<option value="acknowledgments">Acknowledgments A.R.S. § 41-251(1)</option>
										<option value="verification">Verification on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="affirmation">Affirmation on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
										<option value="oaths">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
										<option value="certification">Certifications A.R.S. § 41-253(D)</option>
									</form:select>	
								</div>
								<div class="col">
									<form:label class="title2" for="nameThree" path="nameThree">Name: </form:label>
									<form:input class="field2" path="nameThree" type="text"/>
								</div>
								<div class="col">
									<form:label class="title3" for="pagesThree" path="pagesThree"># Pages: </form:label>
									<form:input class="field3" path="pagesThree" type="text"/>	
								</div>
							</div>
						</section>
						
						<h6>Date and Time Selection</h6>
						<section class="appointment-selection">
							
							<div class="row">
								<div class="col">
									<form:label class="appt" for="appointment" path="appointment">Preferred Date: </form:label>
									<form:input class="appt-input" path="appointment" type="text"/>	
								</div>
								<div class="col">
									<form:label class="appt" for="timing" path="timing">Preferred Time: </form:label>
									<form:select class="appt-input" name="timing" path="timing">
										<option value="timeslot">Choose From List</option>
										<option value="am">08:00AM - 12:00PM</option>
										<option value="mid">10:00AM - 02:00PM</option>
										<option value="pm">12:00PM - 05:00PM</option>
										<option value="late-pm">05:00PM - 09:00PM</option>
									</form:select>	
								</div>
							</div>
						</section>
						<div>
							<button class="submit">Submit</button>
						</div>	
					</form:form>
				</div>
		</section>
		<section>
			<div class="footer">
				<p class="footer-text">We are not lawyers, and don’t give legal advice, so always check with your own attorneys, advisors, or document recipients if you have unanswered questions about notarization or digitally notarized documents.</p>
			</div>
		</section>
	</body>
</html>