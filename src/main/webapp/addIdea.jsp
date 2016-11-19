<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Proposer une idée</title>
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
                    <span class="skills">Proposer une idée <br></span>
                    </span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- TODO Poll option -->
<section>
    <div class="container">
        <form:form method="POST" modelAttribute="idea" action="addIdea">
            <form>
                <div class="form-group col-md-6 col-md-offset-3">
                    <label> Titre de l'idée : </label>
                    <br>
                    <form:input class="form-control" path="title" type="text" placeholder="Titre" required="true"/>
                    <br> <br>
                </div>

                <div class="form-group col-md-6 col-md-offset-3">
                    <label> Description : </label>
                    <br>
                    <form:textarea class="form-control" path="description" type="textarea" rows="10" placeholder="Description" required="true"/>
                    <br> <br>
                </div>

                <div class="form-group col-md-6 col-md-offset-3">
                    <label> Catégorie </label>
                    <br>
                    <select class="form-control" name="ID_CATEGORY">
                        <c:forEach items="${categories}" var="category" varStatus="status">
                                <option value="${category.idCategory}" required="true" id="${category.idCategory}">
                                        ${category.label} (${category.description})
                                </option>
                        </c:forEach>
                    </select>
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
