/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import zm.chichi.jfmc.entity.Farm;
import zm.chichi.jfmc.entity.FarmArea;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class FarmAreaModel {
    private Session session = null;
    
    public FarmAreaModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarmArea(FarmArea farmArea){
        try {
            this.session.beginTransaction();

            this.session.save(farmArea);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editFarmArea(FarmArea farmArea){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(farmArea);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteFarmArea(FarmArea farmArea){
        try {
            this.session.beginTransaction();

            this.session.delete(farmArea);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<FarmArea> getAllFarmAreas(){
        List<FarmArea> farmArea = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmArea.class);
        
        try {
            farmArea = (List<FarmArea>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea;
    }
    
    public FarmArea getFarmArea(int id){
        FarmArea farmArea = null;
        
        Criteria cr = this.session.createCriteria(FarmArea.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            farmArea = (FarmArea)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea;
    }

    public List<FarmArea> getActiveFarmAreasByFarm(Farm farm) {
        List<FarmArea> farmArea = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmArea.class);
        
        try {
            cr.add(Restrictions.eq("farmId", farm.getId()));
            cr.add(Restrictions.eq("isActive", 1)); 
            farmArea = (List<FarmArea>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea; 
    }
}
