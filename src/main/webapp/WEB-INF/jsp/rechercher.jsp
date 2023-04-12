<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
   <div class="container">
		<div class="jumbotron">
			<div class="row align-items-cente">
			recherche par caracteres
			<h3>Articles : </h3>
			<h3>${articlesParNom }</h3>
			</div>
		</div>
	</div>
</body>
	<jsp:include page="footer.jsp" />
</html>