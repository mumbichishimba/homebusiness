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
import zm.chichi.jfmc.model.BusModel;

/**
 *
 * @author Mumbi Chishimba Jr
 */
@Controller
public class BusController {

    @RequestMapping(path = "/bus/view/all", method = RequestMethod.GET)
    public String home(Model model) {
        List<Bus> buses = new BusModel().getAllBuses();
        
        model.addAttribute("buses", buses);
        return "viewbuses";
    }

    @RequestMapping(path = "/bus/addbus", method = RequestMethod.GET)
    public String addBus(Model model) {
        Bus bus = new Bus();
        model.addAttribute("bus", bus);
        return "addbus";
    }

    @RequestMapping(path = "/bus/addbus", method = RequestMethod.POST)
    public String addBusAction(@ModelAttribute("bus") Bus bus, BindingResult result, Model model) {
        System.out.println(bus);
        
        boolean status = new BusModel().addBus(bus);

        return "redirect:/view/all.html";
    }

    @RequestMapping(path = "/bus/{id}/view", method = RequestMethod.GET)
    public String viewBuses(@PathVariable("id") int id) {
        return "viewbus";
    }

    @RequestMapping(path = "/bus/{id}/editbus", method = RequestMethod.GET)
    public String editBus(Model model, @PathVariable("id") int id) {
        Bus bus = new BusModel().getBus(id);
        model.addAttribute("bus", bus);
        return "editbus";
    }
    
    @RequestMapping(path = "/bus/{id}/editbus", method = RequestMethod.POST)
    public String editBusAction(@ModelAttribute("bus") Bus bus, @PathVariable("id") int id) {
        bus.setId(id);
        
        boolean status = new BusModel().editBus(bus);
        
        return "redirect:/view/all.html";
    }
    
    
    @RequestMapping(path = "/bus/{id}/deletebus", method = RequestMethod.GET)
    public String deleteBusView(Model model, @PathVariable("id") int id) {
        Bus bus = new BusModel().getBus(id);
        model.addAttribute("bus", bus);
        return "deletebus";
    }
    
    @RequestMapping(path = "/bus/{id}/deletebus", method = RequestMethod.POST)
    public String deleteBusAction(Model model ,@ModelAttribute("bus") Bus bus, @PathVariable("id") int id) {
        bus.setId(id);
        
        boolean status = new BusModel().deleteBus(bus);
        
        List<Bus> buses = new BusModel().getAllBuses();
        
        model.addAttribute("buses", buses);
        
        return "redirect:/bus/view/all.html";
        
    }
}
