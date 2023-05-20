document.addEventListener("DOMContentLoaded", function() {
    const tableRows = document.querySelectorAll(".table-row");
    const modal = document.querySelector("#product-modal");
    const closeModalBtn = modal.querySelector("#close-button");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addProductBtn = document.querySelector("#add-product-btn");

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const productId = this.dataset.productid;
        const productCode = this.querySelector("[data-label='артикул']").textContent;
        const productName = this.querySelector("[data-label='название']").textContent;
        const numberDetails = this.querySelector("[data-label='кол-во деталей']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const productForm = modal.querySelector("#product-form");
        const productIdInput = modal.querySelector("#product-id");
        const productCodeInput = modal.querySelector("#product-code");
        const productNameInput = modal.querySelector("#product-name");
        const numberDetailsInput = modal.querySelector("#number-details");

        modalTitle.textContent = "Редактировать продукцию";
        productForm.setAttribute("action", "/products/addproduct"); // Set the form action for editing

        productIdInput.value = productId;
        productCodeInput.value = productCode;
        productNameInput.value = productName;
        numberDetailsInput.value = numberDetails;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const productForm = modal.querySelector("#product-form");
        const productIdInput = modal.querySelector("#product-id");
        const productCodeInput = modal.querySelector("#product-code");
        const productNameInput = modal.querySelector("#product-name");
        const numberDetailsInput = modal.querySelector("#number-details");

        modalTitle.textContent = "Добавить продукцию";
        productForm.setAttribute("action", "/products/addproduct"); // Set the form action for adding

        productIdInput.value = 0;
        productCodeInput.value = "";
        productNameInput.value = "";
        numberDetailsInput.value = "";

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    tableRows.forEach(function(row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addProductBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });
});
