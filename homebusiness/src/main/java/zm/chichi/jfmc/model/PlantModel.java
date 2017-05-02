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
import zm.chichi.jfmc.entity.Plant;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class PlantModel {
    private Session session = null;
    
    public PlantModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addPlant(Plant plant){
        try {
            this.session.beginTransaction();

            this.session.save(plant);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editPlant(Plant plant){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(plant);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deletePlant(Plant plant){
        try {
            this.session.beginTransaction();

            this.session.delete(plant);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Plant> getAllPlants(){
        List<Plant> plant = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(Plant.class);
        
        try {
            plant = (List<Plant>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return plant;
    }
    
    public Plant getPlant(int id){
        Plant plant = null;
        
        Criteria cr = this.session.createCriteria(Plant.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            plant = (Plant)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return plant;
    }
}
