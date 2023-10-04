<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
	<!-- Create new user form -->
	<div class="container-fluid col-md-6 my-5 p-3" style="border:2px solid black;background-color:#e9edc9">
	<h4>Register to create new user</h4>
	<form action="SignUp" method="post">
		<div class="mb-3">
			<label for="userid" class="form-label">UserId</label> 
			<input type="text" class="form-control" name="userName"
				id="userName" minlength="5" maxlength="50">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password</label>
			<input type="password" class="form-control" name="pwd"
				id="pwd" minlength="5" maxlength="50">
		</div>
		<input type="submit" class="btn btn-primary" value="Register" />
	</form>
	</div>


</body>
</html>


</body>
</html>
