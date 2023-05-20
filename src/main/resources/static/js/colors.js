document.addEventListener("DOMContentLoaded", function() {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addColorBtn = document.querySelector("#add-color-btn");

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const colorId = this.dataset.colorid;
        const colorGroupId = this.dataset.colorgroupid;
        const colorCode = this.querySelector("[data-label='код цвета']").textContent;
        const colorName = this.querySelector("[data-label='название']").textContent;
        const colorPantone = this.querySelector("[data-label='pantone']").textContent;
        const colorHEX = this.querySelector("[data-label='HEX']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const colorIdInput = modal.querySelector("#color-id");
        const colorCodeInput = modal.querySelector("#color-code");
        const colorNameInput = modal.querySelector("#color-name");
        const colorPantoneInput = modal.querySelector("#color-pantone");
        const colorHEXInput = modal.querySelector("#color-hex");

        modalTitle.textContent = "Редактировать цвет";
        colorForm.setAttribute("action", "/colors/" + colorGroupId + '/addcolor'); // Set the form action for editing

        colorIdInput.value = colorId;
        colorCodeInput.value = colorCode;
        colorNameInput.value = colorName;
        colorPantoneInput.value = colorPantone;
        colorHEXInput.value = colorHEX;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const colorIdInput = modal.querySelector("#color-id");
        const colorCodeInput = modal.querySelector("#color-code");
        const colorNameInput = modal.querySelector("#color-name");
        const colorPantoneInput = modal.querySelector("#color-pantone");
        const colorHEXInput = modal.querySelector("#color-hex");
        const colorGroupId = this.dataset.colorgroupid;


        modalTitle.textContent = "Добавить цвет";
        colorForm.setAttribute("action", "/colors/" + colorGroupId + '/addcolor'); // Set the form action for adding

        colorIdInput.value = 0;
        colorCodeInput.value = "";
        colorNameInput.value = "";
        colorPantoneInput.value = "";
        colorHEXInput.value = "";

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    colorRows.forEach(function(row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addColorBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });
});
