let menuButtons = document.querySelectorAll('.menu-button');
menuButtons.forEach(menuListen);
function menuListen (item){
    item.addEventListener('mouseover', function (){
    document.getElementById(item.dataset.menu).style.display = 'block';});
    item.addEventListener('mouseout', function () {
        document.getElementById(item.dataset.menu).style.display = 'none';});
}
