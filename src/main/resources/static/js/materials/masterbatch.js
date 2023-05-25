document.addEventListener("DOMContentLoaded", function() {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addColorBtn = document.querySelector("#add-masterbatch-btn");
    const producersId = document.querySelector("#url-parameters").dataset.producersid;

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const masterbatchId = this.dataset.masterbatchid;
        const producerId = this.dataset.producerid;
        const masterbatchName = this.querySelector("[data-label='название']").textContent;
        const masterbatchColor = this.querySelector("[data-label='цвет']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const masterbatchIdInput = modal.querySelector("#masterbatch-id");
        const masterbatchNameInput = modal.querySelector("#masterbatch-name");
        const masterbatchColorInput = modal.querySelector("#masterbatch-color");
        const producerInput = modal.querySelector("#producer");

        modalTitle.textContent = "Редактировать суперконцентрат";
        colorForm.setAttribute("action", "/masterbatch/" + producerId + '/add_masterbatch'); // Set the form action for editing

        masterbatchIdInput.value = masterbatchId;
        masterbatchNameInput.value = masterbatchName;
        masterbatchColorInput.value = masterbatchColor;
        producerInput.value =producerId;
        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const masterbatchIdInput = modal.querySelector("#masterbatch-id");
        const masterbatchNameInput = modal.querySelector("#masterbatch-name");
        const masterbatchColorInput = modal.querySelector("#masterbatch-color");
        const producerInput = modal.querySelector("#producer");
        const producerId = this.dataset.producerid;

        modalTitle.textContent = "Добавить суперконцентрат";
        colorForm.setAttribute("action", "/masterbatch/" + producerId + '/add_masterbatch'); // Set the form action for editing

        masterbatchIdInput.value = 0;
        masterbatchNameInput.value = "";
        masterbatchColorInput.value = "";
        producerInput.value = producersId;

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
