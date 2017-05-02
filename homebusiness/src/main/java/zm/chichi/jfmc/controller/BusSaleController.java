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
import zm.chichi.jfmc.entity.BusSale;
import zm.chichi.jfmc.model.BusModel;
import zm.chichi.jfmc.model.BusSalesModel;

/**
 *
 * @author Mumbi Chishimba Jr
 */
@Controller
public class BusSaleController {
    
    @RequestMapping(path = "/bussales/view/all", method = RequestMethod.GET)
    public String viewAll(Model model) {
        
        List<BusSale> sales = new BusSalesModel().getAllSales();
        
        model.addAttribute("sales", sales);
        return "viewbusales";
    }
    
    @RequestMapping(path = "/bussales/view/busmenu", method = RequestMethod.GET)
    public String viewBus(Model model) {
        
        
        List<Bus> buses = new BusModel().getAllBuses();
        
        model.addAttribute("buses", buses);
        
        return "viewsalesmenu";
    }
    
    @RequestMapping(path = "/bus/sale/add", method = RequestMethod.GET)
    public String addSale(Model model) {
        
        List<Bus> buses = new BusModel().getAllBuses();
        
        model.addAttribute("buses", buses);
        return "addsale";
    }
    
    @RequestMapping(path = "/bus/sale/add", method = RequestMethod.POST)
    public String addSaleAction(@ModelAttribute("busSale") BusSale busSale, BindingResult result, Model model) {
        System.out.println(busSale);
        
        boolean status = new BusSalesModel().addBusSale(busSale);

        return "redirect:/bussales/view/busmenu.html";
    }
    
    @RequestMapping(path = "/sale/{busSaleId}/delete", method = RequestMethod.GET)
    public String deleteSaleView(Model model, @PathVariable("busSaleId") int busSaleId) {
        System.out.println(busSaleId);
        
        BusSale bussale = new BusSalesModel().getBusSale(busSaleId);
        List<Bus> buses = new BusModel().getAllBuses();
        model.addAttribute("busSale", bussale);
        model.addAttribute("buses", buses);

        return "deletesale";
    }
    
    @RequestMapping(path = "/sale/{busSaleId}/delete", method = RequestMethod.POST)
    public String deleteSaleAction(Model model, @PathVariable("busSaleId") int busSaleId) {
        System.out.println(busSaleId);
        
        BusSale sale = new BusSalesModel().getBusSale(busSaleId);
        boolean status = new BusSalesModel().deleteBusSale(sale);

        return "redirect:/bussales/view/busmenu.html";
    }
    
    @RequestMapping(path = "/sale/{id}/editsale", method = RequestMethod.GET)
    public String editSale(Model model, @PathVariable("id") int id) {
        BusSale bussale = new BusSalesModel().getBusSale(id);
        List<Bus> buses = new BusModel().getAllBuses();
        model.addAttribute("busSale", bussale);
        model.addAttribute("buses", buses);
        return "editsale";
    }
    
    @RequestMapping(path = "/sale/{id}/editsale", method = RequestMethod.POST)
    public String editSaleAction(@ModelAttribute("busSale") BusSale sale, @PathVariable("id") int id) {
        sale.setId(id);
        
        boolean status = new BusSalesModel().editBusSale(sale);
         
        return "redirect:/bussales/view/busmenu.html";
    }
    
    @RequestMapping(path = "/bus/sales/{id}/view", method = RequestMethod.GET)
    public String salesByBus(Model model, @PathVariable("id") int id) {
        
        List<BusSale> sales = new BusSalesModel().getSalesByBus(id);
        
        model.addAttribute("sales", sales);
        return "svc_bussales";
    }
    
    @RequestMapping(path = "/bus/sales/view", method = RequestMethod.GET)
    public String allSalesBus(Model model) {
        
        List<BusSale> sales = new BusSalesModel().getAllSales();
        
        model.addAttribute("sales", sales);
        return "svc_bussales";
    }
}

