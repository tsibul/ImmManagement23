package com.immplan.injectionmanagement23.lists.equipment.mold;


import com.immplan.injectionmanagement23.db.equipment.mold.MoldInsert;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldModifier;
import com.immplan.injectionmanagement23.lists.equipment.EquipmentList;

import java.util.ArrayList;

public class MoldInsertList implements EquipmentList<MoldInsert, MoldModifier> {
    private ArrayList<MoldInsert> moldInserts;

    @Override
    public void addEquipment(MoldInsert moldInsert) {

    }

    @Override
    public int mountEquipment(MoldInsert moldInsert, MoldModifier eqTo) {
        return 0;
    }

    @Override
    public int releaseEquipment(MoldInsert moldInsert) {
        return 0;
    }

    @Override
    public ArrayList<MoldInsert> equipmentMounted() {
        return null;
    }

    @Override
    public ArrayList<MoldInsert> equipmentReleased() {
        return null;
    }

    @Override
    public boolean equipmentReady(MoldInsert moldInsert) {
        return false;
    }

    @Override
    public boolean equipmentDismounted(MoldInsert moldInsert) {
        return false;
    }
}
