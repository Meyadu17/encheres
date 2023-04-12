<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <link rel="stylesheet" href="css/commun.css">
        <link rel="icon" href="img/favicon.ico"/>
        <title> Nouvelle vente </title>
    </head>
    <body>
         <div class="container">
            <div class="jumbotron">
                <div class="left">
                    <img src="#" rel="image de l'article à vendre"/>
                </div>
                <div class="right">
                    <h1>Nouvelle vente</h1>
                    <form:form method="post" action="#">
                        <form:label path="article">Article :</form:label>
                        <form:input path="article"/>
                        <form:label path="description"> Description : </form:label>
                        <form:textarea path="description"/>
                        <form:label path="libelle">Catégorie :</form:label>
                            <form:select path="libelle">
                                <form:option value="">vide</form:option>
                                <form:option value="mobilier">mobilier</form:option>
                                <form:option value="electromenager">électroménager</form:option>
                                <form:option value="musique">musique</form:option>
                            </form:select>
                        <form:label path="photo_article">Photo de l article:</form:label>
                            <form:button> UPLOADER </form:button>
                        <form:label path="prixInitial"> Mise à prix:  </form:label>
                            <input path="prixInitiale"/>
                        <form:label path="debutEnchere"> Début de l enchère:  </form:label>
                             <form:input path="debutEnchere"/>
                        <form:label path="finEnchere"> Fin de l enchère  </form:label>
                             <form:input path="finEnchere"/>
                       <h1>Retrait</h1>
                        <form:label path="rue">  Rue: </form:label>
                            <form:input path="rue"/>
                        <form:label path="codePostal"> Code postal: </form:label>
                        <form:input path="codePostal"/>
                        <form:label path="Ville"> Ville:  </form:label>
                            <input path="ville"/>

                       <form:button type="submit" value="Envoyer"/>
                    </form:form>
                    <form:button>Annuler</form:button>
                </div>
            </div>
        </div>
    </body>
</html>