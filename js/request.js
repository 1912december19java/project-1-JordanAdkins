"use strict"

  var loadFile = function(event) {
    var output = document.getElementById('receipt-upload-image');
    output.src = URL.createObjectURL(event.target.files[0]);
  };

  
  async function submitRequest(data){
      const formData = new FormData();

      for(const name in data) {
          formData.append(name, data[name]);
      }
      const response = await fetch("http://localhost:8080/reimbutsement/upload", {
        method: "POST",
        body: formData
      });
  }