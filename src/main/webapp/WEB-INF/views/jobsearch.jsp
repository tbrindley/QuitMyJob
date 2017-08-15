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

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="../../webresources/js/IndeedSearch.js"></script>

    <script type="text/javascript">
        var indeed_client = new Indeed("2945076701195809");
        indeed_client.search({
            q: 'cook',
            l: 'detroit',
            userip: '1.2.3.4',
            useragent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2)',
        }, function(search_response){
            //render the jobs from the search_response
        });
    </script>

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
                <li><a href="/countdownclock">Countdown Clock</a></li>
                <li class="active"><a href="/jobsearch">Job Hunt</a></li>
                <li><a href="/quit">Resignation Letter</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">USERNAME <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Redo Finances</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="/logout">Logout</a></li>
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
            <h1>Job Search</h1>
        </Center>
    </div>
    <div class="jumbotron" id="test" style="padding-top: 6%; text-align: center; font-size: 54px">
        <input class="jobname" id="jobname" type="text" value="" name="jobname">
        <input class="location" id="location" type="text" value="" name="location">
        <input type="submit" id="searchResult" value="Find Jobs" class="">
        <!—Job result element -->
        <div id="jobs-data"></div>
        <div style="clear:both;"></div>
        <!—Pagination element -->
        <div id="pagination"></div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12">
            <p id="feedback"></p>
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