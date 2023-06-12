// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const colorGroupsId = document.querySelector("#url-parameters").dataset.colorgroupsid;


function inputs(modal) {
    return {
        productGroupId: modal.querySelector("#product-group-id"),
        productGroupName: modal.querySelector("#product-group-name"),
        colorGroupId: modal.querySelector("#color-group"),
    };
}

function fullData(row) {
    return {
        productGroupId: row.dataset.productgroupid,
        productGroupName: row.querySelector("[data-label='название']").textContent,
        colorGroupId: row.querySelector("[data-label='группа цветов']").dataset.id
    };
}

function emptyData(modal) {
    return {
        productGroupId: 0,
        colorGroupId: colorGroupsId
    };
}

function action (){
    return "/product_group/add_product_group?colorGroupsId=" + colorGroupsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
