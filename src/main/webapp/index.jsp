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
                        <a href="${pageContext.request.contextPath}/addIdea" class="btn btn-success btn-lg">Ajouter une id�e</a>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-success btn-lg">Se d�connecter</a>
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
                <h2>De la suite dans vos id�es</h2>
                <hr class="star-primary">
            </div>
        </div>

        <div class="row">
            <c:if test="${ideas.size() == 0}">
                <p>Il n'y a aucune id�e propos�e, n'h�sitez pas � vous inscrire et � soumettre votre suite d'id�es...</p>
            </c:if>

            <c:if test="${ideas.size() != 0}">
                <c:forEach items="${ideas}" var="idea" >
                    <div class="col-sm-4 portfolio-item" style="height: 200px">
                        <a href="${pageContext.request.contextPath}/anIdea?id=${idea.idIdea}" class="portfolio-link">
                            <div class="caption" style="height: 200px">
                                <div class="caption-content">
                                    <i class="fa fa-search-plus fa-3x"> </i>
                                </div>
                            </div>

                            <!-- Display votes -->
                            <div style="background-color: #2C3E50; padding: 3px; text-align: center">
                                <c:set var="topCount" value="0"/>
                                <c:set var="flopCount" value="0"/>
                                <c:forEach items="${idea.votes}" var="vote">
                                    <c:if test="${vote.note > 0}">
                                        <c:set var="topCount" value="${topCount + vote.note}"/>
                                    </c:if>
                                    <c:if test="${vote.note < 0}">
                                        <c:set var="flopCount" value="${flopCount - vote.note}"/>
                                    </c:if>
                                </c:forEach>
                                <h5 style="align-items: center; color:white">${topCount} Top & ${flopCount} Flop</h5>
                            </div>
                            <!-- End of display votes -->

                                <%--<img src="#" class="img-responsive">--%>
                            <h4>${idea.title}</h4>
                            <p>Cat�gorie : ${idea.category.label}</p>
                            <p>Id�e propos�e par : ${idea.user.pseudo}</p>
                        </a>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</section>








</body>
</html>
