document.addEventListener("DOMContentLoaded", function () {
    const tableRows = document.querySelectorAll(".table-row");
    const modal = document.querySelector("#producer-modal");
    const closeModalBtn = modal.querySelector("#close-button");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addProducerBtn = document.querySelector("#add-producer-btn");
    const countriesId = document.querySelector("#url-parameters").dataset.countryid;
    const producerTypesId = document.querySelector("#url-parameters").dataset.producertypeid;

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const producerId = this.dataset.producerid;
        const producerName = this.querySelector("[data-label='название']").textContent;
        const country = this.querySelector("[data-label='страна']").dataset.id;
        const producerType = this.querySelector("[data-label='специализация']").dataset.id;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const productForm = modal.querySelector("#product-form");
        const producerIdInput = modal.querySelector("#producer-id");
        const producerNameInput = modal.querySelector("#producer-name");
        const countryInput = modal.querySelector("#country");
        const producerTypeInput = modal.querySelector("#producer-type");

        modalTitle.textContent = "Редактировать производителя";
        productForm.setAttribute("action", "/producer/add_producer?countryId=" +
            countriesId + "&producerTypeId=" + producerTypesId); // Set the form action for editing

        producerIdInput.value = producerId;
        producerNameInput.value = producerName;
        countryInput.value = country;
        producerTypeInput.value = producerType;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const productForm = modal.querySelector("#product-form");
        const producerIdInput = modal.querySelector("#producer-id");
        const producerNameInput = modal.querySelector("#producer-name");
        const countryInput = modal.querySelector("#country");
        const producerTypeInput = modal.querySelector("#producer-type");

        modalTitle.textContent = "Добавить производителя";
        productForm.setAttribute("action", "/producer/add_producer?countryId=" +
            countriesId + "&producerTypeId=" + producerTypesId); // Set the form action for editing

        producerIdInput.value = 0;
        producerNameInput.value = "";
        countryInput.value = 0;
        producerTypeInput.value = 0;

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    tableRows.forEach(function (row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addProducerBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });
});
