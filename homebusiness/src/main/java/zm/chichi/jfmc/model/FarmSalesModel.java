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
import zm.chichi.jfmc.entity.FarmSales;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class FarmSalesModel {
    private Session session = null;
    
    public FarmSalesModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarmSales(FarmSales farmSales){
        try {
            this.session.beginTransaction();

            this.session.save(farmSales);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editFarmSales(FarmSales farmSales){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(farmSales);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteFarmSales(FarmSales farmSales){
        try {
            this.session.beginTransaction();

            this.session.delete(farmSales);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<FarmSales> getAllFarmSaless(){
        List<FarmSales> farmSales = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmSales.class);
        
        try {
            farmSales = (List<FarmSales>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmSales;
    }
    
    public FarmSales getFarmSales(int id){
        FarmSales farmSales = null;
        
        Criteria cr = this.session.createCriteria(FarmSales.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            farmSales = (FarmSales)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmSales;
    }

    public List<FarmSales> getFarmSalesByFarm(Farm farm) {
        List<FarmSales> farmExpense = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmSales.class);
        
        try {
            cr.add(Restrictions.eq("farmId", farm.getId()));
            farmExpense = (List<FarmSales>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmExpense;
    }
}
