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
import zm.chichi.jfmc.entity.FarmAreaCrop;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class FarmAreaCropModel {
    private Session session = null;
    
    public FarmAreaCropModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarmAreaCrop(FarmAreaCrop farmArea){
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
    
    public boolean editFarmAreaCrop(FarmAreaCrop farmArea){
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
    
    public boolean deleteFarmAreaCrop(FarmAreaCrop farmArea){
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
    
    public List<FarmAreaCrop> getAllFarmAreaCrops(){
        List<FarmAreaCrop> farmArea = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmAreaCrop.class);
        
        try {
            farmArea = (List<FarmAreaCrop>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea;
    }
    
    public FarmAreaCrop getFarmAreaCrop(int id){
        FarmAreaCrop farmArea = null;
        
        Criteria cr = this.session.createCriteria(FarmAreaCrop.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            farmArea = (FarmAreaCrop)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea;
    }
}
