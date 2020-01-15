"use strict"

let submitButton = document.getElementById("login-submit")
var data = {firstName:"John", lastName:"Doe"};
submitButton.addEventListener("click",(e)=>{
    attemptlogin();
});

async function attemptlogin(){
    fetch('http://localhost:8080/reimbursement/hello', {

    }).then((myJson)=> {
      console.log(Response);
    });
};