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
import zm.chichi.jfmc.entity.Farm;
import zm.chichi.jfmc.entity.FarmArea;
import zm.chichi.jfmc.entity.FarmExpense;
import zm.chichi.jfmc.entity.FarmSales;
import zm.chichi.jfmc.model.FarmAreaModel;
import zm.chichi.jfmc.model.FarmExpensesModel;
import zm.chichi.jfmc.model.FarmModel;
import zm.chichi.jfmc.model.FarmSalesModel;

/**
 *
 * @author Mumbi Chishimba Jr
 */
@Controller
@RequestMapping("/farm")
public class FarmController {
    
    /****
     * Home method
     * @param model
     * @return 
     */
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(Model model){
        
        List<Farm> farms = new FarmModel().getAllFarms();
        
        model.addAttribute("farms", farms);
        return "farms";
    }
    
    /*******************
     * 
     * 
     * Farm Actions
     * 
     */
    
    /******
     * Add farm view method
     * @param model
     * @return 
     */
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addFarmView(Model model){
        
        Farm farm = new Farm();
        
        model.addAttribute("farm", farm);
        
        return "addfarm";
    }
    
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addFarmAction(@ModelAttribute("farm") Farm farm, BindingResult result, Model model) {
        System.out.println(farm);
        
        boolean status = new FarmModel().addFarm(farm);

        return "redirect:/farm/home.html";
    }
    
    @RequestMapping(path = "/{id}/editfarm", method = RequestMethod.GET)
    public String editFarmView(Model model, @PathVariable("id") int id) {
        Farm farm = new FarmModel().getFarm(id);
        model.addAttribute("farm", farm);
        return "editfarm";
    }
    
    @RequestMapping(path = "/{id}/editfarm", method = RequestMethod.POST)
    public String editFarmAction(@ModelAttribute("farm") Farm farm, @PathVariable("id") int id) {
        farm.setId(id);
        
        boolean status = new FarmModel().editFarm(farm);
        
        return "redirect:/farm/home.html";
    }
    
    @RequestMapping(path = "/{id}/deletefarm", method = RequestMethod.GET)
    public String deleteFarmView(Model model, @PathVariable("id") int id) {
        Farm farm = new FarmModel().getFarm(id);
        model.addAttribute("farm", farm);
        return "deletefarm";
    }
    
    @RequestMapping(path = "/{id}/deletefarm", method = RequestMethod.POST)
    public String deleteFarmAction(@ModelAttribute("farm") Farm farm, @PathVariable("id") int id) {
        farm.setId(id);
        
        boolean status = new FarmModel().deleteFarm(farm);
        
        return "redirect:/farm/home.html";
    }
    
    @RequestMapping(path = "/{id}/viewfarm", method = RequestMethod.GET)
    public String viewFarm(Model model, @PathVariable("id") int id) {
        Farm farm = new FarmModel().getFarm(id);
        model.addAttribute("farm", farm);
        
        List<FarmArea> farmAreas = new FarmAreaModel().getActiveFarmAreasByFarm(farm);
        model.addAttribute("farmAreas", farmAreas);
        
        return "viewfarm";
    }
    
    
    
    /*************
     * 
     * 
     * Farm area methods
     * 
     */
    
    
    
    @RequestMapping(path = "/{id}/area/add", method = RequestMethod.GET)
    public String addFarmAreaView(Model model, @PathVariable("id") int id){
        
        FarmArea farmArea = new FarmArea();
        Farm farm = new FarmModel().getFarm(id);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmArea", farmArea);
        
        return "addfarmarea";
    }
    
    @RequestMapping(path = "/{id}/area/add", method = RequestMethod.POST)
    public String addFarmAreaAction(@ModelAttribute("farmArea") FarmArea farmArea, @PathVariable("id") int id, BindingResult result, Model model) {
        System.out.println(farmArea);
        
        farmArea.setFarmId(id);
        farmArea.setIsActive(1);
        
        boolean status = new FarmAreaModel().addFarmArea(farmArea);

        return "redirect:/farm/"+farmArea.getFarmId()+"/viewfarm.html";
    }
    
    @RequestMapping(path = "/{id}/area/edit", method = RequestMethod.GET)
    public String editFarmAreaView(Model model, @PathVariable("id") int id){
        
        FarmArea farmArea = new FarmAreaModel().getFarmArea(id);
        Farm farm = new FarmModel().getFarm(farmArea.getFarmId());
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmArea", farmArea);
        
        return "editfarmarea";
    }
    
