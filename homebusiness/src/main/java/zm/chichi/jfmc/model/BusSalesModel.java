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
import java.util.Random;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import zm.chichi.jfmc.entity.Bus;
import zm.chichi.jfmc.entity.BusSale;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class BusSalesModel {

    private Session session = null;

    public BusSalesModel() {
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    public boolean addBusSale(BusSale bussales) {
        try {
            this.session.beginTransaction();

            this.session.save(bussales);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editBusSale(BusSale bussale) {
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(bussale);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBusSale(BusSale bussale) {
        try {
            this.session.beginTransaction();

            this.session.delete(bussale);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BusSale> getAllSales() {
        List<BusSale> sales = new ArrayList<>();

        Criteria cr = this.session.createCriteria(BusSale.class);

        try {
            cr.addOrder(Order.desc("dateOfSale"));
            sales = (List<BusSale>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sales.size(); i++) {
            sales.get(i).setBus(new BusModel().getBus(sales.get(i).getBusId()));
        }

        return sales;
    }

    public List<BusSale> getNumberOfSales(int number) {
        List<BusSale> sales = new ArrayList<>();

        Criteria cr = this.session.createCriteria(BusSale.class);

        try {
            cr.setMaxResults(number);
            cr.addOrder(Order.desc("dateOfSale"));
            sales = (List<BusSale>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sales.size(); i++) {
            sales.get(i).setBus(new BusModel().getBus(sales.get(i).getBusId()));
        }

        return sales;
    }

    public List<BusSale> getSalesByBus(int busId) {
        List<BusSale> sales = new ArrayList<>();

        Criteria cr = this.session.createCriteria(BusSale.class);

        try {
            cr.add(Restrictions.eq("busId", busId));
            cr.addOrder(Order.desc("dateOfSale"));
            sales = (List<BusSale>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sales.size(); i++) {
            sales.get(i).setBus(new BusModel().getBus(sales.get(i).getBusId()));
        }

        return sales;
    }

    public List<BusSale> getBusSalesByBus(Bus bus) {
        List<BusSale> buses = new ArrayList<>();

        Criteria cr = this.session.createCriteria(BusSale.class);

        try {
            cr.add(Restrictions.eq("busId", bus.getId()));
            buses = (List<BusSale>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buses;
    }

    public List<BusSale> getNumberOfSalesByBus(Bus bus, int number) {
        List<BusSale> buses = new ArrayList<>();

        Criteria cr = this.session.createCriteria(BusSale.class);

        try {
            cr.setMaxResults(number);
            cr.add(Restrictions.eq("busId", bus.getId()));
            buses = (List<BusSale>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buses;
    }

    public BusSale getBusSale(int id) {
        BusSale bus = null;

        Criteria cr = this.session.createCriteria(BusSale.class);

        try {
            cr.add(Restrictions.eq("id", id));
            bus = ((List<BusSale>) cr.list()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bus;
    }

    public Float getSalesForMonthInYear(int year, int month) throws ParseException {

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
        Criteria cr = session.createCriteria(BusSale.class);
        cr.add(Restrictions.between("dateOfSale", from, to));

        List<BusSale> busSales = (List<BusSale>) cr.list();
        
        // Sum up the results
        for (BusSale sale : busSales) {
            salesAmount += sale.getAmount();
        }

        return salesAmount;
    }
}
