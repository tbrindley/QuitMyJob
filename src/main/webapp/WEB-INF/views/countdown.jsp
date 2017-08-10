<%--
  Created by IntelliJ IDEA.
  User: travi
  Date: 8/7/2017
  Time: 11:47 AM
  Description:  The homepage for a logged in user.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: travi
  Date: 7/21/2017
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css" href="../../webresources/css/style.css">
    <title>Quit My Job</title>
    <meta charset="UTF-8">

    <title>Countdown Clock</title>

</head>
<body>
${finances}
<div id="test" style="text-align: center; padding-top: 10%; font-size: 44px;">

</div>

<script>
    var months = ${months} ;
    var days = ${days};


    var endDate = new Date;


    endDate.setMonth(endDate.getMonth() + months);
    endDate.setDate(endDate.getDate() + days);


    // Update the count down every 1 second
    var x = setInterval(function() {

        // Get todays date and time
        var now = new Date().getTime();

        // Find the distance between now an the count down date
        var distance = endDate - now;


        var _sec = 1000;
        var _min = _sec * 60;
        var _hour = _min * 60;
        var _day = _hour * 24;
        var _month =  _day * 30;
        // Time calculations for days, hours, minutes and seconds
        var mon = Math.floor(distance /_month);
        var d = Math.floor(distance % _month / _day );
        var h = Math.floor((distance % _day) / _hour);
        var m = Math.floor((distance % _hour) / _min);
        var s = Math.floor((distance % _min) / 1000);

        if(mon >= 3){
            document.getElementById("test").style.backgroundColor="green";
        }
        else if(mon === 2){
            document.getElementById("test").style.backgroundColor="yellow";
        }
        else{
            document.getElementById("test").style.backgroundColor="red";
        }
        // Output the result in an element with id="demo"
        document.getElementById("test").innerHTML = mon + "months " +d + "days " + h + "hours "
            + m + "minutes " + s + "seconds ";

        // If the count down is over, write some text
        if (distance < 0) {
            clearInterval(x);
            document.getElementById("test").innerHTML = "EXPIRED";
        }
    }, 1000);
</script>
</body>
</html>
