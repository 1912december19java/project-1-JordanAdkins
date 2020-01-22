"use strict";

let thisName = getCookie("name");
let eid = getCookie("chk");

var loadFile = function(event) {
  var output = document.getElementById("receipt-upload-image");
  output.src = URL.createObjectURL(event.target.files[0]);
};

let submitButton = document.getElementById("sub-button");
submitButton.addEventListener("click", e => {
  if (checkForValidInput()) {
    document.getElementById("receipt-upload").disabled = true;
    document.getElementById("request-amount").disabled = true;
    document.getElementById("request-date").disabled = true;
    document.getElementById("pre-approval").disabled = true;
    document.getElementById("submission-message").innerText =
      "Submitting your request...";
    submitRequest();
    setTimeout(function(){
      document.getElementById("submission-message").innerText = "Request Posted!";
    document.getElementById("submission-message").classList.add("green");
  }, 3000);
  } else {
    console.log(false);
  }
});

async function submitRequest() {
  let data = new FormData();
  data.append("upload", document.getElementById("receipt-upload").files[0]);
  data.append("amount", document.getElementById("request-amount").value);
  data.append("date", document.getElementById("request-date").value);
  data.append("pre-approved", document.getElementById("pre-approval").value);
  data.append("name", thisName);
  data.append("eid", eid);

  const response = await fetch("http://Reimbursementportal-env.mm26zshb3w.us-east-1.elasticbeanstalk.com/upload", {
    method: "POST",
    body: data
  });
}

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(";");
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function checkForValidInput() {
  if (document.getElementById("receipt-upload").files[0] != null) {
    if (
      document.getElementById("receipt-upload").classList.contains("red-border")
    ) {
      document.getElementById("receipt-upload").classList.remove("red-border");
    }
  } else {
    if (
      !document
        .getElementById("receipt-upload")
        .classList.contains("red-border")
    ) {
      document.getElementById("receipt-upload").classList.add("red-border");
    }
  }

  if (document.getElementById("request-amount").value) {
    if (
      document.getElementById("request-amount").classList.contains("red-border")
    ) {
      document.getElementById("request-amount").classList.remove("red-border");
    }
  } else {
    if (
      !document
        .getElementById("request-amount")
        .classList.contains("red-border")
    ) {
      document.getElementById("request-amount").classList.add("red-border");
    }
  }

  if (document.getElementById("request-date").value) {
    if (
      document.getElementById("request-date").classList.contains("red-border")
    ) {
      document.getElementById("request-date").classList.remove("red-border");
    }
  } else {
    if (
      !document.getElementById("request-date").classList.contains("red-border")
    ) {
      document.getElementById("request-date").classList.add("red-border");
    }
  }

  if (document.getElementById("pre-approval").value) {
    if (
      document.getElementById("pre-approval").classList.contains("red-border")
    ) {
      document.getElementById("pre-approval").classList.remove("red-border");
    }
  } else {
    if (
      !document.getElementById("pre-approval").classList.contains("red-border")
    ) {
      document.getElementById("pre-approval").classList.add("red-border");
    }
  }

  if (
    document.getElementById("pre-approval").value &&
    document.getElementById("request-date").value &&
    document.getElementById("request-amount").value &&
    document.getElementById("receipt-upload").files[0] != null
  ) {
    return true;
  } else {
    return false;
  }
}
