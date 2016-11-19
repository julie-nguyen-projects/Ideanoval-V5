<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Connexion</title>
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
                    <span class="skills">Page de connexion <br></span>
                    </span>
                </div>
            </div>
        </div>
    </div>
</header>


<section>
    <div class="container">
        <form:form method="POST" modelAttribute="user" action="login">
            <form>
                <div class="form-group col-md-6 col-md-offset-3">
                    <label> Email : </label>
                    <br>
                    <form:input class="form-control" path="email" type="text" placeholder="Adresse e-mail" required="true"/>
                    <br> <br>
                </div>

                <div class="form-group col-md-6 col-md-offset-3">
                    <label> Mot de passe : </label>
                    <br>
                    <form:input class="form-control" path="password" type="text" placeholder="Mot de passe" required="true"/>
                    <br> <br>
                </div>

                <br>
                <div class="col-md-12">
                    <input type="submit" value="Valider" class="col-md-2 col-md-offset-5 btn btn-danger"/>
                </div>
            </form>
        </form:form>



    </div>
</section>

</body>
</html>
