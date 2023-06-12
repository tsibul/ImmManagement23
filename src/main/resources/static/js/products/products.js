// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const productGroupsId = document.querySelector("#url-parameters").dataset.productgroupsid;

function inputs(modal) {
    return {
        productId: modal.querySelector("#product-id"),
        productCode: modal.querySelector("#product-code"),
        productName: modal.querySelector("#product-name"),
        numberDetails: modal.querySelector("#number-details"),
        productGroup: modal.querySelector("#product-group")
    };
}

function fullData(row) {
    return {
        productId: row.dataset.productid,
        productCode: row.querySelector("[data-label='артикул']").textContent,
        productName: row.querySelector("[data-label='название']").textContent,
        numberDetails: row.querySelector("[data-label='кол-во деталей']").textContent,
        productGroup: row.querySelector("[data-label='группа товара']").dataset.id
    };
}

function emptyData(modal) {
    return {
        productId: 0,
        productGroup: productGroupsId
    };
}

function action() {
    return "/products/addproduct?productGroupsId=" + productGroupsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);

