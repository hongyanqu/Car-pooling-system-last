<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="image/icon.png">    
        <title>CarPooling</title>
        <script src="./js/addPost.js" type="text/javascript"></script>
        <!-- Bootstrap core CSS -->
        <link href="./css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./css/home.css" rel="stylesheet">
        <script src="./js/post.js" type="text/javascript"></script>
    </head>

    <body>

        <div class="container">
            <nav class="navbar navbar-light bg-faded">
                <a class="navbar-brand" href="#">CarPooling</a>
                <ul class="nav navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="#">Home
                            <span class="sr-only">(current)</span>
                        </a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Weather
                            Service</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Map
                            Service</a></li>
                    <li class="nav-item"><a class="nav-link" href="signup.jsp">UpdateProfile</a></li>
                    <li class="nav-item"><a class="nav-link" href="http://portals.mum.edu/RelId/606502/ISvars/default/Current_Students.htm">About</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.jsp">
                            <button class="btn btn-link" onclick="Logout">logout</button>
                        </a></li>
                </ul>
                <img src="./image/ha.ico" style="width:50px; height:50px" alt="" id = "ha">

            </nav>
            <!-- /navbar -->

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <nav class="navbar navbar-light bg-faded">
                    <ul class="nav navbar-nav">
                        <li class="nav-item active"><a class="nav-link" href="#">Asking for ride
                                <span class="sr-only">(current)</span>
                            </a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Offer a ride
                                Service</a></li>

                    </ul>

                </nav>
                <div id="content">

                    <div class="panel panel-default panel-info">
                        <div class="panel-heading"> 
                            Add New Ride
                        </div>
                        <div class="panel-heading">
                            <textarea name="postText" id="postText" rows="4" class="form-control" placeholder="write details..." aria-describedby="basic-addon2"></textarea>
                            <form method="POST" action="AddPost">
                                <div class="text-right">
                                    <select name="postType" id="type" class="form-control show-menu-arrow">
                                        <option value="offering" selected>Looking to Offer</option>
                                        <option value="asking">Requesting for Ride</option>
                                    </select>
                                    <button name="addPost" id="addPost" class="btn-primary">Post</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <c:forEach items="${posts}" var="currentPost">           
                        <%System.out.println(request.getAttribute("posts"));%>
                        <div class="panel panel-default panel-info">
                            <div class="panel-heading">Ride: <c:out value="${currentPost.postType}"/>, By: <c:out value="${currentPost.createdBy.fullName}"/></div>
                            <div class="panel-body well-lg">
                                <p><c:out value="${currentPost.post}" /></p> 
                            </div>
                            <div class="panel-footer">
                                <p class="text-right"> 
                                    <button class="glyphicon glyphicon-thumbs-up btn-link" name="like"> Like</button>
                                    <span class="badge"><c:out value="${currentPost.likesCount}" /></span>                                                                        
                                </p>
                                <div class="input-group input-group-lg">
                                    <input type="text" class="form-control" placeholder="write a comment..." aria-describedby="basic-addon2">
                                    <span class="input-group-addon" id="basic-addon2"><a>Add Comment</a></span>
                                </div>
                                <div><a>Show Comments</a>
                                    <div class="comments" >

                                    </div>

                                </div>
                            </div>
                        </c:forEach>
                        <script>
                            function getLike(data) {
                                data += 1;
                            }
                        </script>

                    </div>
                    <p id="post">

                    </p>
                    <p id="bar">
                        <img alt="" src="./image/Comment.ico">
                        <img alt="" src="./image/Like.ico">  
                    </p>
                </div>
                <div>


                </div>
            </div>
        </div>
        <!-- /container -->


        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"
            integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY"
        crossorigin="anonymous"></script>
        <script>
                            window.jQuery
                                    || document
                                    .write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
        </script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"
            integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB"
        crossorigin="anonymous"></script>
        <script src="./js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
