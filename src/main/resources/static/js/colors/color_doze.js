// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const productGroupsId = document.querySelector("#url-parameters").dataset.productgroupsid;


function inputs(modal) {
    return {
    };
}

function fullData(row) {
    return {
    };
}

function emptyData() {
    return {
    };
}

function action (){
    return "/color_doze/add_doze?productGroupsId=" + productGroupsId;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
