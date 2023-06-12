// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';


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
    /*
    return {

        moldWeightKg: modal.querySelector("#mold-weight"),
        moldHeightMm: modal.querySelector("#mold-height"),
        ifAir: modal.querySelector("#air"),
        numberAirValves: modal.querySelector("#number-air-valves"),
        ifHydraulic: modal.querySelector("#hydraulic"),
        numberHydraulicCylinders: modal.querySelector("#number-cylinders"),
        ifChangeableInsert: modal.querySelector("#changeable-insert"),
        modifierMountTime: modal.querySelector("#mount-time"),
        modifierReleaseTime: modal.querySelector("#release-time"),
        singleModifier: modal.querySelector("#single-modifier")
    };

     */
}

function fullData(row) {
    let dataDict = {
        equipmentId: row.dataset.equipmentid,
        equipmentName: row.querySelector("[data-label='название']").textContent,
        inventoryCode: row.querySelector("[data-label='инв. номер']").textContent,
        equipmentCode: row.querySelector("[data-label='код']").textContent,
        producer: row.querySelector("[data-label='производитель']").dataset.id,
        partNumber: row.querySelector("[data-label='зав. номер']").textContent,
        yearProduction: row.querySelector("[data-label='год вып.']").textContent,
        receiveDate: row.querySelector("[data-label='на баланс']").textContent,
    };
    row.querySelectorAll(".equipment-data").forEach(function (element) {
        if (element.dataset.type != 'boolean') {
            dataDict[element.dataset.name] = element.dataset.text;
        } else dataDict[element.dataset.name] = element.dataset.bool;
    });
    return dataDict;


    /*
            return {

                moldWeightKg: row.querySelector("[data-label='вес, кг']").textContent,
                moldHeightMm: row.querySelector("[data-label='высота, мм']").textContent,
                ifAir: row.querySelector("[data-label='воздух']").dataset.bool,
                numberAirValves: row.querySelector("[data-label='кол-во клапанов']").textContent,
                ifHydraulic: row.querySelector("[data-label='гидравлика']").dataset.bool,
                numberHydraulicCylinders: row.querySelector("[data-label='кол-во цилиндров']").textContent,
                ifChangeableInsert: row.querySelector("[data-label='сменная вставка']").dataset.bool,
                modifierMountTime: row.querySelector("[data-label='время монтажа, мин']").textContent,
                modifierReleaseTime: row.querySelector("[data-label='время  демонтажа, мин']").textContent,
                singleModifier: row.querySelector("[data-label='единственный модификатор']").dataset.bool
            };
     */
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
        } else if (element.dataset.type == 'int' || element.dataset.type == 'Integer' || element.dataset.type == 'double'
            || element.dataset.type == 'float') {
            dataDict[element.name] = "0";
        }
    });

    return dataDict;
}

function action() {
    return "/equipment/02.02/add_mold_modifier";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
