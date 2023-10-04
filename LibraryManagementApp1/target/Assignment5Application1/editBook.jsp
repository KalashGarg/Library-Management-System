<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.nagarro.dto.Book" %>
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
                <span><a href="Logout"><button style="border-radius:7px;">Logout</button></a></span>
           </div>
    </nav>
    <div class="row mt-4">
		<div class="col-11"
			style="text-align: center; margin: 0 auto;">
			<h2>Edit book details</h2>
		</div>
	</div>
	<div class="container-fluid col-md-5 p-3" style="border:2px solid black; border-radius:14px">
        <form action="editBooks" method="post">
            <div class="mb-3 mx-3">
                <label for="bookcode" class="form-label">Book Code</label>
                <input type="text" class="form-control" name="bookcode"
                id="bookcode" readonly="readonly" value="${book.getBookCode()}">
            </div>
            <div class="mb-3 mx-3">
                <label for="bookname" class="form-label">Book Name</label>
                <input type="text" class="form-control" name="bookname"
                    id="bookname" value="${book.getBookName()}">
            </div>
            <div class="mb-3 mx-3">
                <label for="author" class="col-12 col-lg-3">Author</label>
                  <select class="col-12 col-lg-3" name="author" id="author" required>
                    <c:set var="val1" value="${book.getAuthor()}"/>
                    <option value="val1" selected>${book.getAuthor()}</option>
                     <c:forEach items="${authors}" var="author">
                     <c:set var="val2" value="${author.getName()}"/>
                     <c:if test="${val1 != val2}">
                     <option value="${author.getName()}">${author.getName()}</option>
                     </c:if>
                     </c:forEach>
                </select>
            </div>
            <div class="mb-3 mx-3">
                <label for="added" class="form-label col-12 col-lg-3">Added On</label>
                <input id="added" class="col-12 col-lg-3" readonly="readonly" name="added" value="${book.getDate()}"/>
            </div>
            <div class="mx-5">
                <input type="submit" class="btn btn-primary" value="Submit" />
                <a href="LogIn"><input type="button" class="btn btn-primary" value="Back"/></a>
            </div>
        </form>
    </div>
</body>
</html>