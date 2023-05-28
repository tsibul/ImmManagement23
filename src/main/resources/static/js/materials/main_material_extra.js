function showColorGroup(obj) {
    const colorGroups = document.querySelectorAll(".color-group-values");
    const displayValue = obj.value === 'true' ? 'block' : 'none';

    colorGroups.forEach(function (colorGroup) {
        colorGroup.style.display = displayValue;
    });
}
function showColor(obj) {
    const selectedColor = obj.value;
    const colorOptions = document.querySelectorAll("#color option");

    colorOptions.forEach(function (option) {
        if (option.classList.contains("color-" + selectedColor)) {
            option.style.display = "block";
        } else {
            option.style.display = "none";
        }
    });
}

