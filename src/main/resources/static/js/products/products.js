// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const colorGroupsId = document.querySelector("#url-parameters").dataset.colorgroupsid;
const productGroupsId = document.querySelector("#url-parameters").dataset.productgroupsid;

function inputs(modal) {
    return {
        productId: modal.querySelector("#product-id"),
        productCode: modal.querySelector("#product-code"),
        productName: modal.querySelector("#product-name"),
        numberDetails: modal.querySelector("#number-details"),
        colorGroup: modal.querySelector("#color-group"),
        productGroup: modal.querySelector("#product-group")
    };
}

function fullData(row) {
    return {
        productId: row.dataset.productid,
        productCode: row.querySelector("[data-label='артикул']").textContent,
        productName: row.querySelector("[data-label='название']").textContent,
        numberDetails: row.querySelector("[data-label='кол-во деталей']").textContent,
        colorGroup: row.querySelector("[data-label='группа цветов']").dataset.id,
        productGroup: row.querySelector("[data-label='группа товара']").dataset.id
    };
}

function emptyData() {
    return {
        productId: 0,
        colorGroup: colorGroupsId,
        productGroup: productGroupsId
    };
}

function action() {
    return "/products/addproduct?colorGroupsId=" + colorGroupsId + "&productGroupsId=" + productGroupsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);

