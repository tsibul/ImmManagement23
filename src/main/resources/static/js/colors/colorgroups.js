// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

function inputs(modal) {
    return {
        colorGroupId: modal.querySelector("#color-group-id"),
        colorGroupName: modal.querySelector("#color-group-name")
    };
}

function fullData(row) {
    return {
        colorGroupId: row.dataset.colorgroupid,
        colorGroupName: row.querySelector("[data-label='название']").textContent

    };
}

function emptyData() {
    return {
        colorGroupIdId: 0,
    };
}

function action (){
    return "/colorgroups/addcolorgroup";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);


