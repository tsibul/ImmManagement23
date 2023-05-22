document.addEventListener("DOMContentLoaded", function() {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addMaterialTypeBtn = document.querySelector("#add-material-type-btn");

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const materialTypeId = this.dataset.materialtypeid;
        const materialTypeName = this.querySelector("[data-label='название']").textContent;
        const drying = this.querySelector("[data-label='сушка']").dataset.drying;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const materialTypeIdInput = modal.querySelector("#material-type-id");
        const materialTypeNameInput = modal.querySelector("#material-type-name");
        const dryingInput = modal.querySelector("#material-type-drying");


        modalTitle.textContent = "Редактировать тип";
        colorForm.setAttribute("action", "/materialtypes/addmaterial"); // Set the form action for editing

        materialTypeIdInput.value = materialTypeId;
        materialTypeNameInput.value = materialTypeName;
        dryingInput.value = drying;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const materialTypeIdInput = modal.querySelector("#material-type-id");
        const materialTypeNameInput = modal.querySelector("#material-type-name");
        const dryingInput = modal.querySelector("#material-type-drying");


        modalTitle.textContent = "Добавить тип";
        colorForm.setAttribute("action", "/materialtypes/addmaterial"); // Set the form action for adding

        materialTypeIdInput.value = 0;
        materialTypeNameInput.value = "";
        dryingInput.value = true;

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    colorRows.forEach(function(row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addMaterialTypeBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });
});
