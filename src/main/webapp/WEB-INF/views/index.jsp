<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
  Created by IntelliJ IDEA.
  User: Antonella
  Date: 7/21/17
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--if using IE use the latest rendering-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- IMPORTANT: sets the page to width of the device and sets the zoom level-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Welcome to Quit My Job</title>

    <!-- Bootstrap -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .jumbotron {
            background-color: purple;
            color: white;
        }
    </style>
</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/20/2017
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>


<body>
<h1>${message}</h1><br>
<br>
<form:form method="POST" action="/userhome" onclick="validate()">
    <section>
        <fieldset>
            <legend>
                <strong>Login</strong>
            </legend>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="userName" id="userName" size="30" tabindex="1" placeholder="User Name"
                               autofocus required></td>
                </tr>
                <tr>
                    <td>Enter Password: </td>
                    <td><input type="password" name="password" id="password" size="30" tabindex="2" placeholder="Password"
                               autofocus
                               required></td>
                </tr>
                <tr>
                    <td><input id="submit" type="submit" value="Submit" tabindex="3"></td>
                </tr>
            </table>
        </fieldset>
    </section>
</form:form>
<br>
<br>
<a href="register"> <button>Register!</button></a>
</body>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<script src="../../webresources/js/validation.js"></script>

</body>
</html>