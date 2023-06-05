function showBux(){
    const buxStrings = document.querySelectorAll(".bux");
    buxStrings.forEach(unShowToggle);
}

function showTech(){
    const techStrings = document.querySelectorAll(".tech");
    techStrings.forEach( unShowToggle);
}

function unShowToggle(node){
    node.classList.toggle("unshow")
}