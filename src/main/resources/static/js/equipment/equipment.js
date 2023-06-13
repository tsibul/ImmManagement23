// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';

const equipmentType = document.querySelector("#url-parameters").dataset.equipmenttype;

function inputs(modal) {
    let dataDict = {
        equipmentId: modal.querySelector("#equipment-id"),
        equipmentName: modal.querySelector("#mold-base-name"),
        inventoryCode: modal.querySelector("#inventory-code"),
        equipmentCode: modal.querySelector("#code"),
        producer: modal.querySelector("#producer"),
        partNumber: modal.querySelector("#part-number"),
        yearProduction: modal.querySelector("#year-production"),
        receiveDate: modal.querySelector("#receive-date"),
    };
    modal.querySelectorAll(".equipment-data").forEach(function (element) {
        dataDict[element.name] = element;
    });
    return dataDict;
}

function fullData(row) {
    let dataDict = {
        equipmentId: row.dataset.equipmentid,
        equipmentName: row.querySelector("[data-label='название']").textContent,
        inventoryCode: row.querySelector("[data-label='инв. номер']").textContent,
        equipmentCode: row.querySelector("[data-label='код']").textContent,
        producer: row.querySelector("[data-label='производитель']").dataset.id,
        partNumber: row.querySelector("[data-label='зав. номер']").textContent,
        yearProduction: row.querySelector("[data-label='год вып.']").textContent + '-01-01',
        receiveDate: row.querySelector("[data-label='на баланс']").textContent,
    };
    row.querySelectorAll(".equipment-data").forEach(function (element) {
        if (element.dataset.type != 'boolean') {
            dataDict[element.dataset.name] = element.dataset.text;
        } else dataDict[element.dataset.name] = element.dataset.bool;
    });
    return dataDict;
}

function emptyData(modal) {
    let dataDict = {
        equipmentId: 0,
        inventoryCode: "02.",
        yearProduction: "2022-01-01",
        receiveDate: "2022-01-01",
    }
    modal.querySelectorAll(".equipment-data").forEach(function (element) {
        if (element.dataset.type == 'boolean') {
            dataDict[element.name] = 'false';
        } else if (element.dataset.type == 'Integer' || element.dataset.type == 'Double'
            || element.dataset.type == 'Float') {
            dataDict[element.name] = "0";
        }
    });

    return dataDict;
}

function action() {
    return "/equipment/" + equipmentType + "/add_equipment";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
