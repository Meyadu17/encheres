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
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-collapse collapse" id="navbar-main">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="i18n?lg=fr">Français</a></li>
                        <li><a href="i18n?lg=en">English</a></li>
                        <li><a href="welcome">Accueil</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron">
                <h1>
                    <spring:message code="login.title" />
                </h1>

                <h2>${error}</h2>

                <form:form cssClass="form-horizontal" modelAttribute="userInSession" method="POST" action="connexion">
                    <div class="form-group">
                        <form:label path="email" cssClass="col-xs-2 control-label">
                            <spring:message code="login.login" />
                        </form:label>
                        <div class="col-xs-10">
                            <form:input path="email" cssClass="form-control" />
                            <form:errors path="email"></form:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="motDePasse" cssClass="col-xs-2 control-label">
                            <spring:message code="login.pwd" />
                        </form:label>
                        <div class="col-xs-10">
                            <form:password path="motDePasse" cssClass="form-control" />
                            <form:errors path="motDePasse"></form:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="submit" class="btn btn-primary">
                                <spring:message code="login.connection" />
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>



	<jsp:include page="footer.jsp" />
</html>