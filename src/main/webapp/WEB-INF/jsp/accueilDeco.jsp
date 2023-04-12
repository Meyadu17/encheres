
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