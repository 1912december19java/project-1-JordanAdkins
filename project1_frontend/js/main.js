"use strict";

let navbarLinks = document.getElementsByClassName("nav-link animated nav-anime");
const navbarLinksConst = Array.prototype.slice.call(
  document.getElementsByClassName("nav-link animated nav-anime")
);

for (let i = 0; i < navbarLinksConst.length; i++) {
    navbarLinksConst[i].addEventListener("mouseover", e => {
        mouseOverNavAnimationPlay(i);
      });
      navbarLinksConst[i].addEventListener("animationend", e => {
        mouseOverNavAnimationReset(i);
      });
}

function mouseOverNavAnimationPlay(index) {
  if (navbarLinksConst[index].className === "nav-link animated nav-anime") {
    navbarLinksConst[index].classList.replace("nav-anime", "bounce");
  } 
  else if (navbarLinksConst[index].className === "nav-link employee-unique animated nav-anime"){
    navbarLinksConst[index].classList.replace("nav-anime", "bounce");
  }
}

function mouseOverNavAnimationReset(index){
    if (navbarLinksConst[index].className === "nav-link animated bounce") {
        navbarLinksConst[index].classList.replace("bounce", "nav-anime");
      }
      else if(navbarLinksConst[index].className === "nav-link employee-unique animated bounce"){
        navbarLinksConst[index].classList.replace("bounce", "nav-anime");
      }
}