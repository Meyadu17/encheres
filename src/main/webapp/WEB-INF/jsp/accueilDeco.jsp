<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="entete.jsp"/>
        	 <div class="container">
                <div class="jumbotron">
                    <div class="row align-items-cente text-center">
                        <h2 class="text-center">Enchères en cours</h2></br> </br>
                        <div class="col col-md-6 text-center mx-auto text-center d-flex flex-row">
                               <form th:action="@{/}">
                                   Filter: <input type="text" name="keyword" id="keyword" size="50" th:value="${keyword}" required />
                                   &nbsp;
                                   <input type="submit" class ="btn btn-primary" value="Search" />
                                   &nbsp;
                               </form>
                        </div>
                        <div class="col col-md-6 text-center mx-auto text-center d-flex flex-row">
                              <label for="categorie">Catégories</label>
                                   <select name="categorie">
                                        <option value="">Toutes</option>
                                         <option value="mobilier">Mobilier</option>
                                          <option value="electromenager">Electroménager</option>
                                          <option value="musique"Musique</option>
                                   </select>
                              </label>
                        </div>
                    </div>
                    <br>
                <div class = "row">
                        <c:forEach items = "${articles }" var = "article">
        	                <div class="card mb-3 border border-primary col-md-6" id= "card">
        	                     	<div class="col-md-8">
        		                         <div class="card-body">
        		                             <h4 class="card-title">${article.nom }</h4>
        		                             <h5 class="card-title">Prix : ${article.prixInitial } euros</h5>
        		                             <h5 class="card-title">Fin de l enchère : ${ article.finEnchere}</h5>
        		                             <p class="card-title"> Vendeur : ${ article.utilisateur.pseudo} </p>
=======
<jsp:include page="entete.jsp"/>
        <body>
        	<nav class="navbar navbar-default navbar-fixed-top">
        		<div class="container">
        			<div class="navbar-header">
        				<a href="welcome" class="navbar-brand active"> <span
        					class="glyphicon glyphicon-education"></span>
        				</a>
        				<a href="welcome" class="navbar-brand active"> <span
        					class="glyphicon glyphicon-education"></span>
        				</a>
        				<button class="navbar-toggle" type="button" data-toggle="collapse"
        					data-target="#navbar-main">
        					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
        						class="icon-bar"></span>
        				</button>
        			</div>
        			<c:if test="${!empty userInSession}">
        				<div class="navbar-collapse collapse" id="navbar-main">
        					<ul class="nav navbar-nav navbar-right">
        						<li><a href="deconnexion"><spring:message
        									code="welcome.disconnection" /> </a></li>
        					</ul>
        				</div>
        			</c:if>
        			<c:if test="${empty userInSession}">
                        <div class="navbar-collapse collapse" id="navbar-main">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="connexion"><spring:message
                                            code="welcome.connection" /> </a></li>
                                <li><a href="inscrire">S'inscrire</a></li>
                            </ul>
                        </div>
                    </c:if>
        		</div>
        	</nav>
        	 <div class="container">
                <div class="jumbotron">
                    <div class="row align-items-cente text-center">
                        <h2 class="text-center">Lister des Ench�res</h2></br> </br>
                        <div class="col col-md-6 text-center mx-auto text-center d-flex flex-row">
                                <form:form class="d-flex"  method="POST" action="rechercher" modelAttribute="recherche">
                                    <form:input class="form-control me-2" type="search" placeholder="Search"
                                        aria-label="Le nom de l'article contient" path="caractere"/>
                                    <button class="btn btn-outline-success" type="submit">Rechercher</button>
                                </form:form>
                        </div>
                    </div>
                    <div class = "row">
                        <c:forEach items = "${articles }" var = "article">
        	                <div class="card mb-3 border border-primary col-md-6" id= "card">
        	                    <div class="row g-0">
        	                        <div class="col-md-4 text-center border border-4">
        	                            <img src="img/croix.png" class="img-fluid rounded-start"
        	                                width="100" height="100" alt="sansImg">
        	                     	</div>
        	                     	<div class="col-md-8">
        		                         <div class="card-body">
        		                             <h4 class="card-title">${article.nom }</h4>
        		                             <h5 class="card-title">Prix : ${article.prixInitial }</h5>
        		                             <h5 class="card-title">Fin de l'enchère : ${ article.finEnchere}</h5>
        		                             <p class="card-text"> Vendeur : ${ article.utilisateur.pseudo} </p>
>>>>>>> Stashed changes
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