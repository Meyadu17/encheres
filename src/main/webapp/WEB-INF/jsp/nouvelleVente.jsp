<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NouvelleVente</title>
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/commun.css">
<link rel="icon" href="img/favicon.ico" />


  <jsp:include page="entete.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>
				Nouvelle Vente :
			</h1>
			<form:form cssClass="form-horizontal" modelAttribute="articleVendu" method="POST" action="valider-nouvelleVente">
                <div class="form-group">
					<form:label path="nomArticle" cssClass="col-xs-2 control-label">
						Article :
					</form:label>
					<div class="col-xs-10">
						<form:input path="nom" cssClass="form-control" />
						<form:errors path="nom"></form:errors>
					</div>
				</div>
                <div class="form-group">
					<form:label path="description" cssClass="col-xs-2 control-label">
						Description : :
					</form:label>
					<div class="col-xs-10">
						<form:input path="description" cssClass="form-control" />
						<form:errors path="description"></form:errors>
					</div>
				</div>
				<div class="col-12">
						Catégorie :
				<div class="form-group">
				    <form:select path="categorie" multiple="false" class="form-control">
				        <form:option value="" label="--- Select ---" />
				        <form:options items="${categories}"  />
				    </form:select>
				</div>
				</div>
				<div class="form-group">
					<form:label path="prixVente" cssClass="col-xs-2 control-label">
						Mise à prix :
					</form:label>
					<div class="col-xs-10">
						<form:input path="prixVente" cssClass="form-control" />
						<form:errors path="prixVente"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<form:label path="debutEncheres" cssClass="col-xs-2 control-label">
						Début de l enchère
					</form:label>
					<div class="col-xs-10">
						<form:input type="text" path="debutEncheres" cssClass="form-control" />
						<form:errors path="debutEncheres"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<form:label path="finEncheres" cssClass="col-xs-2 control-label">
						Fin de l enchère
					</form:label>
					<div class="col-xs-10">
						<form:input type="text" path="finEncheres" cssClass="form-control" />
						<form:errors path="finEncheres"></form:errors>
					</div>
				</div>
				<fieldset>
 					<legend>Retrait</legend>
	 					<div class="form-group">
								Rue :
							<form:input type="text" path="retrait.rue" cssClass="form-control" />
						</div>
						<div class="form-group">
								Code Postal :
							<form:input type="text" path="retrait.codePostal" cssClass="form-control" />
						</div>
						<div class="form-group">
								Ville :
							<form:input type="text" path="retrait.ville" cssClass="form-control" />
						</div>
 				</fieldset>
                <div class="form-group">
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Enregistrer
						</button>
						<button type="reset" class="btn btn-primary">Annuler
						</button>
					</div>
				</div>
       </form:form>
	</div>
	</div>
	<jsp:include page="footer.jsp" />
</html>