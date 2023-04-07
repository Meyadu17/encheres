<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Accueil</title>
        <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap-theme.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
         <link href="css/commun.css" rel="stylesheet"/>
         <link rel="icon" href="img/favicon.ico" />
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <jsp:include page="entete.jsp"/>
                <h1>Liste des enchères</h1>
                <form method="post" action="#">
                    <label for="filtre">Filtres:<input type="text"/></label>
                    <label for="categorie">
                        <select name="categorie">
                            <option value="">Toutes</option>
                            <option value="mobilier">mobilier</option>
                            <option value="electromenager">électroménager</option>
                            <option value="musique">musique</option>
                        </select>
                    </label>
                    <label for="achat"> Achats :<input type="radio" name="achat"/> </label>
                    <label for="enchere ouvertes"> enchères ouvertes<input type="checkbox" name="eouverte"></label>
                    <label for="enchere cours"> enchères en cours <input type="checkbox" name="eencours"></label>
                    <label for="enchere remportees"> enchères remportées <input type="checkbox" name="eremportees"></label>
                    <label for="vente"> Mes ventes : <input type="radio" name="achat"> </label>
                    <label for="vente cours"> Mes ventes en cours <input type="checkbox" name="vencours"></label>
                    <label for="vente non debutees">Mes ventes non débutées<input type="checkbox" name="vnondebutees"></label>
                    <label for="vente terminées"> Mes ventes terminées <input type="checkbox" name="vterminees"></label>
                    <input type="submit" value="Rechercher">
                </form>
                <table>
                    <tr><td>titre article1</td><td>titre article2</td></tr>
                    <tr><td>prix article1</td><td>prix article2</td></tr>
                    <tr><td>image article1</td><td>image article2</td></tr>
                    <tr><td>fin enchère article1</td><td>fin enchère article2</td></tr>
                    <tr><td>vendeur article1</td><td>vendeur article2</td></tr>
                <table>
            </div>
        </div>
    </body>

	<jsp:include page="footer.jsp" />
</html