document.addEventListener("DOMContentLoaded", function() {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addProducerTypeBtn = document.querySelector("#add-producer-type-btn");

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const producerTypeId = this.dataset.producertypeid;
        const producerTypeName = this.querySelector("[data-label='тип']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const producerTypeIdInput = modal.querySelector("#producer-type-id");
        const producerTypeNameInput = modal.querySelector("#producer-type-name");

        modalTitle.textContent = "Редактировать тип";
        colorForm.setAttribute("action", "/producer_type/add_producer_type"); // Set the form action for editing

        producerTypeIdInput.value = producerTypeId;
        producerTypeNameInput.value = producerTypeName;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const producerTypeIdInput = modal.querySelector("#producer-type-id");
        const producerTypeNameInput = modal.querySelector("#producer-type-name");


        modalTitle.textContent = "Добавить тип";
        colorForm.setAttribute("action", "/producer_type/add_producer_type"); // Set the form action for adding

        producerTypeIdInput.value = 0;
        producerTypeNameInput.value = "";

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    colorRows.forEach(function(row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addProducerTypeBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });
});
