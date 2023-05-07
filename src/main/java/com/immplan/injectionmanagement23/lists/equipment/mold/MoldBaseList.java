package com.immplan.injectionmanagement23.lists.equipment.mold;

import com.immplan.injectionmanagement23.db.equipment.injectionmoldingmachine.InjectionMoldingMachine;
import com.immplan.injectionmanagement23.db.equipment.mold.MoldBase;
import com.immplan.injectionmanagement23.lists.equipment.EquipmentList;

import java.util.ArrayList;

public class MoldBaseList implements EquipmentList<MoldBase, InjectionMoldingMachine> {
    private ArrayList<MoldBase> moldBases;

    public ArrayList<MoldBase> getMoldBases() {
        return moldBases;
    }

    public void setMoldBases(ArrayList<MoldBase> moldBases) {
        this.moldBases = moldBases;
    }

    @Override
    public void addEquipment(MoldBase moldBase) {
        this.moldBases.add(moldBase);
    }

    @Override
    public int mountEquipment(MoldBase moldBase, InjectionMoldingMachine injectionMoldingMachine) {
        if (checkMount(moldBase, injectionMoldingMachine)) {
            moldBase.setMoldMounted(true);
            moldBase.setMoldMountedTo(injectionMoldingMachine);
            return moldBase.getMoldMountTimeMin();
        } else {
            return 0;
        }
    }

    @Override
    public int releaseEquipment(MoldBase moldBase) {
        moldBase.setMoldMounted(false);
        moldBase.setMoldMountedTo(null);
        return moldBase.getMoldReleaseTimeMin();
    }


    @Override
    public ArrayList<MoldBase> equipmentMounted() {
        /*
        //try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            //CriteriaQuery<MoldBase> criteria = session.getCriteriaBuilder().createQuery(MoldBase.class);
            //criteria.from(MoldBase.class);
            //List mmm = session.createQuery(criteria).getResultList();

            Query query = session.createQuery("from MoldBaseEntity where moldMounted = :param");
            query.setParameter("param", "true");
            ArrayList moldsMount = (ArrayList) query.list();
            session.close();}

         */
        return new ArrayList<MoldBase>();

    }



    @Override
    public ArrayList<MoldBase> equipmentReleased() {
    /*
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from MoldBaseEntity where moldMounted = :param");
            query.setParameter("param", "false");
            ArrayList moldsRelease = (ArrayList) query.list();
            session.close();}

     */
        return new ArrayList<MoldBase>();

    }


    @Override
    public boolean equipmentReady(MoldBase moldBase) {
        return moldBase.isMoldMounted();
    }

    @Override
    public boolean equipmentDismounted(MoldBase moldBase) {
        return !moldBase.isMoldMounted();
    }

    private boolean checkMount(MoldBase moldBase, InjectionMoldingMachine injectionMoldingMachine) {
        boolean out = false;
        /*
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("select count(*) from MoldBaseToInjectionMoldingMachineEntity where moldBase = moldBase and injectionMoldingMachine = injectionMoldingMachine");
            int res = (int) query.uniqueResult();
            session.close();
            if (res > 0) {
                out = true;
            }

        }

         */
        return out;
    }


}
