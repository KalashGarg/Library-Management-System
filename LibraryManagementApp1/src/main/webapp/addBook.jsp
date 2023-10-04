<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List" %>
<%@page import="com.ducs.dto.Author" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
    <%String cUser=(String)session.getAttribute("user");
        if(cUser==null){
            response.sendRedirect("LogIn");
        }
        %>
	<nav class="navbar">
			<div class="container-fluid justify-content-center">
                <h2 >Library Management System</h2>
            </div >
            <div class="container-fluid justify-content-end" style="margin-top:-35px;">
            	<span class="m-2"><b>Hi <%=cUser%></b></span>
                <span><a href="LogOut"><button style="border-radius:7px;">Logout</button></a></span>
           </div>
    </nav>
    <div class="row mt-4">
		<div class="col-11"
			style="text-align: center; margin: 0 auto;">
			<h2>Add book details</h2>
		</div>
	</div>
	<div class="container-fluid col-md-5 p-3" style="border:2px solid black; border-radius:14px">
        <form action="addBooks" method="post">
            <div class="mb-3 mx-3">
                <label for="bookcode" class="form-label">Book Code</label>
                <input type="number" class="form-control" name="bookcode" id="bookcode" required="required">
            </div>
            <div class="mb-3 mx-3">
                <label for="bookname" class="form-label">Book Name</label>
                <input type="text" class="form-control" name="bookname" id="bookname" required="required">
            </div>
            <div class="mb-3 mx-3">
                <label for="author" class="col-12 col-lg-3">Author</label>
                  <select class="col-12 col-lg-3" name="author" id="author" required>
                    <c:forEach items="${authors}" var="author">
                    <option value="${author.getName()}">${author.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3 mx-3">
                <label for="added" class="form-label col-12 col-lg-3">Added On</label>
                <input id="added" class="col-12 col-lg-3" readonly="readonly" name="added"
                    value=<%long millis = System.currentTimeMillis();
                    String date = new java.sql.Date(millis) + "";%>
                    <%=date%> />
            </div>
            <div class="mx-5">
                <input type="submit" class="btn btn-primary" value="Submit" />
                <input type="reset" class="btn btn-primary" value="Clear" />
            </div>
        </form>
    </div>
</body>
</html>