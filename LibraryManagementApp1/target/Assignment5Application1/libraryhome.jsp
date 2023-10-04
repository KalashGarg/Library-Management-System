<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List" %>
<%@page import="com.nagarro.dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library-HomePage</title>
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
			<h2>Book Listing</h2>
		</div>
		<div class="col-1">
			<a href="add"><button type="submit"
					class="btn btn-primary btn-sm">Add Book</button></a>
		</div>
	</div>
	
	<table class="table table-striped table-bordered mt-5 result">
				<tr>
					<th>Book Code</th>
					<th>Book Name</th>
					<th>Author</th>
					<th>Date Added</th>
					<th>Actions</th>
				</tr>
                <c:forEach items="${books}" var="b">
                <tr>
                    <td>${b.getBookCode()}</td>
                    <td>${b.getBookName()}</td>
                    <td>${b.getAuthor()}</td>
                    <td>${b.getDate()}</td>
                    <td><a href="edit?id=${b.getBookCode()}" class="btn btn-warning" role="button">Edit</a>
                        <a href="delete?id=${b.getBookCode()}" class="btn btn-danger" role="button">Delete</a>
                    </td>
                </tr>
                </c:forEach>
	</table>
</body>
</html>