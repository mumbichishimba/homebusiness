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

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class FarmModel {
    private Session session = null;
    
    public FarmModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarm(Farm Farm){
        try {
            this.session.beginTransaction();

            this.session.save(Farm);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editFarm(Farm Farm){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(Farm);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteFarm(Farm Farm){
        try {
            this.session.beginTransaction();

            this.session.delete(Farm);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Farm> getAllFarms(){
        List<Farm> Farms = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(Farm.class);
        
        try {
            Farms = (List<Farm>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Farms;
    }
    
    public Farm getFarm(int id){
        Farm Farm = null;
        
        Criteria cr = this.session.createCriteria(Farm.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            Farm = ((List<Farm>) cr.list()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Farm;
    }
}
