/**
 * Created by Travis Brindley on 8/6/2017.
 */
function validateLogin(){
   var username = document.forms["login"]["userName"].value;
   var password = document.forms["login"]["password"].value;

   if(username.length < 5){
      alert("Username must be at least 5 characters long");
      return false;
   }
   if(password.length < 8){
      alert("Password must be at least 8 characters long");
      return false;
   }
   return true;
}

function validateCreateUser() {
    var username = document.forms["createUser"]["user_id"].value;
    var pass = document.forms["createUser"]["psw"].value;
    var confirmpass = document.forms["createUser"]["psw-repeat"].value;
    var job = document.forms["createUser"]["curjob"].value;
    var city = document.forms["createUser"]["city"].value;

    if(username.length < 5){
        alert("Username must be at least 5 characters long");
        return false;
    }
    else if(pass.length < 8){
        alert("Password must be at least 8 characters long");
        return false;
    }
    else if(pass != confirmpass){
       alert("Password & Confirm Password don't match");
       return false;
    }
    else if(!/^[A-Za-z ]*$/g.test(job)){
        alert("Please enter a valid job");
        return false;
    }
    else if(!/^[A-Za-z ]*$/g.test(city)) {
        alert("Please enter a valid job");
        return false;
    }
    else{

    }
    return true;

}