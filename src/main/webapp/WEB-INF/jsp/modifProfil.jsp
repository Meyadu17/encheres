<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <jsp:include page="entete.jsp"/>
        <div class="container">
            <div class="jumbotron">
                <h1 class="text-center">Mon Profil</h1>
            </div>
        </div>
        <div class="container">
            <div class="jumbotron">
                <form:form cssClass="form-horizontal" modelAttribute="userInSession" method="POST" action="valider-modification-profil">
                    <div class="form-group">
                        <form:label path="pseudo" cssClass="col-xs-2 control-label">Pseudo</form:label>
                        <div class="col-xs-10">
                            <form:input path="pseudo" cssClass="form-control" />
                            <form:errors path="pseudo"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="nom" cssClass="col-xs-2 control-label">Nom</form:label>
                        <div class="col-xs-10">
                            <form:input path="nom" cssClass="form-control" />
                            <form:errors path="nom"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="prenom" cssClass="col-xs-2 control-label">Prénom</form:label>
                        <div class="col-xs-10">
                            <form:input path="prenom" cssClass="form-control" />
                            <form:errors path="prenom"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="email" cssClass="col-xs-2 control-label">Email</form:label>
                        <div class="col-xs-10">
                            <form:input path="email" cssClass="form-control" />
                            <form:errors path="email"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="telephone" cssClass="col-xs-2 control-label">Téléphone</form:label>
                        <div class="col-xs-10">
                            <form:input path="telephone" cssClass="form-control" />
                            <form:errors path="telephone"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="rue" cssClass="col-xs-2 control-label">Rue</form:label>
                        <div class="col-xs-10">
                            <form:input path="rue" cssClass="form-control" />
                            <form:errors path="rue"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="codePostal" cssClass="col-xs-2 control-label">Code Postal</form:label>
                        <div class="col-xs-10">
                            <form:input path="codePostal" cssClass="form-control" />
                            <form:errors path="codePostal"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="ville" cssClass="col-xs-2 control-label">Ville</form:label>
                        <div class="col-xs-10">
                            <form:input path="ville" cssClass="form-control" />
                            <form:errors path="ville"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="motDePasse" cssClass="col-xs-2 control-label"> Mot de passe</form:label>
                        <div class="col-xs-10">
                            <form:password path="motDePasse" cssClass="form-control" />
                            <form:errors path="motDePasse"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <form:button type="submit" class="btn btn-primary">Enregistrer</form:button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
	<jsp:include page="footer.jsp" />
</html>