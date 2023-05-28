// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const materialTypesId = document.querySelector("#url-parameters").dataset.materialtypesid;
const producersId = document.querySelector("#url-parameters").dataset.producersid;

function inputs(modal) {
    return {
        materialId: modal.querySelector("#main-material-id"),
        materialName: modal.querySelector("#main-material-name"),
        materialTypeId: modal.querySelector("#material-type"),
        ifColor: modal.querySelector("#if-color"),
        colorId: modal.querySelector("#color"),
        colorGroupId: modal.querySelector("#color-group"),
        ifReused: modal.querySelector("#if-reused"),
        producerId: modal.querySelector("#producer")
    };
}

function fullData(row) {
    return {
        materialId: row.dataset.mainmaterialid,
        materialName: row.querySelector("[data-label='название']").textContent,
        materialTypeId: row.querySelector("[data-label='тип материала']").dataset.id,
        ifColor: row.querySelector("[data-label='цветной']").dataset.id,
        colorId: row.querySelector("[data-label='цвет']").dataset.id,
        colorGroupId: row.querySelector("[data-label='группа цветов']").dataset.id,
        ifReused: row.querySelector("[data-label='вторичка']").dataset.id,
        producerId: row.querySelector("[data-label='производитель']").dataset.id,
    };
}

function emptyData() {
    return {
        materialId: 0,
        materialTypeId: materialTypesId,
        ifColor: false,
        ifReused: true,
        producerId: producersId,
    };
}

function action() {
    return "/main_material/add_main_material?materialTypesId=" + materialTypesId + "&producersId=" + producersId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
/*
document.addEventListener("DOMContentLoaded", function () {
    const tableRows = document.querySelectorAll(".table-row");
    const modal = document.querySelector("#product-modal");
    const closeModalBtn = modal.querySelector("#close-button");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addProductBtn = document.querySelector("#add-material-btn");
    const materialTypesId = document.querySelector("#url-parameters").dataset.materiialtypesid;
    const producersId = document.querySelector("#url-parameters").dataset.producersid;

    // Function to open the modal for editing
    function openEditModal() {
        // Get the data from the clicked row
        const materialId = this.dataset.mainmaterialid;
        const materialName = this.querySelector("[data-label='название']").textContent;
        const materialTypeId = this.querySelector("[data-label='тип материала']").dataset.id;
        const ifColor = this.querySelector("[data-label='цветной']").value;
        const colorId = this.querySelector("[data-label='цвет']").dataset.id;
        const colorGroupId = this.querySelector("[data-label='группа цветов']").dataset.id;
        const ifReused = this.querySelector("[data-label='вторичка']").value;
        const producerId = this.querySelector("[data-label='производитель']").dataset.id;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const productForm = modal.querySelector("#product-form");

        const materialIdInput = modal.querySelector("#main-material-id");
        const materialNameInput = modal.querySelector("#main-material-name");
        const materialTypeIdInput = modal.querySelector("#material-type");
        const ifColorInput = modal.querySelector("#ifcolor");
        const colorIdInput = modal.querySelector("#color");
        const colorGroupIdInput = modal.querySelector("#color-group");
        const ifReusedInput = modal.querySelector("#if-reused");
        const producerIdInput = modal.querySelector("#producer");

        modalTitle.textContent = "Редактировать сырье";
        productForm.setAttribute("action", "/main_material/add_main_material?materialTypesId=" +
            materialTypesId + "&producersId=" + producersId); // Set the form action for editing

        materialIdInput.value = materialId;
        materialNameInput.value = materialName;
        materialTypeIdInput.value = materialTypeId;
        ifColorInput.value = ifColor;
        colorIdInput.value = colorId;
        colorGroupIdInput.value = colorGroupId;
        ifReusedInput.value = ifReused;
        producerIdInput.value = producerId;

        // Open the modal
        modal.style.display = "block";
    }

    // Function to open the modal for adding a new color
    function openAddModal() {
        const modalTitle = modal.querySelector("#modal-title");
        const productForm = modal.querySelector("#product-form");

        const materialIdInput = modal.querySelector("#main-material-id");
        const materialNameInput = modal.querySelector("#main-material-name");
        const materialTypeIdInput = modal.querySelector("#material-type");
        const ifColorInput = modal.querySelector("#ifcolor");
        const colorIdInput = modal.querySelector("#color");
        const colorGroupIdInput = modal.querySelector("#color-group");
        const ifReusedInput = modal.querySelector("#if-reused");
        const producerIdInput = modal.querySelector("#producer");

        modalTitle.textContent = "Добавить сырье";
        productForm.setAttribute("action", "/main_material/add_main_material?materialTypesId=" +
            materialTypesId + "&producersId=" + producersId); // Set the form action for editing

        materialIdInput.value = 0;
        materialNameInput.value = "";
        materialTypeIdInput.value = materialTypesId;
        ifColorInput.value = false;
        colorIdInput.value = 0;
        colorGroupIdInput.value = 0;
        ifReusedInput.value = true;
        producerIdInput.value = producersId;


        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    tableRows.forEach(function (row) {
        row.addEventListener("click", openEditModal);
    });

    // Open the modal for adding a new color when the button is clicked
    addProductBtn.addEventListener("click", openAddModal);

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });
});


 */