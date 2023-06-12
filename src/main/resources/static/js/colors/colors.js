// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const colorGroupsId = document.querySelector("#url-parameters").dataset.colorgroupsid;

function inputs(modal) {
    return {
        colorId: modal.querySelector("#color-id"),
        colorCode: modal.querySelector("#color-code"),
        colorName: modal.querySelector("#color-name"),
        colorPantone: modal.querySelector("#color-pantone"),
        colorHEX: modal.querySelector("#color-hex"),
        colorGroupId: modal.querySelector("#color-group")
    };
}

function fullData(row) {
    return {
        colorId: row.dataset.colorid,
        colorGroupId: row.dataset.colorgroupid,
        colorCode: row.querySelector("[data-label='код цвета']").textContent,
        colorName: row.querySelector("[data-label='название']").textContent,
        colorPantone: row.querySelector("[data-label='pantone']").textContent,
        colorHEX: row.querySelector("[data-label='HEX']").textContent
    };
}

function emptyData(modal) {
    return {
        colorId: 0,
        colorGroupId: colorGroupsId
    };
}

function action (){
    return "/colors/" + colorGroupsId + '/addcolor';
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
