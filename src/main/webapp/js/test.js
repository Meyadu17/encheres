// Récupère les éléments de la page nécessaires
var inputRecherche = document.getElementById("keyword");
var selectCategories = document.getElementById("categories");
var articles = document.getElementsByClassName("article");

// Ajoute un gestionnaire d'événement pour le changement de la valeur de l'input de recherche
inputRecherche.addEventListener("input", function() {
  var termeRecherche = inputRecherche.value.toLowerCase();

  // Parcourt la liste des articles et affiche ou masque ceux qui correspondent au terme de recherche
  for (var i = 0; i < articles.length; i++) {
    var article = articles[i];
    var nomArticle = article.getElementsByClassName("nom")[0].textContent.toLowerCase();
    if (nomArticle.indexOf(termeRecherche) !== -1) {
      article.style.display = "";
    } else {
      article.style.display = "none";
    }
  }
});

// Ajoute un gestionnaire d'événement pour le changement de la valeur du select de catégories
selectCategories.addEventListener("change", function() {
  var categorieSelectionnee = selectCategories.value;

  // Parcourt la liste des articles et affiche ou masque ceux qui correspondent à la catégorie sélectionnée
  for (var i = 0; i < articles.length; i++) {
    var article = articles[i];
    var categorieArticle = article.getAttribute("data-categorie");
    if (categorieSelectionnee === "tous" || categorieSelectionnee === categorieArticle) {
      article.style.display = "";
    } else {
      article.style.display = "none";
    }
  }
});