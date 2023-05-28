// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

function inputs(modal) {
    return {
        materialTypeId: modal.querySelector("#material-type-id"),
        materialTypeName: modal.querySelector("#material-type-name"),
        drying: modal.querySelector("#material-type-drying"),
        materialDryingTime: modal.querySelector("#material-drying-time"),
        materialDryingTemperature: modal.querySelector("#material-drying-temperature")
    };
}

function fullData(row) {
    return {
        materialTypeId: row.dataset.materialtypeid,
        materialTypeName: row.querySelector("[data-label='название']").textContent,
        drying: row.querySelector("[data-label='сушка']").dataset.drying,
        materialDryingTime: row.querySelector("[data-label='время сушки (ч)']").textContent,
        materialDryingTemperature: row.querySelector("[data-label='температура сушки']").textContent
    };
}

function emptyData() {
    return {
        materialTypeId: 0,
        drying: true,
        materialDryingTime: "0",
        materialDryingTemperature: "0"
    };
}

function action (){
    return "/materialtypes/addmaterial";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);

/*

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
        const materialDryingTime = this.querySelector("[data-label='время сушки (ч)']").textContent;
        const materialDryingTemperature = this.querySelector("[data-label='температура сушки']").textContent;

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const materialTypeIdInput = modal.querySelector("#material-type-id");
        const materialTypeNameInput = modal.querySelector("#material-type-name");
        const dryingInput = modal.querySelector("#material-type-drying");
        const materialDryingTimeInput = modal.querySelector("#material-drying-time");
        const materialDryingTemperatureInput = modal.querySelector("#material-drying-temperature");


        modalTitle.textContent = "Редактировать тип";
        colorForm.setAttribute("action", "/materialtypes/addmaterial"); // Set the form action for editing

        materialTypeIdInput.value = materialTypeId;
        materialTypeNameInput.value = materialTypeName;
        dryingInput.value = drying;
        materialDryingTimeInput.value = materialDryingTime;
        materialDryingTemperatureInput.value = materialDryingTemperature;

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
        const materialDryingTimeInput = modal.querySelector("#material-drying-time");
        const materialDryingTemperatureInput = modal.querySelector("#material-drying-temperature");


        modalTitle.textContent = "Добавить тип";
        colorForm.setAttribute("action", "/materialtypes/addmaterial"); // Set the form action for adding

        materialTypeIdInput.value = 0;
        materialTypeNameInput.value = "";
        dryingInput.value = true;
        materialDryingTimeInput.value = "";
        materialDryingTemperatureInput.value = "";

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

 */
