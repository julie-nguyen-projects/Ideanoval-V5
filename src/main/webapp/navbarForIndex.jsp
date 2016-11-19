<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Navigation bar</title>
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/freelancer.min.css"/>" rel="stylesheet">
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/font-awesome.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
</head>
<body>

<nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom affix-top">
    <div class="container">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">Ideanoval</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden active">
                    <a href="#page-top"></a>
                </li>
                <li class="page-scroll">
                    <a href="#portfolio">Idées</a>
                </li>
                <li class="page-scroll">
                    <a href="#about">About</a>
                </li>
                <li class="page-scroll">
                    <a href="#contact">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script src="<c:url value="../${pageContext.request.contextPath}/resources/jquery.min.js"/>"></script>
<script src="<c:url value="../${pageContext.request.contextPath}/resources/bootstrap.min.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="<c:url value="../${pageContext.request.contextPath}/resources/jqBootstrapValidation.js"/>"></script>
<script src="<c:url value="../${pageContext.request.contextPath}/resources/contact_me.js"/>"></script>
<script src="<c:url value="../${pageContext.request.contextPath}/resources/freelancer.min.js"/>"></script>

</body>
</html>