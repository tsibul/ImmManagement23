package com.immplan.injectionmanagement23.db.producer;

import java.util.HashMap;

public class ProducerType {

    public static HashMap<Integer, String> producerTypeDict(){
        HashMap<Integer, String> producerTypeDict = new HashMap<>();
        producerTypeDict.put(1, "Термопластавтоматы");
        producerTypeDict.put(2, "Пресс-формы");
        producerTypeDict.put(3,  "Периферия");
        producerTypeDict.put(4,  "Сырье");
        producerTypeDict.put(5,  "Вторичное сырье");
        producerTypeDict.put(6,  "Суперконцентраты");
        return producerTypeDict;
    }
}
