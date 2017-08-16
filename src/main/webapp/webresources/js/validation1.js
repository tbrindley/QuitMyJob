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

function validateUserCreation(){
    var username = document.forms["createUser"]["username"].value;
    var email = document.forms["createUser"]["email"].value;
    var psw = document.forms["createUser"]["psw"].value;
    var confirmpsw = document.forms["createUser"]["psw-repeat"].value;
    var curjob = document.forms["createUser"]["curjob"].value;
    var city = document.forms["createUser"]["city"].value;


    if(username.length < 5){
        alert("Username must be at least 5 characters long");
        return false;
    }

    //checks email for '@' & ensures it only has 1
    var specialcounter = 0;
    for(var i = 0; i < email.length; i++){
        if(email.charAt(i) === '@'){
            specialcounter += 1;
        }
    }
    if(specialcounter !== 1){
        alert("Invalid email form.");
        return false;
    }

    if(psw.length < 8){
        alert("Password must be at least 8 characters long");
        return false;
    }
    if(psw !== confirmpsw){
       alert("Password & Confirm Password don't match");
       return false;
    }


}