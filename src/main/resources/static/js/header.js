const dropDownButtons = document.querySelectorAll(".dropdown_button")
dropDownButtons.forEach(function (button) {
    button.addEventListener("mouseenter", () => {
        const dropDownMenu = button.querySelector(".dropdown_menu")
        dropDownMenu.style.display = 'block';
    });
    button.addEventListener("mouseleave", function () {
        const dropDownMenu = button.querySelector(".dropdown_menu");
        dropDownMenu.style.display = 'none';
    });
    const dropButtons = button.querySelectorAll(".drop_button");
    dropButtons.forEach(function (dropButton) {
        dropButton.addEventListener("click", function (event) {
            if (!event.target.closest(".sub-menu-button")) {
                event.preventDefault();
                let allSubMenuButtons = document.querySelectorAll(".sub-menu");
                allSubMenuButtons.forEach(function (subMenuItem) {
                    if (subMenuItem !== dropButton.querySelector(".sub-menu")) subMenuItem.style.display = 'none';
                });
                const subMenuButtons = dropButton.querySelector(".sub-menu");
                subMenuButtons.style.display = subMenuButtons.style.display === 'block' ? 'none' : 'block';
            }
        });
    });
});

function subMenuButtons(inputObj) {
    /*

    let allSubMenuButtons = document.querySelectorAll(".sub-menu-item");
    allSubMenuButtons.forEach(function (subMenuItem){
        subMenuItem.style.display = 'none';
    } );
    const subMenuButtons = inputObj.querySelector(".sub-menu-item");
    subMenuButtons.style.display = 'block';
     */

}