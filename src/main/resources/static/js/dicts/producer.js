// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const countriesId = document.querySelector("#url-parameters").dataset.countryid;
const producerTypesId = document.querySelector("#url-parameters").dataset.producertypeid;

function inputs(modal) {
    return {
        producerId: modal.querySelector("#producer-id"),
        producerName: modal.querySelector("#producer-name"),
        country: modal.querySelector("#country"),
        producerType: modal.querySelector("#producer-type"),
    };
}

function fullData(row) {
    return {
        producerId: row.dataset.producerid,
        producerName: row.querySelector("[data-label='название']").textContent,
        country: row.querySelector("[data-label='страна']").dataset.id,
        producerType: row.querySelector("[data-label='специализация']").dataset.id,
    };
}

function emptyData() {
    return {
        producerId: 0,
        country: countriesId,
        producerType: producerTypesId
    };
}

function action() {
    return "/producer/add_producer?countryId=" + countriesId + "&producerTypesId=" + producerTypesId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);

