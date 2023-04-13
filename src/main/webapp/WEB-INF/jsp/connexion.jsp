<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <jsp:include page="entete.jsp"/>
        <div class="container">
            <div class="jumbotron">
                <h1><spring:message code="login.title" /></h1>
                 <h2>${error}</h2>
            </div>
        </div>
        <div class="container">
            <div class="jumbotron">
                <form:form cssClass="form-horizontal" modelAttribute="userInSession" method="POST" action="validerConnexion">
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
                            <button type="submit" class="btn btn-primary"><spring:message code="login.connection" /></button>
                            <button type="submit" class="btn btn-primary"><a style="color:white" href="creation_profil"><spring:message code="login.create" /></a></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
	<jsp:include page="footer.jsp" />
</html>