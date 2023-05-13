function showTech(showId){
    var techObj = document.getElementById(showId);
    if(techObj.style.display == "none"){
        techObj.style.display = "flex";
    }
    else {
        techObj.style.display = "none";
    }
}