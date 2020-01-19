"use strict";

let submitButton = document.getElementById("login-submit");
let employeeIdBox = document.getElementById("employee-login-id");
let employeepasswordBox = document.getElementById("employee-login-password");
let loginData = { id: "", password: "" };
let comU = "";
let loginCheck = document.cookie.indexOf('chk=');
const successUrl = "employeehomepage.html"

if(loginCheck !=-1){
  window.location.href = successUrl;
}


submitButton.addEventListener("click", e => {
  if (checkForValidInput()) {
    attemptlogin().then((data) => {
      comU = data.id
      let convint =Number(comU);
      convint = (convint * 6363);
      document.cookie = ("chk= " + convint + ";path= /");
      window.location.href = successUrl;
    }).catch((e) => {
      console.log("Wrong info");
    })
  }
});

document.addEventListener("keypress", e => {
  if (e.key == "Enter") {
    if (checkForValidInput()) {
      attemptlogin().then((data) => {
        comU = data.id
        let convint =Number(comU);
        convint = (convint * 6363);
        document.cookie = ("chk= " + convint + ";path= /");
        window.location.href = successUrl;
      }).catch((e) => {
        console.log("Wrong info");
      })
    }
  }
});

async function attemptlogin() {
  const response = await fetch("http://Reimbursementportal-env.mm26zshb3w.us-east-1.elasticbeanstalk.com/login", {
    method: "POST",
    credintials: 'include',
    body: JSON.stringify(loginData)
  });
   return await response.json();
}

function checkForValidInput() {
  if (employeeIdBox.value.trim() != "") {
    loginData.id = employeeIdBox.value;
    if (employeeIdBox.classList.contains("red-border")) {
      employeeIdBox.classList.remove("red-border");
    }
  } else {
    if (!employeeIdBox.classList.contains("red-border")) {
      employeeIdBox.classList.add("red-border");
    }
  }
  if (employeepasswordBox.value.trim() != "") {
    loginData.password = employeepasswordBox.value;
    if (employeepasswordBox.classList.contains("red-border")) {
      employeepasswordBox.classList.remove("red-border");
    }
  } else {
    if (!employeepasswordBox.classList.contains("red-border")) {
      employeepasswordBox.classList.add("red-border");
    }
  }
  if (
    employeeIdBox.value.trim() != "" &&
    employeepasswordBox.value.trim() != ""
  ) {
    return true;
  } else {
    return false;
  }
}
