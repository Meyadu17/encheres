<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Connexion</title>
    </head>

    <body>
        <div class="container">
            <div class="jumbotron">
                <jsp:include page="entete.jsp"/>
                <h1>
                    Afficher le profile
                </h1>

                <form:form cssClass="form-horizontal" modelAttribute="userInSession" method="GET" action="informationUtilisateur">



                </form:form>
            </div>
        </div>
    </body>



	<jsp:include page="footer.jsp" />
</html>