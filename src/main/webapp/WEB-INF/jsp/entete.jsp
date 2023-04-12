<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap-theme.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
        <link href="css/commun.css" rel="stylesheet"/>
        <link rel="icon" href="img/favicon.ico" />
    </head>
    <body>
        <header>
            <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
                <div class="container">
                    <ul class="nav navbar-nav bg-body-tertiary">
                        <li class="pull-left"><a class="navbar-brand"><img src="img/logoENIEncheres.png"alt="Logo Enchères" width="110" class="d-inline-block align-top"></a></li>
                        <c:if test="${empty userInSession.getEmail()}">
                            <li class="pull-right"><a class="navbar-brand" href="connexion">Se connecter </a></li>
                        </c:if>
                        <c:if test="${!empty userInSession.getEmail()}">
                            <a class="navbar-brand" href="./">Enchères </a>
                            <a class="navbar-brand" href="vente">Vendre un acticle </a>
                            <a class="navbar-brand" href="profil">Mon profil </a>
                            <a class="navbar-brand" href="deconnexion">Se déconnecter </a>
                        </c:if>
                    </ul>
                </div>
            </nav>
        </header>