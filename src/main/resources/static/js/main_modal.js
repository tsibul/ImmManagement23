// Определяем функцию initialize, которую будем использовать для инициализации модуля
function initialize(inputsFn, emptyDataFn, fullDataFn, actionFn) {
    const modalRows = document.querySelectorAll(".modal-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addBtn = document.querySelector("#add-btn");

// Function to open the modal for editing
    function openEditModal(titleText, modalData) {

        // Populate the modal fields with the data
        const modalTitle = modal.querySelector("#modal-title");
        const modalForm = modal.querySelector("#modal-form");
        modalTitle.textContent = titleText;
        modalForm.setAttribute("action", actionFn()); // Set the form action for editing

        for (const key in inputsFn(modal)) {
            inputsFn(modal)[key].value = modalData[key] || "";
        }

        // Open the modal
        modal.style.display = "block";
    }

// Add click event listener to each color row
    modalRows.forEach(function (row) {
        row.addEventListener("click", () => {
            // Get the data from the clicked row
            const modalData = fullDataFn(row);
            const titleText = "Редактировать";
            openEditModal(titleText, modalData);
        });
    });

// Open the modal for adding a new color when the button is clicked
    addBtn.addEventListener("click", () => {
        const modalData = emptyDataFn(modal)
        const titleText = "Добавить";
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
}
export default initialize;



