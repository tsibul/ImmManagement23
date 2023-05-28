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

