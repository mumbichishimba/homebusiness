/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import zm.chichi.jfmc.entity.BusExpense;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class BusExpensesModel {
    private Session session = null;
    
    public BusExpensesModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addExpense(BusExpense expense){
        try {
            this.session.beginTransaction();

            this.session.save(expense);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editExpense(BusExpense expense){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(expense);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteExpense(BusExpense expense){
        try {
            this.session.beginTransaction();

            this.session.delete(expense);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<BusExpense> getAllExpenses(){
        List<BusExpense> expenses = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(BusExpense.class);
        
        try {
            expenses = (List<BusExpense>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < expenses.size(); i++) {
            expenses.get(i).setBus(new BusModel().getBus(expenses.get(i).getBusId()));
        }
        
        return expenses;
    }
    
    
    public List<BusExpense> getNumberOfExpenses(int number){
        List<BusExpense> expenses = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(BusExpense.class);
        
        try {
            cr.setMaxResults(number);
            cr.addOrder(Order.desc("dateOfExpense"));
            expenses = (List<BusExpense>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < expenses.size(); i++) {
            expenses.get(i).setBus(new BusModel().getBus(expenses.get(i).getBusId()));
        }
        
        return expenses;
    }
    
    public BusExpense getExpense(int id){
        BusExpense bus = null;
        
        Criteria cr = this.session.createCriteria(BusExpense.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            bus = ((List<BusExpense>) cr.list()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bus;
    }
    
    
    public Float getExpensesForMonthInYear(int year, int month) throws ParseException {

        // Some vars
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        Float salesAmount = 0f;

        // Process datefrom and date to
        String month_string = "";
        String dateString = "" + year;

        if (month < 10) {
            month_string = "0" + month;
        } else {
            month_string = month + "";
        }

        dateString = month_string + "-" + dateString;

        calendar.setTime(dateFormat.parse("01-" + dateString));
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date from = dateFormat.parse("01-" + dateString);
        Date to = calendar.getTime();
        
        // Criteria database query
        Criteria cr = session.createCriteria(BusExpense.class);
        cr.add(Restrictions.between("dateOfExpense", from, to));

        List<BusExpense> busSales = (List<BusExpense>) cr.list();
        
        // Sum up the results
        for (BusExpense sale : busSales) {
            salesAmount += sale.getAmount();
        }

        return salesAmount;
    }
}
