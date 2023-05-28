document.addEventListener("DOMContentLoaded", function () {
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addColorBtn = document.querySelector("#add-color-btn");
    const colorGroupsId = document.querySelector("#url-parameters").dataset.colorgroupsid;

    const inputs = {
        colorId: modal.querySelector("#color-id"),
        colorCode: modal.querySelector("#color-code"),
        colorName: modal.querySelector("#color-name"),
        colorPantone: modal.querySelector("#color-pantone"),
        colorHEX: modal.querySelector("#color-hex"),
        colorGroupId: modal.querySelector("#color-group")
    };

    // Function to open the modal for editing
    function openEditModal(titleText, modalData) {

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        modalTitle.textContent = titleText;
        colorForm.setAttribute("action", "/colors/" + colorGroupsId + '/addcolor'); // Set the form action for editing

        for (const key in inputs) {
            inputs[key].value = modalData[key] || "";
        }

        // Open the modal
        modal.style.display = "block";
    }

    // Add click event listener to each color row
    colorRows.forEach(function (row) {
        row.addEventListener("click", () => {
            // Get the data from the clicked row
            const modalData = fullData(row);
            const titleText = "Редактировать цвет";
            openEditModal(titleText, modalData);
        });
    });

    // Open the modal for adding a new color when the button is clicked
    addColorBtn.addEventListener("click", () => {
        const modalData = emptyData(colorGroupsId)
        const titleText = "Добавить цвет";
        openEditModal(titleText, modalData);
    });

    // Close the modal when the close button is clicked
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close the modal when the cancel button is clicked
    cancelBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });
});

function fullData(row) {
    return {
        colorId: row.dataset.colorid,
        colorGroupId: row.dataset.colorgroupid,
        colorCode: row.querySelector("[data-label='код цвета']").textContent,
        colorName: row.querySelector("[data-label='название']").textContent,
        colorPantone: row.querySelector("[data-label='pantone']").textContent,
        colorHEX: row.querySelector("[data-label='HEX']").textContent
    }
}

function emptyData(colorGroupsId){
    return {
        colorId: 0,
        colorGroupId: colorGroupsId
    }
}