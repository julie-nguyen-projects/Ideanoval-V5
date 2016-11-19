<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Une idée...</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-text">
                    <span class="name">Ideanoval</span>
                    <hr class="star-light">
                    <span class="skills">Idée : ${idea.title}<br></span>
                    </span>
                </div>
            </div>
        </div>
    </div>
</header>

<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h2>${idea.title}</h2>
                <hr class="star-primary">
            </div>
        </div>

        <!-- TODO picture -->
        <h5 class="text-center">Idée proposée par ${idea.user.pseudo} le ${idea.publicationDateIdea} <br></h5>
        <br>
        <h5>Description de l'idée :</h5>
        <div class="col-md-10 col-md-offset-1">
            ${idea.description}
        </div>
    </div>
</section>
<!-- TODO vote -->

<!-- All the comments -->
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h2>Commentaires</h2>
                <hr class="star-primary">
            </div>
        </div>

        <c:forEach items="${idea.comments}" var="comment">
            <div class="row">
                <div class="col-md-12">
                    <h5>Commentaire posté par ${comment.user.pseudo}</h5>
                    <br>
                    <div class="col-md-10 col-md-offset-1">
                            ${comment.commentContent}
                        <br><br>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<!-- Comment the idea-->
<section>
    <div class="row">
        <div class="col-md-12 text-center">
            <h2>Commenter</h2>
            <hr class="star-primary">
        </div>
    </div>

    <c:if test="${sessionScope.id == null}">
        <div class="row">
            <div class="col-md-12 text-center">
                <p>Vous devez être inscrit(e) et vous connecter pour poster un commentaire.<br></p>
                <a href="${pageContext.request.contextPath}/register" class="btn btn-success btn-lg">S'inscrire</a>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-success btn-lg">Se connecter</a>
            </div>
        </div>

    </c:if>

    <c:if test="${sessionScope.id != null}">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <form action="commentAnIdea" method="POST">
                    <input type="hidden" name="idea_id" value="${idea.idIdea}" />
                    <div class="form-group col-md-12 floating-label-form-group controls">
                    <textarea rows="6" name="commentContent" class="col-md-12 form-control" style="border:1px solid gray"
                              placeholder="Votre commentaire ..."></textarea>
                        <br><br>
                    </div>
                    <br>
                    <input type="submit" value="Commenter" class="btn btn-success btn-lg col-xs-2 col-xs-offset-5"/>
                </form>
            </div>
        </div>
    </c:if>
</section>
<!-- End for comment the idea-->

</body>
</html>
