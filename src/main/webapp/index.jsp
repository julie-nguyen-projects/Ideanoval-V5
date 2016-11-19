<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Ideanoval</title>
    <meta charset="UTF-8">
</head>

<body>
<jsp:include page="navbarForIndex.jsp"/>

<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-text">
                    <span class="name">Ideanoval</span>
                    <hr class="star-light">
                    <span class="skills">Bonjour ${user.pseudo} ! <br><br></span>
                    <c:if test="${sessionScope.id == null}">
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-success btn-lg">Se connecter</a>
                        <a href="${pageContext.request.contextPath}/register" class="btn btn-success btn-lg">S'inscrire</a>
                    </c:if>

                    <c:if test="${sessionScope.id != null}">
                        <a href="${pageContext.request.contextPath}/addIdea" class="btn btn-success btn-lg">Ajouter une idée</a>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-success btn-lg">Se déconnecter</a>
                    </c:if>
                    </span>
                </div>
            </div>
        </div>
    </div>
</header>

<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>De la suite dans vos idées</h2>
                <hr class="star-primary">
            </div>
        </div>

        <div class="row">

            <c:forEach items="${ideas}" var="idea" >
                <div class="col-sm-4 portfolio-item" style="height: 200px">
                    <a href="${pageContext.request.contextPath}/anIdea?id=${idea.idIdea}">
                        <img src="#" class="img-responsive">

                    <h4>${idea.title}</h4>
                    <p><c:out value="${idea.category.label}"/></p>
                    <p>${idea.user.pseudo}</p>
                    </a>
                </div>
            </c:forEach>
        </div>


        <br>

        <a href="${pageContext.request.contextPath}/submitCategory">Proposer une catégorie...</a>

    </div>
</section>








</body>
</html>
