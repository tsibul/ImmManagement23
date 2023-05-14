function showTech(showId) {
    var techObj = document.getElementById(showId);
    if (techObj.style.display === "block") {
        techObj.style.display = "none";
    } else {
        techObj.style.display = "block";
    }
}

function dropDownShow(showId) {
    document.getElementById(showId).classList.toggle("show");
}