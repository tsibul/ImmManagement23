// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';


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
    return ;
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
