/**
 * Created by Travis Brindley on 8/6/2017.
 */
function validateLogin(){
   var username = document.forms["login"]["userName"].value;
   var password = document.forms["login"]["password"].value;

   if(username.length < 5){
      addAlert("messagealert","Username must be at least 5 characters long", true);
      return false;
   }
   if(password.length < 8){
      addAlert("messagealert","Password must be at least 8 characters long", true);
      return false;
   }
   else{
       addAlert("messagealert","Success", false);
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
        addAlert("messagealert","Username must be at least 5 characters long", true);
        return false;
    }
    else if(pass.length < 8){
        addAlert("messagealert","Password must be at least 8 characters long", true);
        return false;
    }
    else if(pass != confirmpass){
       addAlert("messagealert","Password & Confirm Password don't match", true);
       return false;
    }
    else if(!/^[A-Za-z ]*$/g.test(job)){
        addAlert("messagealert","Please enter a valid job", true);
        return false;
    }
    else if(!/^[A-Za-z ]*$/g.test(city)) {
        addAlert("messagealert","Please enter a valid job", true);
        return false;
    }
    else{
        addAlert("messagealert","Thank you for registering", false);
    }
    return true;

}
/*
 * Add alert message function
 */
function addAlert(id, message, isError){
    if(isError){
        document.getElementById(id).innerHTML='<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' + message + '</div>';
    }else{
        document.getElementById(id).innerHTML='<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' + message + '</div>';
    }
}
