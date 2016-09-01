<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="robots" content="noindex">

        <title>Login &amp; Signup forms in panel - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="./css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="./css/signup.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script type="text/javascript">
            window.alert = function () {
            };
            var defaultCSS = document.getElementById('bootstrap-css');
            function changeCSS(css) {
                if (css)
                    $('head > link')
                            .filter(':first')
                            .replaceWith(
                                    '<link rel="stylesheet" href="' + css + '" type="text/css" />');
                else
                    $('head > link').filter(':first').replaceWith(defaultCSS);
            }
            $(document).ready(function () {
                var iframe_height = parseInt($('html').height());
                window.parent.postMessage(iframe_height, 'http://bootsnipp.com');
            });
        </script>
    </head>

    <body>
        <div class="container">
            <div id="signupbox" style="margin-top: 50px"
                 class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Sign Up</div>
                    </div>
                    <div class="panel-body">
                        <form id="signupform" class="form-horizontal" role="form"
                              method="POST" action="SignUpController">

                            <div id="signupalert" style="display: none"
                                 class="alert alert-danger">
                                <p>
                                <c:forEach items="${errorMessages}" var="current">                        
                                    <c:out value="${current}" /><br/>
                                    <%System.out.println(request.getAttribute("errorMessages"));%>
                                </c:forEach>
                                </p>
                                <span></span>
                            </div>



                            <div class="form-group">
                                <label for="email" class="col-md-3 control-label">Email</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="email"
                                           placeholder="Email Address" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="firstname" class="col-md-3 control-label">First
                                    Name</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="firstname"
                                           placeholder="First Name" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-md-3 control-label">Last
                                    Name</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="lastname"
                                           placeholder="Last Name" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="gender" class="col-md-3 control-label">Gender</label>
                                <div class="col-md-9">
                                    <label><input type="radio" name="gender" value="male"
                                                  checked> Male</label> 
                                    <label><input type="radio"
                                                  name="gender" value="female"> Female</label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Password</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password"
                                           placeholder="Password" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="state" class="col-md-3 control-label">State</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="state"
                                           placeholder="State" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="city" class="col-md-3 control-label">City</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="city"
                                           placeholder="City" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="street" class="col-md-3 control-label">Street</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="street"
                                           placeholder="Street" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="zipcode" class="col-md-3 control-label">Zip
                                    code</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="zipcode"
                                           placeholder="Zip code" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="birthYear" class="col-md-3 control-label">Birth
                                    Year</label>
                                <div class="col-md-9">
                                    <input type="number" class="form-control" name="birthYear"
                                           placeholder="Birth Year" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Button -->
                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btn-signup" type="submit" class="btn btn-info">
                                        <i class="icon-hand-right"></i> Sign Up
                                    </button>
                                    <span style="margin-left: 8px;">or</span>
                                </div>
                            </div>

                            <div style="border-top: 1px solid #999; padding-top: 20px"
                                 class="form-group">

                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btn-fbsignup" type="button" class="btn btn-primary">
                                        <i class="icon-facebook"></i> Sign Up with Facebook
                                    </button>
                                </div>

                            </div>



                        </form>
                    </div>
                </div>

            </div>
        </div>

        <script type="text/javascript">

        </script>
    </body>
</html>
