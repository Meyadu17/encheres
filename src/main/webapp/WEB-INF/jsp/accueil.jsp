<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <jsp:include page="entete.jsp"/>
        <div class="container">
            <div class="jumbotron">
                    <h2 class="text-center">Enchères en cours</h2>
            </div>
        </div>

        <div class="container">
            <div class="jumbotron">
                <!--Filtre de recherche-->

                <div class="col col-md-6 text-center mx-auto text-center d-flex flex-row">
                    <form class="form-inline" method="GET" action="filterArticle" modelAttribute="filterArticle">
                        <!-- Barre de recherche-->
                        <label for="filterArticle">Nom de l'article :</label>
                        <input class="form-control mr-sm-2" type="search" placeholder="Rechercher par nom" name="filterArticle" aria-label="Search" id="filterArticle" th:value="${filterArticle}">
                          <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Filtrer Nom"></input>
                    </form><br>
                    <form class="form-inline" method="GET" action="filterCategorie" modelAttribute="filterCategorie">
                        <!--Menu catégorie-->
                        <div>
                            <p class="d-flex flex-row">
                                <label for="categories">Catégorie :</label>
                                <select name="categorie" id="categories">
                                    <option value="all">Toutes</option>
                                    <c:forEach items="${categories}" var="categorie">
                                        <c:choose>
                                            <c:when test="${categorieFilter != 'all'}">
                                                <c:choose>
                                                    <%--@elvariable id="categorieFilter" type="java.lang.String"--%>
                                                    <c:when test="${categorieFilter == categorie.categorieID}">
                                                        <option selected value="${categorie.categorieID}">${categorie.libelle}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${categorie.categorieID}">${categorie.libelle}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${categorie.noCategorie}">${categorie.libelle}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Filtrer Categorie"></input>

                        </p>
                    </div>

                    </form>
                </div>
            </div>
        </div>

        <!--Liste des enchères-->
        <div class="container">
            <div class="jumbotron">
                <div class = "row">
                    <c:forEach items = "${articles}" var = "article">
                        <div class="card mb-3 border border-primary col-md-6" id= "card">
                            <div class="row g-0">
                                    <div class="col-md-4 text-center border border-4">
                                        <img src="img/Tableau.png" class="img-fluid rounded-start"
                                            width="100" height="100" alt="sansImg">
                                    </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h4 class="card-title">Nom Article : ${article.nom}</h4>
                                        <h5 class="card-title">Prix : ${article.prixInitial} points</h5>
                                        <h5 class="card-title">Fin de l enchère : ${article.finEnchere}</h5>
                                        <p class="card-text"> vendeur : ${article.utilisateur.pseudo} :</p>
                                    </div>
                                </div>
                            </div>
                       </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </body>
	<jsp:include page="footer.jsp" />
</html>