
let loginCheck = document.cookie.indexOf('chk=');
const loginUrl = "index.html"


if(loginCheck == -1){
  window.location.href = loginUrl;
}else{

  // addScript ("/js/mvis.js");
 
}

// function addScript( src ) {
//   var s = document.createElement( 'script' );
//   s.setAttribute( 'src', src );
//   document.head.appendChild( s );
// }