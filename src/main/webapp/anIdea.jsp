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
                    <hr class="star-light"></hr>
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
                <hr class="star-primary"></hr>
            </div>
        </div>

        <!-- TODO image de l'idée à mettre -->
        <h5 class="text-center">Idée proposée par ${idea.user.pseudo} <br></h5>
        <br>
        <h5>Description de l'idée :</h5>
        <div class="col-md-10 col-md-offset-1">
            ${idea.description}
        </div>
</section>
<!-- TODO vote pour l'idée -->
<!-- TODO commentaires de l'idée-->


<!-- Comment the idea-->
<section>
    <div class="row">
        <div class="col-md-12 text-center">
            <h2>Commenter</h2>
            <hr class="star-primary"></hr>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form action="comment" method="POST">
                <input type="hidden" name="idea_id" value="${idea.idIdea}" />
                <div class="form-group col-md-12 floating-label-form-group controls">
                    <textarea rows="6" id="commentContent" class="col-md-12 form-control" style="border:1px solid gray"
                              placeholder="Votre commentaire ..."></textarea>
                    <br><br>
                </div>
                <br>
                <input type="submit" value="Commenter" class="btn btn-success btn-lg col-xs-2 col-xs-offset-5"/>
            </form>
        </div>
    </div>
    <!-- End for comment the idea-->
</section>


</body>
</html>
