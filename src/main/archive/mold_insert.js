// Импортируем функции из main_modal.js
import initialize from '/js/main_modal.js';


function inputs(modal) {
    return {
        equipmentId: modal.querySelector("#mold-base-id"),
        equipmentName: modal.querySelector("#mold-base-name"),
        inventoryCode: modal.querySelector("#inventory-code"),
        equipmentCode: modal.querySelector("#code"),
        producer: modal.querySelector("#producer"),
        partNumber: modal.querySelector("#part-number"),
        yearProduction: modal.querySelector("#year-production"),
        receiveDate: modal.querySelector("#receive-date"),

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
}

function fullData(row) {
    return {
        equipmentId: row.dataset.moldbaseid,
        equipmentName: row.querySelector("[data-label='название']").textContent,
        inventoryCode: row.querySelector("[data-label='инв. номер']").textContent,
        equipmentCode: row.querySelector("[data-label='код']").textContent,
        producer: row.querySelector("[data-label='производитель']").dataset.id,
        partNumber: row.querySelector("[data-label='зав. номер']").textContent,
        yearProduction: row.querySelector("[data-label='год вып.']").textContent,
        receiveDate: row.querySelector("[data-label='на баланс']").textContent,

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
}

function emptyData(modal) {
    return {
        equipmentId: 0,
        inventoryCode: "02.",
        yearProduction: "2022-01-01",
        receiveDate: "2022-01-01",

        moldWeightKg: "0",
        moldHeightMm: "0",
        ifAir: "false",
        numberAirValves: "0",
        ifHydraulic: "false",
        numberHydraulicCylinders: "0",
        ifChangeableInsert: "false",
        modifierMountTime: "0",
        modifierReleaseTime: "0",
        singleModifier: "true"
    };
}

function action (){
    return "/equipment/02.02/add_mold_modifier";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);