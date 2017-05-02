/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mumbi Chishimba Jr
 */
@Entity
@Table(name="bus"
    ,catalog="homebusiness"
)
public class Bus {
    private Integer id;
    private String name;
    private String busType;
    private String manufacturer;
    private String model;
    private String numberplate;
    private Float originalCost;
    private Date dateOfPurchase;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }
    
    /**
     * @return the name
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }


    /**
     * @return the busType
     */
    @Column(name = "busType")
    public String getBusType() {
        return busType;
    }

    /**
     * @return the manufacturer
     */
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @return the model
     */
    
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    /**
     * @return the numberplate
     */
    
    @Column(name = "numberplate")
    public String getNumberplate() {
        return numberplate;
    }

    /**
     * @return the originalCost
     */
    
    @Column(name = "originalCost")
    public Float getOriginalCost() {
        return originalCost;
    }

    /**
     * @return the dateOfPurchase
     */
    
    @Column(name = "dateOfPurchase")
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @param busType the busType to set
     */
    public void setBusType(String busType) {
        this.busType = busType;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @param numberplate the numberplate to set
     */
    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    /**
     * @param originalCost the originalCost to set
     */
    public void setOriginalCost(Float originalCost) {
        this.originalCost = originalCost;
    }

    /**
     * @param dateOfPurchase the dateOfPurchase to set
     */
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Bus{" + "id=" + id + ", name=" + name + ", busType=" + busType + ", manufacturer=" + manufacturer + ", model=" + model + ", numberplate=" + numberplate + ", originalCost=" + originalCost + ", dateOfPurchase=" + dateOfPurchase + '}';
    }
    
}
