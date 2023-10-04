<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
	<%String cUser=(String)session.getAttribute("user");
        if(cUser!=null){
            session.setAttribute("msg", "Already Login");
            response.sendRedirect("library");
        }
    %>
    <%
    String message = (String) session.getAttribute("msg");
    if (message != null) {
    %>
    <div class="alert alert-info alert-dismissible fade show" role="alert">
    <%=message%>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
    </button>
    </div>
    <%
    session.removeAttribute("msg");
    }%>
	<div class="container-fluid col-md-6 my-5 p-3" style="border:2px solid black;background-color:#e9edc9">
	<h4>Login if existing user</h4>
	<form action="LogIn" method="post">
		<div class="mb-3">
			<label for="userid" class="form-label">UserId</label> 
			<input type="text" class="form-control" name="userid"
				id="userid">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password</label>
			<input type="password" class="form-control" name="pwd"
				id="pwd">
		</div>
		<input type="submit" class="btn btn-primary" value="LogIn" />
		<a href="register.jsp">Create New User?</a>
	</form>
	</div>

</body>
</html>
