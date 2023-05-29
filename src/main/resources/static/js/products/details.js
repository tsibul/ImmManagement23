// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const materialTypesId = document.querySelector("#url-parameters").dataset.materialtypesid;
const productsId =document.querySelector("#url-parameters").dataset.producersid;

function inputs(modal) {
    return {
        detailId: modal.querySelector("#detail-id"),
        detailCode: modal.querySelector("#detail-code"),
        indexInProduct: modal.querySelector("#index-in-product"),
        detailName: modal.querySelector("#detail-name"),
        detailWeight: modal.querySelector("#detail-weight"),
        materialType: modal.querySelector("#material-type"),
        moldInsert: modal.querySelector("#mold-insert"),
        strokeWight: modal.querySelector("#stroke-weight"),
        gateWeight: modal.querySelector("#gate-weight"),
        quantityPerBox: modal.querySelector("#quantity-per-box")
    };
}

function fullData(row) {
    return {
        detailId: row.dataset.detailId,
        detailCode: row.querySelector("[data-label='артикул']").dataset.id,
        indexInProduct: row.querySelector("[data-label='индекс']").textContent,
        detailName: row.querySelector("[data-label='название']").textContent,
        detailWeight: row.querySelector("[data-label='вес, г']").textContent,
        materialType: row.querySelector("[data-label='материал']").dataset.id,
        moldInsert: row.querySelector("[data-label='пресс-форма']").dataset.id,
        strokeWight: row.querySelector("[data-label='вес впрыска']").textContent,
        gateWeight: row.querySelector("[data-label='вес литника']").textContent,
        quantityPerBox: row.querySelector("[data-label='кол-во в коробе']").textContent,
    };
}

function emptyData() {
    return {
        detailId: 0,
        detailCode: productsId,
        materialType: materialTypesId,
    };
}

function action (){
    return "/detail/add_detail?materialTypesId=" + materialTypesId + "&productsId=" + productsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
