<%--
  Created by IntelliJ IDEA.
  User: travi
  Date: 8/7/2017
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
  Description:  Page where users will register their account
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Ready to register?</h1>
<form method = "post" action ="/addUserFinancials">
    <fieldset>
        <legend>Let's set up your login information</legend>
        <div class="container">
            <label><b>User Name:</b></label>
            <br>
        <input type ="text" placeholder ="Enter a username" name ="user_id" required>
        <br>
        <br>
            <label><b>Email:</b></label>
            <br>
            <input type ="email" placeholder ="Enter an Email" name ="email" required>
            <br>
            <br>
            <label><b>Password:</b></label>
            <br>
            <input type ="password" placeholder ="Enter a password" name ="psw" onkeyup='check();' required>
            <br>
            <br>
            <label><b>Repeat Password:</b></label>
            <br>
            <input type ="password" placeholder ="Repeat password" name ="psw-repeat" onkeyup='check()'; required>
            <br>
            <input type ="checkbox" checked ="checked"> Remember me
            <br>
            <br>
            <label><b>Current job:</b></label>
            <br>
            <input type ="text" placeholder ="Current Job" name ="curjob" required>
            <br>
            <br>
            <div>
                <button type ="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>

    </fieldset>
</form>

</body>
</html>
