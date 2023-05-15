const colorButton = document.querySelector('.dropdown_button.color_button');
const colorMenu = document.querySelector('.color_menu');
const equipmentButton = document.querySelector('.dropdown_button.equipment_button');
const equipmentMenu = document.querySelector('.equipment_menu');

colorButton.addEventListener('mouseover', function () {
    colorMenu.style.display = 'block';
});

colorButton.addEventListener('mouseout', function () {
    colorMenu.style.display = 'none';
});

colorMenu.addEventListener('mouseout', function () {
    colorMenu.style.display = 'none';
});

equipmentButton.addEventListener('mouseover', function () {
    equipmentMenu.style.display = 'block';
});

equipmentButton.addEventListener('mouseout', function () {
    equipmentMenu.style.display = 'none';
});

equipmentMenu.addEventListener('mouseout', function () {
    equipmentMenu.style.display = 'none';
});
