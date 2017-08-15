/**
 * Created by Travis Brindley on 8/6/2017.
 */
function validate(){
    var username = document.forms["login"]["userName"].value;

    var password = document.forms["login"]["password"].value;

    //checks if username is greater than 8
    if(username.length < 5){
        alert("Your username must be 8 characters long");
        return false;
    }

    //checks if password is greater than 8
    if(password.length < 8){
        alert("Your password must be 8 characters long");
        return false;
    }

    //checks if password has a capital letter
    var counter = 0;
    for(var i=1; i < password.length; i++){
        if(password.charAt(i) === password.toUpperCase().charAt(i)){
            counter += 1;
        }
        if(counter === 0){
            alert("Your password doesn't have a capital letter");
            return false;
        }
    }
}