<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "ust.greet.listener.UserHttpSessionListenerCount"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UST Greetings</title>

<link rel="stylesheet" type="text/css" href="css/tether.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container pt-5">
		<h2>Purchase Results</h2>
		
		<%
			getServletContext().log("Displaying the results...");
		%>
		
		<div class="alert alert-success" role="alert">
		  <h4>Credit card number ${user.cardNum} successfully charged.</h4>
		</div>
		
		<div class="form-group row">
			<div class="col-2"><label class="col-form-label">Customer First Name</label></div>
			<div class="col-4">
				<input type="text" value='${user.fName}' class="form-control" disabled >
			</div>
			
			<div class="col-2"><label class="col-form-label">Customer Last Name</label></div>
			<div class="col-4">
				<input type="text" value='${user.lName}' class="form-control" disabled >
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-2"><label class="col-form-label">Fuel Type</label></div>
			<div class="col-10">
				<input type="text" value='${user.gasType}' class="form-control" disabled>
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-2"><label class="col-form-label">Payment Type</label></div>
			<div class="col-10">
				<input type="text" value='${user.paymentType}' class="form-control" disabled>
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-2"><label class="col-form-label">Price per Liter</label></div>
			<div class="col-1">
				<input type="text" value='${user.basePrice}' class="form-control" disabled >
			</div>
			
			<div class="col-1"><label class="col-form-label">Purchase Amount</label></div>
			<div class="col-2">
				<input type="text" value='${user.purchaseAmt}' class="form-control" disabled >
			</div>
			
			<div class="col-1"><label class="col-form-label">VAT Amount</label></div>
			<div class="col-2">
				<input type="text" value='${user.vatAmt}' class="form-control" disabled >
			</div>
			
			<div class="col-1"><label class="col-form-label">Total Amount</label></div>
			<div class="col-2">
				<input type="text" value='${user.totalAmt}' class="form-control" disabled >
			</div>
		</div>
		 
		<p>
			<form action='index.jsp'>
				<input type='submit' value='<< GO BACK >>' class="btn btn-primary">
			</form>
			
			<form action='audit.jsp'>
				<input type='submit' value='<< GO to audits >>' class="btn btn-primary">
			</form>
		</p>
		
		
		
		<script src="css/jquery-3.3.1.min.js"></script>
		<script src="css/bootstrap.bundle.js"></script>
		<script src="css/bootstrap.bundle.min.js"></script>
	</div>
</body>
</html>