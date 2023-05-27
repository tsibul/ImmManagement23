document.addEventListener("DOMContentLoaded", function () {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addColorBtn = document.querySelector("#add-color-btn");
    const colorGroupsId = document.querySelector("#url-parameters").dataset.colorgroupsid;

    // Function to open the modal for editing
    function openEditModal(titleText, colorId, colorGroupId, colorCode, colorName, colorPantone, colorHEX) {

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const colorIdInput = modal.querySelector("#color-id");
        const colorCodeInput = modal.querySelector("#color-code");
        const colorNameInput = modal.querySelector("#color-name");
        const colorPantoneInput = modal.querySelector("#color-pantone");
        const colorHEXInput = modal.querySelector("#color-hex");
        const colorGroupInput = modal.querySelector("#color-group");

        modalTitle.textContent = titleText;
        colorForm.setAttribute("action", "/colors/" + colorGroupsId + '/addcolor'); // Set the form action for editing

        colorIdInput.value = colorId;
        colorCodeInput.value = colorCode;
        colorNameInput.value = colorName;
        colorPantoneInput.value = colorPantone;
        colorHEXInput.value = colorHEX;
        colorGroupInput.value = colorGroupId;

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    colorRows.forEach(function (row) {
        row.addEventListener("click", () => {
            // Get the data from the clicked row
            const colorId = row.dataset.colorid;
            const colorGroupId = row.dataset.colorgroupid;
            const colorCode = row.querySelector("[data-label='код цвета']").textContent;
            const colorName = row.querySelector("[data-label='название']").textContent;
            const colorPantone = row.querySelector("[data-label='pantone']").textContent;
            const colorHEX = row.querySelector("[data-label='HEX']").textContent;
            const titleText = "Редактировать цвет";
            openEditModal(titleText, colorId, colorGroupId, colorCode, colorName, colorPantone, colorHEX);
        });
    });

    // Open the modal for adding a new color when the button is clicked
    addColorBtn.addEventListener("click", () => {
        const colorId = 0;
        const colorCode = "";
        const colorName = "";
        const colorPantone = "";
        const colorHEX = "";
        const colorGroupId = colorGroupsId;
        const titleText = "Добавить цвет";
        openEditModal(titleText, colorId, colorGroupId, colorCode, colorName, colorPantone, colorHEX);
    });

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });
});
