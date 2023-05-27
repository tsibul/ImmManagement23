document.addEventListener("DOMContentLoaded", function () {
    // Получаем необходимые элементы
    const colorRows = document.querySelectorAll(".color-row");
    const modal = document.querySelector(".modal");
    const closeModalBtn = modal.querySelector(".close");
    const cancelBtn = modal.querySelector("#cancel-btn");
    const addColorBtn = document.querySelector("#add-color-btn");

    // Функция для открытия модального окна для редактирования или добавления
    function openEditModal(titleText, colorGroupId, colorGroupName) {
        // Получаем необходимые элементы модального окна
        const modalTitle = modal.querySelector("#modal-title");
        const colorForm = modal.querySelector("#color-form");
        const colorGroupIdInput = modal.querySelector("#color-group-id");
        const colorGroupNameInput = modal.querySelector("#color-group-name");

        modalTitle.textContent = titleText;
        colorGroupIdInput.value = colorGroupId;
        colorGroupNameInput.value = colorGroupName;

        colorForm.setAttribute("action", "/colorgroups/addcolorgroup");
        modal.style.display = "block";
    }

    // Добавляем обработчики событий click для каждой строки цвета
    colorRows.forEach((row) => {
        row.addEventListener("click", () => {
            const titleText = "Редактировать группу"
            const colorGroupId = row.dataset.colorgroupid;
            const colorGroupName = row.querySelector("[data-label='название']").textContent;
            openEditModal(titleText, colorGroupId, colorGroupName);
        });
    });

    // Добавляем обработчик события click для кнопки добавления цвета
    addColorBtn.addEventListener("click", () => {
        const titleText = "Добавить группу"
        const colorGroupId = 0;
        const colorGroupName = "";
        openEditModal(titleText, colorGroupId, colorGroupName);
    });

    // Закрываем модальное окно при клике на кнопку закрытия
    closeModalBtn.addEventListener("click", () => {
        modal.style.display = "none";
    });

    // Закрываем модальное окно при клике на кнопку отмены
    cancelBtn.addEventListener("click", () => {
        modal.style.display = "none";
    });
});