    @RequestMapping(path = "/{id}/area/edit", method = RequestMethod.POST)
    public String editFarmAreaAction(@ModelAttribute("farmArea") FarmArea farmArea, Model model, @PathVariable("id") int id){
        
        farmArea.setId(id);
        farmArea.setFarmId(new FarmAreaModel().getFarmArea(id).getFarmId());
        
        //Temporary Code Changes
        farmArea.setIsActive(1);
        farmArea.setGlobalX(new FarmAreaModel().getFarmArea(id).getGlobalX());
        farmArea.setGlobalY(new FarmAreaModel().getFarmArea(id).getGlobalY());
        
        Farm farm = new FarmModel().getFarm(farmArea.getFarmId());
        
        new FarmAreaModel().editFarmArea(farmArea);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmArea", farmArea);
        
        return "redirect:/farm/"+farmArea.getFarmId()+"/viewfarm.html";
    }
    
    @RequestMapping(path = "/{id}/area/delete", method = RequestMethod.GET)
    public String deleteFarmAreaView(Model model, @PathVariable("id") int id){
        
        FarmArea farmArea = new FarmAreaModel().getFarmArea(id);
        Farm farm = new FarmModel().getFarm(id);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmArea", farmArea);
        
        return "deletefarmarea";
    }
    
    @RequestMapping(path = "/{id}/area/delete", method = RequestMethod.POST)
    public String deleteFarmAreaAction(Model model, @PathVariable("id") int id){
        
        FarmArea farmArea = new FarmAreaModel().getFarmArea(id);
        Farm farm = new FarmModel().getFarm(farmArea.getFarmId());
        
        new FarmAreaModel().deleteFarmArea(farmArea);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmArea", farmArea);
        
        return "redirect:/farm/"+farmArea.getFarmId()+"/viewfarm.html";
    }
    
    
    /************
     * 
     * 
     * Farm expenses methods
     * 
     * 
     */
    
    
    
    @RequestMapping(path = "/{id}/viewfarmexpenses", method = RequestMethod.GET)
    public String viewFarmExpenses(Model model, @PathVariable("id") int id){
        
        Farm farm = new FarmModel().getFarm(id);
        List<FarmExpense> farmsExpenses = new FarmExpensesModel().getFarmExpensesByFarm(farm);
        
        model.addAttribute("farmExpenses", farmsExpenses);
        model.addAttribute("farm", farm);
        return "viewfarmexpenses";
    }
    
    @RequestMapping(path = "/{id}/expense/add", method = RequestMethod.GET)
    public String addFarmExpenseView(Model model, @PathVariable("id") int id){
        
        FarmExpense farmArea = new FarmExpense();
        Farm farm = new FarmModel().getFarm(id);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmExpense", farmArea);
        
        return "addfarmexpense";
    }
    
    @RequestMapping(path = "/{id}/expense/add", method = RequestMethod.POST)
    public String addFarmExpenseAction(@ModelAttribute("farmExpense") FarmExpense farmExpense, @PathVariable("id") int id, BindingResult result, Model model) {
        System.out.println(farmExpense);
        
        farmExpense.setFarmId(id);
        
        boolean status = new FarmExpensesModel().addFarmExpense(farmExpense);

        return "redirect:/farm/"+farmExpense.getFarmId()+"/viewfarmexpenses.html";
    }
    
    @RequestMapping(path = "/{id}/expense/edit", method = RequestMethod.GET)
    public String editFarmExpenseView(Model model, @PathVariable("id") int id){
        
        FarmExpense farmExpense = new FarmExpensesModel().getFarmExpense(id);
        Farm farm = new FarmModel().getFarm(farmExpense.getFarmId());
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmExpense", farmExpense);
        
        return "editfarmexpense";
    }
    
    @RequestMapping(path = "/{id}/expense/edit", method = RequestMethod.POST)
    public String editFarmExpenseAction(@ModelAttribute("farmArea") FarmExpense farmExpense, Model model, @PathVariable("id") int id){
        
        farmExpense.setId(id);
        farmExpense.setFarmId(new FarmAreaModel().getFarmArea(id).getFarmId());
        
        
        Farm farm = new FarmModel().getFarm(farmExpense.getFarmId());
        
        new FarmExpensesModel().editFarmExpense(farmExpense);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmExpense", farmExpense);
        
        return "redirect:/farm/"+farmExpense.getFarmId()+"/viewfarmexpenses.html";
    }
    
