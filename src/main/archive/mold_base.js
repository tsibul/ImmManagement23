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
        moldBaseWidthMm: modal.querySelector("#mold-base-width"),
        moldBaseLengthMm: modal.querySelector("#mold-base-length"),
        ifChangeableModifier: modal.querySelector("#changeable-modifier"),
        hotRunner: modal.querySelector("#hot-runner"),
        movingPlateRingDiameterMm: modal.querySelector("#moving-plate-ring"),
        fixedPlateRingDiameterMm: modal.querySelector("#fixed-plate-ring"),
        moldMountTimeMin: modal.querySelector("#mount-time"),
        moldReleaseTimeMin: modal.querySelector("#release-time")
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
        moldBaseWidthMm: row.querySelector("[data-label='ширина, мм']").textContent,
        moldBaseLengthMm: row.querySelector("[data-label='длина, мм']").textContent,
        ifChangeableModifier: row.querySelector("[data-label='сменный модификатор']").dataset.bool,
        hotRunner: row.querySelector("[data-label='горячий канал']").dataset.bool,
        movingPlateRingDiameterMm: row.querySelector("[data-label='фланец подв. плита']").textContent,
        fixedPlateRingDiameterMm: row.querySelector("[data-label='фланец неподв. плита']").textContent,
        moldMountTimeMin: row.querySelector("[data-label='время монтажа, мин']").textContent,
        moldReleaseTimeMin: row.querySelector("[data-label='время  демонтажа, мин']").textContent
    };
}

function emptyData(modal) {
    return {
        equipmentId: 0,
        inventoryCode: "02.",
        yearProduction: "2022-01-01",
        receiveDate: "2022-01-01",
        moldBaseWidthMm: "0",
        moldBaseLengthMm: "0",
        ifChangeableModifier: "true",
        hotRunner: "false",
        movingPlateRingDiameterMm: "0",
        fixedPlateRingDiameterMm: "0",
        moldMountTimeMin: "0",
        moldReleaseTimeMin: "0"
    };
}

function action (){
    return "/equipment/02.01/add_mold_base";
}

// Вызываем функцию initialize, передавая необходимые функции
initialize(inputs, emptyData, fullData, action);
