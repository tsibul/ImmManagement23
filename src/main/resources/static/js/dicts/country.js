document.addEventListener("DOMContentLoaded", function() {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addCountryBtn = document.querySelector("#add-country-btn");

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const countryId = this.dataset.id;
        const countryName = this.querySelector("[data-label='название']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const countryIdInput = modal.querySelector("#country-id");
        const countryNameInput = modal.querySelector("#country-name");

        modalTitle.textContent = "Редактировать страну";
        colorForm.setAttribute("action", "/country/addcountry"); // Set the form action for editing

        countryIdInput.value = countryId;
        countryNameInput.value = countryName;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const countryIdInput = modal.querySelector("#country-id");
        const countryNameInput = modal.querySelector("#country-name");


        modalTitle.textContent = "Добавить страну";
        colorForm.setAttribute("action", "/country/addcountry"); // Set the form action for adding

        countryIdInput.value = 0;
        countryNameInput.value = "";

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    colorRows.forEach(function(row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addCountryBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });
});
