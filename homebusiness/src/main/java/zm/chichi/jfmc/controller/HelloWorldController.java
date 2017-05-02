/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zm.chichi.jfmc.entity.BusExpense;
import zm.chichi.jfmc.entity.BusSale;
import zm.chichi.jfmc.entity.NameValue;
import zm.chichi.jfmc.model.BusExpensesModel;
import zm.chichi.jfmc.model.BusModel;
import zm.chichi.jfmc.model.BusSalesModel;

/**
 *
 * @author Mumbi Chishimba Jr
 */

@Controller
@RequestMapping("/welcome")
public class HelloWorldController {
    
    private String[] months = {"January", "February", "March", "April", "May", 
        "June", "July", "August", "September", "October", "November", "December"};
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld(){
        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "hello world");
        model.addObject("buses", new BusModel().getAllBuses());
        model.addObject("sales", new BusSalesModel().getNumberOfSales(10));
        model.addObject("expenses", new BusExpensesModel().getNumberOfExpenses(10));
        float ratio = ((float)new BusSalesModel().getAllSales().size()/(float)new BusExpensesModel().getAllExpenses().size());
        
        model.addObject("ratio", ratio);
        return model;
    }
    
    @RequestMapping(path = "/reports" ,method = RequestMethod.GET)
    public String reports(Model model){
        
        return "reports";
    }
    
    @RequestMapping(path = "/reports_bus" ,method = RequestMethod.GET)
    public String busReports(Model model){
        
        List<NameValue> sales = new ArrayList<>();
        List<NameValue> expenses = new ArrayList<>();
        List<BusSale> busSales = new BusSalesModel().getAllSales();
        List<BusExpense> busExpenses = new BusExpensesModel().getAllExpenses();
        
        Float salesAmount = 0f, expensesAmount = 0f;
        
        
        for(int x=0;x<months.length;x++){
            try {
                float f = new BusSalesModel().getSalesForMonthInYear(Calendar.getInstance().get(Calendar.YEAR) ,x);
                sales.add(new NameValue(months[x], f+""));
                salesAmount+=f;
                
            } catch (ParseException ex) {
                Logger.getLogger(HelloWorldController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int x=0;x<months.length;x++){
            try {
                float f = new BusExpensesModel().getExpensesForMonthInYear(Calendar.getInstance().get(Calendar.YEAR) ,x);
                expenses.add(new NameValue(months[x], f+""));
                expensesAmount+=f;
            } catch (ParseException ex) {
                Logger.getLogger(HelloWorldController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        model.addAttribute("buses", new BusModel().getAllBuses());
        model.addAttribute("sales", busSales);
        model.addAttribute("expenses", busExpenses);
        
        model.addAttribute("sales", sales);
        model.addAttribute("sales_amount", 12000);
        
        
        model.addAttribute("expenses", expenses);
        model.addAttribute("expenses_amount", 5000);
        
        model.addAttribute("sales_amount_total", salesAmount);
        model.addAttribute("expenses_amount_total", expensesAmount);
        
        return "report_bus";
    }
}
