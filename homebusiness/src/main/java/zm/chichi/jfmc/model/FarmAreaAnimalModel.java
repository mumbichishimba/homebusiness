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
import zm.chichi.jfmc.entity.FarmAreaAnimal;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class FarmAreaAnimalModel {
    private Session session = null;
    
    public FarmAreaAnimalModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarmAreaAnimal(FarmAreaAnimal farmArea){
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
    
    public boolean editFarmAreaAnimal(FarmAreaAnimal farmArea){
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
    
    public boolean deleteFarmAreaAnimal(FarmAreaAnimal farmArea){
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
    
    public List<FarmAreaAnimal> getAllFarmAreaAnimals(){
        List<FarmAreaAnimal> farmArea = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmAreaAnimal.class);
        
        try {
            farmArea = (List<FarmAreaAnimal>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea;
    }
    
    public FarmAreaAnimal getFarmAreaAnimal(int id){
        FarmAreaAnimal farmArea = null;
        
        Criteria cr = this.session.createCriteria(FarmAreaAnimal.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            farmArea = (FarmAreaAnimal)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmArea;
    }
}
