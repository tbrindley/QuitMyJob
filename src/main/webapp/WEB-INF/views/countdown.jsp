<%--
  Created by IntelliJ IDEA.
  User: travis
  Date: 7/21/2017
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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

    <style>
        .bad{background-image:url(../../webresources/img/firebackground.gif);
            background-size: cover;
            background-position: center;
            border: solid 2px red;
            color:yellow;}
        .ok{background-image:url(../../webresources/img/kermit.gif);
            background-size:cover;
            background-position: 15%;
            border: solid 2px yellow;
            color: yellow;}

        .good{background-image:url(../../webresources/img/happybackground.jpg);
            background-size: cover;
            border: solid 2px green;
            color: lime;}

    </style>
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
                <li class="active"><a href="/countdownclock">Countdown Clock</a></li>
                <li><a href="/jobsearch">Job Hunt</a></li>
                <li><a href="/quit">Resignation Letter</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">USERNAME <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Redo Finances</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- container puts padding around itself, "container-fluid fills the whole screen -->
<div class="container">

    <div class="page-header">
        <Center>
            <h1>If you quit your job right now...</h1>
            <h2>You would make it</h2>
        </Center>
    </div>
    <div class="jumbotron" id="test" style="padding-top: 6%; text-align: center; font-size: 54px">
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12">
            <p id="feedback"></p>
        </div>

    </div>
    <script>
        var months = ${months};
        var days = ${days};
        var hours = ${hours};
        var min = ${min};

        var endDate = new Date;


        endDate.setMonth(endDate.getMonth() + months);
        endDate.setDate(endDate.getDate() + days);


        // Update the count down every 1 second
        var x = setInterval(function () {

            // Get todays date and time
            var now = new Date().getTime();

            // Find the distance between now an the count down date
            var distance = endDate - now;


            var _sec = 1000;
            var _min = _sec * 60;
            var _hour = _min * 60;
            var _day = _hour * 24;
            var _month = _day * 30;
            // Time calculations for days, hours, minutes and seconds
            var mon = Math.floor(distance / _month);
            var d = Math.floor(distance % _month / _day);
            var h = Math.floor((distance % _day) / _hour);
            var m = Math.floor((distance % _hour) / _min);
            var s = Math.floor((distance % _min) / 1000);

            if (mon >= 3) {
                document.getElementById("test").classList.add("good");
                document.getElementById("feedback").innerHTML = "<center><h1>Good News!!!!</h1></center>With at least three months of time before you " +
                    "would be strapped for cash, feel free to quit that job!  Here is a link to some relevant jobs"
            }
            else if (mon === 2) {
                document.getElementById("test").classList.add("ok");
                document.getElementById("feedback").innerHTML = "<center><h1>Sorry, we're not much help</h1></center>With at least two months of time before you " +
                    "would be strapped for cash, we feel you're on the bubble.  If you're the kind of person who likes to live on the edge," +
                    "quit that job, otherwise, looks like you're going back.    Here is a link to some relevant jobs to help you dream"
            }
            else {
                document.getElementById("test").classList.add("bad");
                document.getElementById("feedback").innerHTML = "<center><h1>Heck No!!!!</h1></center>You can't even make it 2 months without a job " +
                    "without being strapped for cash.  Accounting for the slow moving nature of bureaucracy, leaving now would be a" +
                    " very bad idea.  To help you dream,  here is a link to some relevant jobs"
            }
            // Output the result in an element with id="demo"
            document.getElementById("test").innerHTML = mon + " mon " + d + " days <br><span style='font-size: 34px'>" + h + " hrs "
                + m + " min " + s + " sec ";

            // If the count down is over, write some text
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("test").innerHTML = "EXPIRED";
            }
        }, 1000);
    </script>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</body>
</html>