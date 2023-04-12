<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <jsp:include page="entete.jsp"/>
        	<div class="container">
                <div class="jumbotron">
                        <h2 class="text-center">Enchères en cours</h2></br> </br>
                </div>
            </div>
            <div class="container">
                <div class="jumbotron">
                    <!--Filtre de recherche-->
                    <div class="col col-md-6 text-center mx-auto text-center d-flex flex-row">
                        <form th:action="@{/}">
                            Filter: <input type="text" name="keyword" id="keyword" size="50" th:value="${keyword}" required />
                            &nbsp;
                            <input type="submit" class ="btn btn-primary" value="Search" />
                            &nbsp;
                        </form>
                    </div>
                    <!--Menu catégorie-->

                    <p class="d-flex flex-row">
                        <label class="col-lg-3 pt-3" for="categories">Catégorie&nbsp;:</label>
                        <select name="category_filter" id="categories" class="col-lg-9 mt-2 form-control">
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
                    </p>


                <div class="container">
                    <div class="jumbotron">
                        <div class = "row">
                            <c:forEach items = "${articles}" var = "article">
                                <div class="card mb-3 border border-primary col-md-6" id= "card">
                                    <div class="row g-0">
                                            <div class="col-md-4 text-center border border-4">
                                                <img src="img/croix.png" class="img-fluid rounded-start"
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

            </div>
        </body>
	<jsp:include page="footer.jsp" />
</html>