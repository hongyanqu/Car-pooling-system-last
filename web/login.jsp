<%-- 
    Document   : login
    Created on : Aug 28, 2016, 2:54:04 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>

     <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./image/car.ico">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="./image/icon.png">


        <!-- Bootstrap core CSS -->
        <link href="./css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./css/signin.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Share Rid-login</title>
    </head>
    <body>
        <div class="container">
				<p id="logo"> <span id="letter1">C</span><span id="letter2">a</span><span id="letter3">r</span><span id="letter4">P</span><span id="letter5">o</span><span id="letter6">o</span><span id="letter7">l</span><span id="letter8">i</span><span id="letter9">n</span><span id="letter10" >g</span></p>
            <form class="form-signin" method="POST" action="LoginController">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <div id="errorMessage">
                    <c:forEach items="${errorMessages}" var="current">                        
                        <c:out value="${current}" /><br/>
                        <%System.out.println(request.getAttribute("errorMessages"));%>
                    </c:forEach>
                </div>
				 
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <br/>
             <a href="signup.jsp" class="pull-right">Sign up</a>
            </form>
         
        </div>

    </body>
</html>
