// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const productsId = document.querySelector("#url-parameters").dataset.productsid;

function inputs(modal) {
    return {
        detailToProductId: modal.querySelector("#product-id"),
        detail: modal.querySelector("#detail-group"),
        product: modal.querySelector("#product-group"),
    };
}

function fullData(row) {
    return {
        detailToProductId: row.dataset.productid,
        detail: row.querySelector("[data-label='продукт артикул']").dataset.id,
        product: row.querySelector("[data-label='деталь код']").dataset.id
    };
}

function emptyData() {
    return {
        detailToProductId: 0,
        product: productsId
    };
}

function action() {
    return "/detail_to_product/add_detail_to_product?&productsId=" + productsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);

