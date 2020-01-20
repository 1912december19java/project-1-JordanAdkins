"use strict";


  let bosuchk = document.cookie.indexOf("bosu=");

  if (bosuchk != -1) {
    console.log("all good!");
  } else {
    while (document.getElementById("mspec")) {
      let helem = document.getElementById("mspec");
      helem.remove();
    }
  }