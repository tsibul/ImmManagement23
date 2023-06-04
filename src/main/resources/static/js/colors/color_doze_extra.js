function showColorByProductGroup(obj) {
    const selectedProduct = obj.value;
    const selectedColorOption = Array.from(obj.children).find(function (option) {
        return option.value == selectedProduct;
    });
    const selectedColor = selectedColorOption ? selectedColorOption.dataset.color : null;
    const colorOptions = document.querySelectorAll("#color option");

    colorOptions.forEach(function (option) {
        if (option.classList.contains("color-" + selectedColor)) {
            option.style.display = "block";
        } else {
            option.style.display = "none";
        }
    });
}
