function log() {
  // time
  const inputElem = document.getElementById("input");
  const msg = inputElem.value;
  var year = new Date().getFullYear();
  var month = new Date().getMonth();
  var day = new Date().getDate();
  var hours = new Date().getHours();
  var minutes = new Date().getMinutes();
  var seconds = new Date().getSeconds();
  var milliseconds = new Date().getMilliseconds();
  var time =
    day +
    "/" +
    month +
    "/" +
    year +
    " | " +
    hours +
    ":" +
    minutes +
    ":" +
    seconds +
    ":" +
    milliseconds;

  let message = String(time + " " + msg + "<br>");

  // print to console
  console.log(message);

  // display message on page
  var output = document.getElementById("output");
  output.innerHTML += message;
}

function toggleContent(id) {
  var contentDiv = document.getElementById(id);
  if (contentDiv.style.display === "none") {
    contentDiv.style.display = "block";
  } else {
    contentDiv.style.display = "none";
  }
}
