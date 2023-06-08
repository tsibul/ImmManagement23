function showBux(obj){
    const buxStrings = document.querySelectorAll(".bux");
    buxStrings.forEach(unShowToggle);
    obj.classList.toggle("button-cancel-pushed")
}

function showTech(obj){
    const techStrings = document.querySelectorAll(".tech");
    techStrings.forEach( unShowToggle);
    obj.classList.toggle("button-cancel-pushed")
}

function unShowToggle(node){
    node.classList.toggle("unshow")
}