/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.chichi.jfmc.entity.Bus;
import zm.chichi.jfmc.entity.BusExpense;
import zm.chichi.jfmc.model.BusModel;
import zm.chichi.jfmc.model.BusExpensesModel;

/**
 *
 * @author Mumbi Chishimba Jr
 */
@Controller
public class BusExpenseController {
     
    @RequestMapping(path = "/busexpenses/view/all", method = RequestMethod.GET)
    public String addExpenses(Model model) {
        
        List<BusExpense> expenses = new BusExpensesModel().getAllExpenses();
        
        model.addAttribute("expenses", expenses);
        return "viewbuexpenses";
    }
    
    @RequestMapping(path = "/bus/expense/add", method = RequestMethod.GET)
    public String addExpense(Model model) {
        
        List<Bus> buses = new BusModel().getAllBuses();
        
        model.addAttribute("buses", buses);
        return "addexpense";
    }
    
    @RequestMapping(path = "/bus/expense/add", method = RequestMethod.POST)
    public String addExpenseAction(@ModelAttribute("busExpense") BusExpense busExpense, BindingResult result, Model model) {
        System.out.println(busExpense);
        
        boolean status = new BusExpensesModel().addExpense(busExpense);

        return "redirect:/busexpenses/view/all.html";
    }
    
    @RequestMapping(path = "/expense/{id}/editexpense", method = RequestMethod.GET)
    public String editExpense(Model model, @PathVariable("id") int id) {
        BusExpense busexpense = new BusExpensesModel().getExpense(id);
        List<Bus> buses = new BusModel().getAllBuses();
        model.addAttribute("busExpense", busexpense);
        model.addAttribute("buses", buses);
        return "editexpense";
    }
    
    @RequestMapping(path = "/expense/{id}/editexpense", method = RequestMethod.POST)
    public String editExpenseAction(@ModelAttribute("busExpense") BusExpense expense, @PathVariable("id") int id) {
        expense.setId(id);
        
        boolean status = new BusExpensesModel().editExpense(expense);
         
        return "redirect:/busexpenses/view/all.html";
    }
    
    @RequestMapping(path = "/expense/{id}/delete", method = RequestMethod.GET)
    public String deleteExpense(Model model, @PathVariable("id") int id) {
        BusExpense busexpense = new BusExpensesModel().getExpense(id);
        List<Bus> buses = new BusModel().getAllBuses();
        model.addAttribute("busExpense", busexpense);
        model.addAttribute("buses", buses);
        return "deleteexpense";
    }
    
    @RequestMapping(path = "/expense/{id}/delete", method = RequestMethod.POST)
    public String deleteExpenseAction(@ModelAttribute("busExpense") BusExpense expense, @PathVariable("id") int id) {
        expense.setId(id);
        
        boolean status = new BusExpensesModel().deleteExpense(expense);
         
        return "redirect:/busexpenses/view/all.html";
    }
    
}

