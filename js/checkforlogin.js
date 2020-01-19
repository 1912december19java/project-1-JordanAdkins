
let loginCheck = document.cookie.indexOf('chk=');
const loginUrl = "index.html"


if(loginCheck == -1){
  window.location.href = loginUrl;
}