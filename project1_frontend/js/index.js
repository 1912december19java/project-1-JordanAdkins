"use strict";

let submitButton = document.getElementById("login-submit");
let employeeIdBox = document.getElementById("employee-login-id");
let employeepasswordBox = document.getElementById("employee-login-password");
let loginData = { employeeId: "", password: "" };

submitButton.addEventListener("click", e => {
  if (checkForValidInput()) {
    attemptlogin();
  }
});

document.addEventListener("keypress", e => {
  if (e.key == "Enter") {
    if (checkForValidInput()) {
      attemptlogin();
    }
  }
});

async function attemptlogin() {
  fetch("http://localhost:8080/reimbursement/login", {
    method: "POST",
    body: JSON.stringify(loginData)
  })
    .then(res => res.json())
    .catch(error => {
      console.error("Error:", error);
    })
    .then(response => {
      console.log(response);
    });
}

function checkForValidInput() {
  if (employeeIdBox.value.trim() != "") {
    loginData.employeeId = employeeIdBox.value;
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
