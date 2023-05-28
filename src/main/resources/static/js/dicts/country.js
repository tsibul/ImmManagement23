// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

function inputs(modal) {
    return {
        countryId: modal.querySelector("#country-id"),
        countryName: modal.querySelector("#country-name")
    };
}

function fullData(row) {
    return {
        countryId: row.dataset.colorgroupid,
        countryName: row.querySelector("[data-label='название']").textContent

    };
}

function emptyData() {
    return {
        countryId: 0,
    };
}

function action (){
    return "/country/addcountry";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);


