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
