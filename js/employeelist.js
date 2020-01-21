"Use Strict";

const startingRow = document.getElementById("row-start");

getInfoForCards().then(data => {
    for (let i = 0; i < Object.keys(data).length; i++) {
        let convertedData = data[i];
        buildCard(convertedData.name, convertedData.team, convertedData.role, convertedData.profileUrl);
    }
});

async function getInfoForCards() {
  const response = await fetch(
    "http://Reimbursementportal-env.mm26zshb3w.us-east-1.elasticbeanstalk.com/employeelist"
  );
  return await response.json();
}


function buildCard(name, team, role, url) {
  let coldiv = document.createElement("div");
  coldiv.className = "col-lg-";
  let carddiv = document.createElement("div");
  carddiv.className = "card";
  let img = document.createElement("img");
  img.className = "card-img-top img-fluid";
  if (url != null) {
    img.src = url;
  } else {
    img.src = "/content/defaultuser.svg";
  }
  img.alt = "Employee Image";
  let bodydiv = document.createElement("div");
  bodydiv.className = "card-body";
  let h5 = document.createElement("h5");
  h5.className = "card-title";
  h5.textContent = name;
  let p1 = document.createElement("p");
  p1.className = "card-text card-team";
  p1.innerText = "Team: " + team;
  let p2 = document.createElement("p");
  p2.className = "card-text card-employee-level";
  p2.innerText = role;

  startingRow.appendChild(coldiv);
  coldiv.appendChild(carddiv);
  carddiv.appendChild(img);
  carddiv.appendChild(bodydiv);
  bodydiv.appendChild(h5);
  bodydiv.appendChild(p1);
  bodydiv.appendChild(p2);
}
