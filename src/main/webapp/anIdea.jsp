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
        <div class="row">
            <h5 class="text-center">Idée proposée par ${idea.user.pseudo} le ${idea.publicationDateIdea} <br></h5>
            <br>
            <h5>Description de l'idée :</h5>
            <div class="col-md-10 col-md-offset-1">
                ${idea.description}
            </div>
        </div>

        <!-- Vote -->
        <!-- User connected, not voted yet -->
        <div class="row" style="padding-top: 50px">
            <c:if test="${sessionScope.id != null && vote == null}">
            <p>
                <a href="${pageContext.request.contextPath}/topVote?id=${idea.idIdea}" class="col-xs-2 col-xs-offset-3 btn btn-success btn-lg">Top</a>
                <a href="${pageContext.request.contextPath}/flopVote?id=${idea.idIdea}" class="col-xs-2 col-xs-offset-2 btn btn-success btn-lg">Flop</a>
            </p>
        </div>
        <div class="row" style="padding-top: 50px">
            <div class="col-md-12 text-center">
                <p>L'idée ne respecte pas la charte ?</p>
                <p><a href="${pageContext.request.contextPath}/alertIdea?id=${idea.idIdea}" class="btn btn-danger">Signaler l'idée</a></p
            </div>
            </c:if>
        </div>

        <!-- User connected, voted -->
        <c:if test="${sessionScope.id != null && vote != null}">
        <div class="col-md-12 text-center">
            <p>Vous avez voté <c:if test="${vote.note == 1}">Top</c:if> <c:if test="${vote.note == -1}">Flop</c:if> pour cette idée !</p>
        </div>
        <div class="col-md-12 text-center" style="margin-top: 50px">
            <p>L'idée ne respecte pas la charte ?</p>
            <p><a href="${pageContext.request.contextPath}/alertIdea?id=${idea.idIdea}" class="btn btn-danger">Signaler l'idée</a></p>
        </div>
    </div>
    </c:if>

    <!-- Not a user connected -->
    <c:if test="${sessionScope.id == null}">
        <div class="row">
            <div class="col-md-12 text-center">
                <p>Vous devez être inscrit(e) et vous connecter pour voter.<br></p>
                <a href="${pageContext.request.contextPath}/register" class="btn btn-success btn-lg">S'inscrire</a>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-success btn-lg">Se connecter</a>
            </div>
        </div>
    </c:if>
    </div>
    <!-- End for vote -->
    </div>
</section>

<!-- All the comments -->
<section>
    <div class="container" >
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
                <div class="col-md-12 text-right">
                    <a href="${pageContext.request.contextPath}/alertComment?id=${comment.idComment}" class="btn btn-danger">Signaler le commentaire</a>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<!-- End for all the comments -->

<!-- Comment the idea-->
<footer>
    <div class="footer-above" style="padding-bottom: 50px">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2>Commenter</h2>
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
                    <textarea rows="6" name="commentContent" class="col-md-12 form-control" style="color: white"
                              placeholder="Votre commentaire ..."></textarea>
                                <br><br>
                            </div>
                            <br>
                            <input type="submit" value="Commenter" class="btn btn-success btn-lg col-xs-2 col-xs-offset-5"/>
                        </form>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</footer>
<!-- End for comment the idea-->

</body>
</html>
