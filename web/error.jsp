<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pearly Error Page</title>
<link rel="stylesheet" href="css/style.css"> 

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"><!-- Resource style -->
</head>
<body background="bbg.gif">
	
	<br><br><br><br><br><br>
	<div class="center">
	<center><h2><font color="red">SOMETHING WENT WRONG</font></h2></center>
	<center><h5><%= session.getAttribute("message") %></h5></center>
	<p>Please view your Tomcat logs and check what causes the error.</p>
	<p>As a graduating IT student, your should <i><b>learn</b></i> how to read logs in the Tomcat console. 
		Check which user-defined class generates the exception error. DO NOT feel helpless like a freshman
		seeing a very first exception error.</p>
		<form action='index.jsp'>
			<button type="submit" class="btn btn-block btn-outline-danger"><< GO BACK & TRY AGAIN >></button>
		</form>
		</div>
		

</body>
</html>