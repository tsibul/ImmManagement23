// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const productGroupsId = document.querySelector("#url-parameters").dataset.productgroupsid;


function inputs(modal) {
    return {
        productColorDozeId: modal.querySelector("#color-doze-id"),
        productGroup: modal.querySelector("#product-group"),
        masterBatch: modal.querySelector("#master-batch"),
        materialType: modal.querySelector("#material-type"),
        color: modal.querySelector("#color"),
        doze: modal.querySelector("#doze")
    };
}

function fullData(row) {
    return {
        productGroupsId: row.dataset.id,
        productGroup: row.querySelector("[data-label='группа продуктов']").dataset.id,
        masterBatch: row.querySelector("[data-label='суперконцентрат']").dataset.id,
        materialType: row.querySelector("[data-label='тип материала']").dataset.id,
        color: row.querySelector("[data-label='цвет']").dataset.id,
        doze: row.querySelector("[data-label='доза']").textContent
    };
}

function emptyData() {
    return {
        productGroupsId: 0,
        productGroup: productGroupsId,
    };
}

function action (){
    return "/color_doze/add_doze?productGroupsId=" + productGroupsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
