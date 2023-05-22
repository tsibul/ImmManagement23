document.addEventListener("DOMContentLoaded", function() {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addColorBtn = document.querySelector("#add-color-btn");

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const colorGroupId = this.dataset.colorgroupid;
        const colorGroupName = this.querySelector("[data-label='название']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const colorGroupIdInput = modal.querySelector("#color-group-id");
        const colorGroupNameInput = modal.querySelector("#color-group-name");

        modalTitle.textContent = "Редактировать группу";
        colorForm.setAttribute("action", "/colorgroups/addcolorgroup"); // Set the form action for editing

        colorGroupIdInput.value = colorGroupId;
        colorGroupNameInput.value = colorGroupName;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const colorGroupIdInput = modal.querySelector("#color-group-id");
        const colorGroupNameInput = modal.querySelector("#color-group-name");


        modalTitle.textContent = "Добавить группу";
        colorForm.setAttribute("action", "/colorgroups/addcolorgroup"); // Set the form action for adding

        colorGroupIdInput.value = 0;
        colorGroupNameInput.value = "";

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
