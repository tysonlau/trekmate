let login = document.querySelector(".loginButton");
let register = document.querySelector(".registerButton");
let loginForm = document.querySelector(".login-form");
let registerForm = document.querySelector(".register-form");
let goBack = document.querySelectorAll(".return");

var loginTrue = false;
var registerTrue = false;

login.addEventListener("click", ()=>{
    loginForm.classList.add("login-form-move");
    login.classList.add("loginButton-hide");
    register.classList.add("registerButton-hide");
    goBack[0].classList.add("return-visible");
    loginTrue = true;
})

register.addEventListener("click", ()=>{
    registerForm.classList.add("register-form-move");
    login.classList.add("loginButton-hide");
    register.classList.add("registerButton-hide");
    goBack[1].classList.add("return-visible");
    registerTrue = true;
})

goBack[0].addEventListener("click", returning);
goBack[1].addEventListener("click", returning);

function returning(event){
    event.preventDefault();
    if (loginTrue == true){
        loginForm.classList.remove("login-form-move");
        goBack[0].classList.remove("return-visible");
        loginTrue = false;
    }

    if (registerTrue == true){
        registerForm.classList.remove("register-form-move");
        registerTrue = false;
        goBack[1].classList.remove("return-visible");
    }

    login.classList.remove("loginButton-hide");
    register.classList.remove("registerButton-hide");
}