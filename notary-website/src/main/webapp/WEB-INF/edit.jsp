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
						<li><a href="#">About</a></li>
						<li><a href="#">Feedback</a></li>
						<li><a href="/admin">Admin</a></li>
					</ul>
				</div>
			</section>
			<section>
				<div>
					<h3>Edit An Appointment</h3>
					<section>
						<div class="page">
							<form:form action="/admin/edit/${order.id}" method="post" modelAttribute="orderForm">
								<input type="hidden" name="_method" value="put">
								<form:input type="hidden" path="user" value= "${userId}" />
								<form:errors path="*" type="text"/>		
								
								<h6>Customer Information</h6>
								<section class="customer-info">
									
									<div class="row">
										<div class="col-md-5">
											<form:label class="title" for="firstName" path="firstName">First Name: </form:label>
											<form:input class="field" path="firstName" value="${order.firstName}" type="text"/>	
										</div>
										<div class="col-md-5">
											<form:label class="title" for="lastName" path="lastName">Last Name: </form:label>
											<form:input class="field" path="lastName" value="${order.lastName}" type="text"/>	
										</div>
									</div>
									<div class="row">
										<div class="col-md-5">
											<form:label class="title" for="address" path="address">Street Address: </form:label>
											<form:input class="field" path="address" value="${order.address}" type="text"/>	
										</div>
										<div class="col-md-5">
											<form:label class="title" for="unit" path="unit">Unit: </form:label>
											<form:input class="field" path="unit" value="${order.unit}" type="text"/>	
										</div>
									</div>
									<div class="row">
										<div class="col-md-5">
											<form:label class="title" for="city" path="city">City: </form:label>
											<form:input class="field" path="city" value="${order.city}" type="text"/>	
										</div>
										<div class="col-md-5">
											<form:label class="title" for="zip" path="zip">Zip Code: </form:label>
											<form:input class="field" path="zip" value="${order.zip}" type="text"/>	
										</div>
									</div>
								</section>
								<h6>Document Information</h6>
								<section class="document-info">
									
									<div class="row">
										<div class="col">
											<form:label class="title1" for="type" path="type">Type: </form:label>
											<form:select class="field1" name="type" path="type" value="${order.type}"> 
												<option value="Choose From List">Choose From List</option>
												<option value="Acknowledgments A.R.S. § 41-251(1)">Acknowledgments A.R.S. § 41-251(1)</option>
												<option value="Verification on Oath (Jurat) A.R.S. § 41– 251 (16)">Verification on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
												<option value="VAffirmation on Oath (Jurat) A.R.S. § 41– 251 (16)">Affirmation on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
												<option value="Oaths or Affirmations A.R.S. § 41-251(6)(b)">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
												<option value="Certifications A.R.S. § 41-253(D)">Certifications A.R.S. § 41-253(D)</option>
											</form:select>	
										</div>
										<div class="col">
											<form:label class="title2" for="name" path="name">Name: </form:label>
											<form:input class="field2" path="name" value="${order.name}" type="text"/>
										</div>
										<div class="col">
											<form:label class="title3" for="pages" path="pages"># Pages: </form:label>
											<form:input class="field3" path="pages" value="${order.pages}" type="text"/>	
										</div>
									</div>
									<div class="row">
										<div class="col">
											<form:label class="title1" for="typeTwo" path="typeTwo">Type: </form:label>
											<form:select class="field1" name="typeTwo" value="${order.typeTwo}"  path="typeTwo">
												<option value="Choose From List">Choose From List</option>
												<option value="Acknowledgments A.R.S. § 41-251(1)">Acknowledgments A.R.S. § 41-251(1)</option>
												<option value="Verification on Oath (Jurat) A.R.S. § 41– 251 (16)">Verification on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
												<option value="VAffirmation on Oath (Jurat) A.R.S. § 41– 251 (16)">Affirmation on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
												<option value="Oaths or Affirmations A.R.S. § 41-251(6)(b)">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
												<option value="Certifications A.R.S. § 41-253(D)">Certifications A.R.S. § 41-253(D)</option>
											</form:select>	
										</div>
										<div class="col">
											<form:label class="title2" for="nameTwo" path="nameTwo">Name: </form:label>
											<form:input class="field2" path="nameTwo" value="${order.nameTwo}" type="text"/>
										</div>
										<div class="col">
											<form:label class="title3" for="pagesTwo" path="pagesTwo"># Pages: </form:label>
											<form:input class="field3" path="pagesTwo" value="${order.pagesTwo}" type="text"/>	
										</div>
									</div>
									<div class="row">
										<div class="col">
											<form:label class="title1" for="typeThree" path="typeThree">Type: </form:label>
											<form:select class="field1" name="typeThree" value="${order.typeThree}" path="typeThree">
												<option value="Choose From List">Choose From List</option>
												<option value="Acknowledgments A.R.S. § 41-251(1)">Acknowledgments A.R.S. § 41-251(1)</option>
												<option value="Verification on Oath (Jurat) A.R.S. § 41– 251 (16)">Verification on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
												<option value="VAffirmation on Oath (Jurat) A.R.S. § 41– 251 (16)">Affirmation on Oath (Jurat) A.R.S. § 41– 251 (16)</option>
												<option value="Oaths or Affirmations A.R.S. § 41-251(6)(b)">Oaths or Affirmations A.R.S. § 41-251(6)(b)</option>
												<option value="Certifications A.R.S. § 41-253(D)">Certifications A.R.S. § 41-253(D)</option>
											</form:select>	
										</div>
										<div class="col">
											<form:label class="title2" for="nameThree" path="nameThree">Name: </form:label>
											<form:input class="field2" path="nameThree" value="${order.nameThree}" type="text"/>
										</div>
										<div class="col">
											<form:label class="title3" for="pagesThree" path="pagesThree"># Pages: </form:label>
											<form:input class="field3" path="pagesThree" value="${order.pagesThree}" type="text"/>	
										</div>
									</div>
								</section>
								
								<h6>Date and Time Selection</h6>
								<section class="appointment-selection">
									
									<div class="row">
										<div class="col">
											<form:label class="appt" for="appointment" path="appointment">Preferred Date (MM-DD-YYYY): </form:label>
											<form:input class="appt-input" path="appointment" value="${order.appointment}" type="text"/>	
										</div>
										<div class="col">
											<form:label class="appt" for="timing" path="timing">Preferred Time: </form:label>
											<form:select class="appt-input" name="timing" value="${order.timing}" path="timing">
												<option value="Choose From List">Choose From List</option>
												<option value="08:00AM - 12:00PM">08:00AM - 12:00PM</option>
												<option value="10:00AM - 02:00PM">10:00AM - 02:00PM</option>
												<option value="12:00PM - 05:00PM">12:00PM - 05:00PM</option>
												<option value="05:00PM - 09:00PM">05:00PM - 09:00PM</option>
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
				</div>
			</section>
		</div>
	</body>
</html>