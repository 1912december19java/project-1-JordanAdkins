"use strict"

let submitButton = document.getElementById("login-submit")
var data = {firstName:"John", lastName:"Doe"};
let user = {
	"name":"John", 
	"password": "password"
}
submitButton.addEventListener("click",(e)=>{
    attemptlogin();
});

async function attemptlogin(){

  fetch('http://localhost:8080/reimbursement/hello', {
    method: 'POST',
    body: JSON.stringify(user),
}).then(res => res.json())
    .catch(error => {
        console.error('Error:', error);
    })
    .then(response => {
        console.log(response);
    });
};