    @RequestMapping(path = "/{id}/expense/delete", method = RequestMethod.GET)
    public String deleteFarmExpenseView(Model model, @PathVariable("id") int id){
        
        FarmExpense farmArea = new FarmExpensesModel().getFarmExpense(id);
        Farm farm = new FarmModel().getFarm(id);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmExpense", farmArea);
        
        return "deletefarmexpense";
    }
    
    @RequestMapping(path = "/{id}/expense/delete", method = RequestMethod.POST)
    public String deleteFarmExpenseAction(Model model, @PathVariable("id") int id){
        
        FarmExpense farmArea = new FarmExpensesModel().getFarmExpense(id);
        Farm farm = new FarmModel().getFarm(farmArea.getFarmId());
        
        new FarmExpensesModel().deleteFarmExpense(farmArea);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmExpense", farmArea);
        
        return "redirect:/farm/"+farmArea.getFarmId()+"/viewfarmexpense.html";
    }
    
    
    
    /****************
     * 
     * 
     * Farm sales methods
     * 
     * 
     */
    
    
    
    @RequestMapping(path = "/{id}/viewfarmsales", method = RequestMethod.GET)
    public String viewFarmSales(Model model, @PathVariable("id") int id){
        
        Farm farm = new FarmModel().getFarm(id);
        List<FarmSales> farmsSales = new FarmSalesModel().getFarmSalesByFarm(farm);
        
        model.addAttribute("farmSales", farmsSales);
        model.addAttribute("farm", farm);
        return "viewfarmsales";
    }
    
    @RequestMapping(path = "/{id}/sale/add", method = RequestMethod.GET)
    public String addFarmSaleView(Model model, @PathVariable("id") int id){
        
        FarmSales farmSale = new FarmSales();
        Farm farm = new FarmModel().getFarm(id);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmSale", farmSale);
        
        return "addfarmsale";
    }
    
    @RequestMapping(path = "/{id}/sale/add", method = RequestMethod.POST)
    public String addFarmSaleAction(@ModelAttribute("farmSale") FarmSales farmSale, @PathVariable("id") int id, BindingResult result, Model model) {
        System.out.println(farmSale);
        
        farmSale.setFarmId(id);
        
        boolean status = new FarmSalesModel().addFarmSales(farmSale);

        return "redirect:/farm/"+farmSale.getFarmId()+"/viewfarmSales.html";
    }
    
    @RequestMapping(path = "/{id}/sale/edit", method = RequestMethod.GET)
    public String editFarmSaleView(Model model, @PathVariable("id") int id){
        
        FarmSales farmSale = new FarmSalesModel().getFarmSales(id);
        Farm farm = new FarmModel().getFarm(farmSale.getFarmId());
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmSale", farmSale);
        
        return "editfarmsale";
    }
    
    @RequestMapping(path = "/{id}/sale/edit", method = RequestMethod.POST)
    public String editFarmSaleAction(@ModelAttribute("farmSale") FarmSales farmSale, Model model, @PathVariable("id") int id){
        
        farmSale.setId(id);
        farmSale.setFarmId(new FarmSalesModel().getFarmSales(id).getFarmId());
        
        
        Farm farm = new FarmModel().getFarm(farmSale.getFarmId());
        
        new FarmSalesModel().editFarmSales(farmSale);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmSale", farmSale);
        
        return "redirect:/farm/"+farmSale.getFarmId()+"/viewfarmSales.html";
    }
    
    @RequestMapping(path = "/{id}/sale/delete", method = RequestMethod.GET)
    public String deleteFarmSaleView(Model model, @PathVariable("id") int id){
        
        FarmSales farmSale = new FarmSalesModel().getFarmSales(id);
        Farm farm = new FarmModel().getFarm(id);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmSale", farmSale);
        
        return "deletefarmsale";
    }
    
    @RequestMapping(path = "/{id}/sale/delete", method = RequestMethod.POST)
    public String deleteFarmSaleAction(Model model, @PathVariable("id") int id){
        
        FarmSales farmSale = new FarmSalesModel().getFarmSales(id);
        Farm farm = new FarmModel().getFarm(farmSale.getFarmId());
        
        new FarmSalesModel().deleteFarmSales(farmSale);
        
        model.addAttribute("farm", farm);
        model.addAttribute("farmsale", farmSale);
        
        return "redirect:/farm/"+farmSale.getFarmId()+"/viewfarmSale.html";
    }
}
