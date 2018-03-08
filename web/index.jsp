<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<link rel="stylesheet" type="text/css" href="css/tether.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script src="js/modernizr.js"></script> <!-- Modernizr -->

	<title>PEARLY</title>
</head>
<body background="gasss.jpg">
	<nav id="cd-vertical-nav">
		<ul>
			<li>
				<a href="#section1" data-number="1">
					<span class="cd-dot"></span>
					<span class="cd-label">Pearly</span>
				</a>
			</li>
			<li>
				<a href="#section2" data-number="2">
					<span class="cd-dot"></span>
					<span class="cd-label">Order Now</span>
				</a>
			</li>
			<li>
				<a href="#section3" data-number="3">
					<span class="cd-dot"></span>
					<span class="cd-label">CONTACT</span>
				</a>
			</li>
		</ul>
	</nav>
	<a class="cd-nav-trigger cd-img-replace">Open navigation<span></span></a>

	<section id="section1" class="cd-section s1bg" >
    <h1>We are <b> THE PEARLS TO YOUR SHELL </b></h1>
    <br><br><br><br><br><br><br><br><div align="center"><img src="logo.png" class="img-responsive logo">
		<a href="#section2" class="cd-scroll-down cd-img-replace">scroll down</a></div>
	</section><!-- cd-section -->

	<section id="section2" class="cd-section" style="padding-top: 10%">
		
	
		<div class="container">
		<div class="header"><div align="center"><img src="ORDER.png" class="img-responsive w-50"></div>
		<form action="greetuser.action" method="POST">

			<div class="form-group row">
				<label for="fname" class="col-2 col-form-label">First Name</label>
				<div class="col-4">
					<input class="form-control" type="text" id="fname" name="fname" required>
				</div>
				
				<label for="lname" class="col-2 col-form-label">Last Name</label>
				<div class="col-4">
					<input class="form-control" type="text" id="lname" name="lname" required>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="gasType" class="col-2 col-form-label">Gasoline Type</label>
				<div class="col-4">
					<select class="form-control" id="gasType" name="gasType" required>
						<option>Unleaded</option>
						<option>Diesel</option>
						<option>Premium</option>
					</select>
				</div>
				
				<label for="nLiters" class="col-2 col-form-label">Enter
					number of liters</label>
				<div class="col-4">
					<input class="form-control" type="number" id="nLiters"
						name="nLiters" min="1" step="0.01" required>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-2 col-form-label">Payment Type</label>
				<div class="col-4">
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="visa" value="Visa">
					  <label class="form-check-label" for="visa">
					  	<img src="assets/images/visa.jpg" id="visa" class="creditc img-responsive">
				  	  </label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="mastercard" value="Mastercard">
					  <label class="form-check-label" for="mastercard">
					  	<img src="assets/images/mastercard.jpg" id="mastercard" class="creditc img-responsive">
				  	  </label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="amex" value="Amex">
					  <label class="form-check-label" for="amex">
					  	<img src="assets/images/amex.jpg" id="amex" class="creditc img-responsive">
				  	  </label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="diners" value="Diners">
					  <label class="form-check-label" for="diners">
					  	<img src="assets/images/diners.png" id="diners" class="creditc img-responsive">
				  	  </label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="gcash" value="Gcash">
					  <label class="form-check-label" for="gcash">
					  	<img src="assets/images/gcash.jpg" id="gcash" class="creditc img-responsive">
				  	  </label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="paymaya" value="Paymaya">
					  <label class="form-check-label" for="paymaya">
					  	<img src="assets/images/paymaya.png" id="paymaya" class="creditc img-responsive">
				  	  </label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="paymentType" id="jcb" value="Jcb">
					  <label class="form-check-label" for="jcb">
					  	<img src="assets/images/jcb.jpg" id="jcb" class="creditc img-responsive">
				  	  </label>
					</div>
				</div>
				
				<label for="cardNum" class="col-2 col-form-label">Credit Card Number</label>
				<div class="col-4">
					<input class="form-control" type="text" id="cardNum" name="cardNum" pattern="[0-9]{13,16}" maxlength="16" title="Credit card number should only consist of numbers [0-9]"required>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-8"><button type="submit" class="btn btn-block btn-primary">Submit</button></div>
				<div class="col-4"><button type="reset" class="btn btn-block btn-outline-primary">Reset</button></div>
			</div>
			
			
		</form>
	</div>
 		 

 		
	</section><!-- cd-section -->

	<section id="section3" class="cd-section">
		<p>Contact us at 09159123512 because<br>&ldquo;You can never have enough GAS to FUEL your life!&rdquo;</p><br><br><br><br><br><br><br><br><br><br>
		<div align="center"><i>in partnership with:</i><br><img src="gazgaz.png"></div>
	</section><!-- cd-section -->

	
<script src="js/jquery-2.1.1.js"></script>
<script src="js/main.js"></script>
<script src="js/bootstrap.bundle.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
 <!-- Resource jQuery -->
</body>
</html>

