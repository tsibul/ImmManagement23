// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

function inputs(modal) {
    return {
        productGroupId: modal.querySelector("#product-group-id"),
        productGroupName: modal.querySelector("#product-group-name")
    };
}

function fullData(row) {
    return {
        productGroupId: row.dataset.productgroupid,
        productGroupName: row.querySelector("[data-label='название']").textContent
    };
}

function emptyData() {
    return {
        productGroupId: 0,
    };
}

function action (){
    return "product_group/add_product_group";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
