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
                    <form method="post" action="#">
                        <label for="article">Article : <input type="text" name="article" placeholder="nom article"/></label>
                        <label for="description"> Description : <textarea name="description" placeholder="description de l'article"></textarea>
                        <label for="categorie">Catégorie :
                            <select name="categorie">
                                <option value="">vide</option>
                                <option value="mobilier">mobilier</option>
                                <option value="electromenager">électroménager</option>
                                <option value="musique">musique</option>
                            </select>
                        </label>
                        <label for="photo article">Photo de l article:
                            <button> UPLOADER </button>
                        </label>
                        <label for="mise à prix">
                            Mise à prix: <input type="number" name="prix"/>
                        </label>
                         <label for="debut enchere">
                            Début de l enchère: <input type="datetime-local" name="dateDebut"/>
                         </label>
                         <label for="fin enchere">
                            Fin de l enchère <input type="datetime-local" name="dateFin"/>
                        </label>
                        <h1>Retrait</h1>
                        <label for="rue">
                            Rue: <input type="text" name="rue"/>
                        </label>
                        <label for="codePostal">
                           Code postal: <input type="text" name="codePostal">
                        </label>
                        <label for="Ville">
                            Ville: <input type="text" name="ville">
                       </label>
                       <input type="submit" value="Envoyer"></input>
                    </form>
                    <button>Annuler</button>
                </div>
            </div>
        </div>
    </body>
</html>