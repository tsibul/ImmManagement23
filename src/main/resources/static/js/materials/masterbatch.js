// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const producersId = document.querySelector("#url-parameters").dataset.producersid;

function inputs(modal) {
    return {
        masterbatchId: modal.querySelector("#masterbatch-id"),
        masterbatchName: modal.querySelector("#masterbatch-name"),
        masterbatchColor: modal.querySelector("#masterbatch-color"),
        producerId: modal.querySelector("#producer")
    };
}

function fullData(row) {
    return {
        masterbatchId: row.dataset.masterbatchid,
        producerId: row.dataset.producerid,
        masterbatchName: row.querySelector("[data-label='название']").textContent,
        masterbatchColor: row.querySelector("[data-label='цвет']").textContent
    };
}

function emptyData() {
    return {
        masterbatchId: 0,
        producerId: producersId
    };
}

function action (){
    return "/masterbatch/" + producersId + "/add_masterbatch";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
