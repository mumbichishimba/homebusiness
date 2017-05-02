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
import zm.chichi.jfmc.entity.Bus;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class BusModel {
    private Session session = null;
    
    public BusModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addBus(Bus bus){
        try {
            this.session.beginTransaction();

            this.session.save(bus);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editBus(Bus bus){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(bus);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteBus(Bus bus){
        try {
            this.session.beginTransaction();

            this.session.delete(bus);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Bus> getAllBuses(){
        List<Bus> buses = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(Bus.class);
        
        try {
            buses = (List<Bus>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return buses;
    }
    
    public Bus getBus(int id){
        Bus bus = null;
        
        Criteria cr = this.session.createCriteria(Bus.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            bus = ((List<Bus>) cr.list()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bus;
    }
}
