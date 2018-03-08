<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "ust.greet.listener.UserHttpSessionListenerCount"
    import = "ust.greet.utility.Security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Audits</title>

<link rel="stylesheet" type="text/css" href="css/tether.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container pt-5">
		
		<%
			getServletContext().log("Displaying audit logs...");
		%>
		
		${user.event}
		
	</div>
</body>
</html>