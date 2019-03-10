<%--
  Created by IntelliJ IDEA.
  User: benlmsc
  Date: 2019-03-06
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>--%>
<%-- Ici le prefix c signifie que toutes les balises utilisés par la bibliothèque core de jstl commenceront par la lettre c --%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%-- Pour éviter de devoir rajouter nos <%@ à chaque fichier jsp, la configuration jsp dans web.xml nous permet
     d'inclure ces balises à chaque fois sans devoir les réécrire
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
    <%-- Exemple d'un include en JSP --%>
    <%@include file="menu.jsp"%>
    <p>
        <%-- Expression language : ${ ... } --%>
        <%-- Permet de récupérer les attributs de la requête dans cette JSP --%>
        Bonjour ${ !empty name ? name : author.firstname }
    </p>
    <h1>Bienvenue sur la page d'accueil</h1>


    <%-- La JSP ici est capable d'aller chercher d'elle-même les getters correspondant --%>
    <p>${ author.active ? "L'auteur est actif" : "L'auteur est inactif" }.</p>


    <%-- Exemple d'échappement des caractères avec la balise JSTL out --%>
    <c:out value="<p>Bonjour !</p>" default="Hello !"/>
    <%-- Autres exemples : --%>
    <%--<c:out value="${ text_rentrer_par_user }"/>--%>
    <%--<c:out value="<p>Bonjour !</p>">Valeur par défaut</c:out>--%>
    <%-- Désactiver l'échappement des caractères --%>
    <%--<c:out value="<p>Bonjour !</p>" escapeXml="false"/>--%>


    <%-- Définition de variable avec JSTL --%>
    <%-- On définit son nom (var), sa valeur (value) et sa portée (scope) ici ce sera notre page uniquement --%>
    <c:set var="nomVar" value="HelloWorld" scope="page"/>

    <%-- Possibilité d'écrire notre set de la façon suivante : --%>
    <%--<c:set var="nomVar" scope="page">Ma valeur</c:set>--%>

    <%-- Utilisation d'une variable : --%>
    <br>
    <c:out value="${nomVar}"/>

    <%-- Redéfinition de la variable : --%>
    <br>
    <c:set var="nomVar" value="FooBar" scope="page"/>
    <c:out value="${nomVar}"/>

    <%-- Modification d'un bean : --%>
    <%-- On spécifie notre cible et la propriété que l'on souhaite modifier --%>
    <br>
    <c:set target="${ author }" property="firstname" value="Mario"/>
    <c:out value="${ author.firstname }"/>

    <%-- Supprimer une variable : --%>
    <br>
    <c:remove var="nomVar" scope="page"/>
    <c:out value="${nomVar}"/>


    <%-- Conditions : --%>
    <%-- 01 - Tests simples (uniques) --%>
    <%-- L'attribut var permet d'enregistrer dans une variable le résultat du test --%>
    <c:if test="${50 > 10}" var="condition" scope="page">
        50 est bien supérieur à 10 !
    </c:if>

    <%-- 02 - Tests multiples --%>
    <c:choose>
        <c:when test="${ 50 < 10 }">50 est inférieur à 10 </c:when>
        <c:when test="${ 50 == 10 }">50 est égal à 10 </c:when>
        <%-- Condition finale : --%>
        <c:otherwise>50 est supérieur à 10</c:otherwise>
    </c:choose>


    <%-- Boucles : --%>
    <br><br>
    <%-- Boucles simple : --%>
    <%-- La boucle ici s'arreête après 10 --%>
    <%-- equals to : for (int i = 0 ; i <= 10 ; i++) --%>
    <c:forEach begin="0" end="10" step="1" var="iterationNbr">
        Numéro : ${ iterationNbr } <br>
    </c:forEach>

    <%-- Boucles sur un array --%>
    <c:forEach items="${ names }" var="item">
        ${ item }
    </c:forEach>

    <%-- Boucles sur un array en sélectionnant la portion sur laquelle on souhaite itérer (ici, de 0 à 1 inclus) --%>
    <c:forEach items="${ names }" var="item" begin="0" end="1">
        <br>${ item }
    </c:forEach>

    <%-- Boucles sur un array avec informations (status) sur la boucle en cours--%>
    <c:forEach items="${ names }" var="item" varStatus="status">
        <br>
        Numéro de boucle : ${ status.count }
        ${ item } <br>
        Item index : ${ status.index }
    </c:forEach>

    <%-- Boucles dédier aux strings --%>
    <c:forTokens items="Un élement/ Un autre élément/Encore un autre élément" var="element" delims="/">
        <br>
        <c:out value="${ element }"/>
    </c:forTokens>

    <%-- Boucles dédier aux strings --%>
    <%-- Attention : si on rajoute un espace dans l'attr delims, on découpera aussi dès qu'il y aura un espace --%>
    <c:forTokens items="Un élement/ Un autre élément/Encore un autre élément" var="piece" delims="/ ">
        <br>
        <c:out value="${ piece }"/>
    </c:forTokens>
</body>
</html>
