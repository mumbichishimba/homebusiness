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
import zm.chichi.jfmc.entity.FarmExpense;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class FarmExpensesModel {
    private Session session = null;
    
    public FarmExpensesModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarmExpense(FarmExpense farmExpense){
        try {
            this.session.beginTransaction();

            this.session.save(farmExpense);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editFarmExpense(FarmExpense farmExpense){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(farmExpense);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteFarmExpense(FarmExpense farmExpense){
        try {
            this.session.beginTransaction();

            this.session.delete(farmExpense);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<FarmExpense> getAllFarmExpenses(){
        List<FarmExpense> farmExpense = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmExpense.class);
        
        try {
            farmExpense = (List<FarmExpense>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmExpense;
    }
    
    public FarmExpense getFarmExpense(int id){
        FarmExpense farmExpense = null;
        
        Criteria cr = this.session.createCriteria(FarmExpense.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            farmExpense = (FarmExpense)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmExpense;
    }

    public List<FarmExpense> getFarmExpensesByFarm(Farm farm) {
        List<FarmExpense> farmExpense = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(FarmExpense.class);
        
        try {
            cr.add(Restrictions.eq("farmId", farm.getId()));
            farmExpense = (List<FarmExpense>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return farmExpense;
    }
}
