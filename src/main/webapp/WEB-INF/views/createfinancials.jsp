<%--
  Created by IntelliJ IDEA.
  User: Travis
  Date: 8/11/2017
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        body{background-image: url("http://www.wallpapersbrowse.com/images/ak/akeodvn.jpg");
            background-size: cover;}
    </style>
    <meta charset="utf-8">
    <!-- if using IE use the latest rendering -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- IMPORTANT!!!! This sets the page to the width of the device it is being viewed on.  Also sets zoom level -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>QuitMyJob</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<!-- Static navbar -->
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">QuitMyJob.com</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">


            </ul>

        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- container puts padding around itself, "container-fluid fills the whole screen -->
<div class="container">

    <div class="page-header">
        <Center>
            <h1 id="homeHeading">Register Account</h1>
        </Center>
    </div>
    <div class="jumbotron">
        <form action="/userhome">
            <input type="hidden" name="clientId" value = "${clientid}"/>
            <FIELDSET>
                <LEGEND>Your Assets and Monthly Income</LEGEND>
                <label>
                    Total Household Savings:
                    <input type="text" name="th_savings" class="form-control" required>
                </label>
                <br>
                <label>
                    Monthly Household Income:
                    <input type="text" name="th_income" class="form-control" required>
                </label>
                <br>
            </FIELDSET>
            <br>
            <fieldset>
                <legend>
                    Your Household Expenses
                </legend>
                <label>
                    Mortgage/Rent:
                    <input type="text" name="rent" class="form-control" value="${rent}" required>
                </label>
                <br>
                <label>
                    Utilities:
                    <input type="text" name="utils" class="form-control" value="${utilities}" required>
                </label>
                <br>
            </fieldset>
            <br>
            <fieldset>
                <legend>
                    Your Transportation Expenses:
                </legend>
                <label>
                    Gasoline:
                    <input type="text" name="gas" class="form-control" value="${autoGas}" required>
                </label>
                <br>
                <label>
                    Insurance:
                    <input type="text" name="c_insurance" class="form-control" value="${carInsurance}" required>
                </label>
                <br>
                <label>
                    Car Payment:
                    <input type="text" name="c_bill" class="form-control" value="${carPayment}" required>
                </label>
            </fieldset>
            <br>
            <fieldset>
                <legend>
                    Your Food Expenses:
                </legend>
                <label>
                    Groceries:
                    <input type="text" name="groceries" class="form-control" value="${groceries}" required>
                </label>
                <br>
                <label>
                    Restaurants:
                    <input type="text" name="restaurant" class="form-control" value="${restaurant}" required>
                </label>
                <br>
            </fieldset>
            <br>
            <fieldset>
                <legend>
                    Recurring Debt Payments
                </legend>
                <label>
                    Credit Cards:
                    <input type="text" name="creditCard" class="form-control" value="${creditCard}"  required>
                </label>
                <br>
                <label>
                    Student Loans:
                    <input type="text" name="s_loans" class="form-control" value="${studentLoans}"  required>
                </label>
                <br>
                <label>
                    Other Debt:
                    <input type="text" name="o_debt" class="form-control" value="${miscExpenses}"  required>
                </label>
            </fieldset>
            <br>
            <fieldset>
                <legend>
                    Extra Expenses
                </legend>
                <label>
                    Medicine:
                    <input type="text" name="meds" class="form-control" value="${medInsurance}"  required>
                </label>
                <br>
                <label>
                    Other Expenses
                    <input type="text" name="o_expense" class="form-control" value="${otherMisc}"  required>
                </label>
            </fieldset>
            <br><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</body>
</html>
