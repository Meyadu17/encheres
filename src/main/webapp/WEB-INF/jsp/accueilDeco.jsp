<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <jsp:include page="entete.jsp"/>
        <div class="container">
            <div class="jumbotron">
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