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
@Table(name="farmsales"
    ,catalog="homebusiness"
)
public class FarmSales {

    private Integer id;
    private Integer farmId;
    private Float amount;
    private Date dateOfSales;
    private String description;

    public FarmSales() {
    }

    public FarmSales(Integer id, Integer farmId, Float amount, Date dateOfSales) {
        this.id = id;
        this.farmId = farmId;
        this.amount = amount;
        this.dateOfSales = dateOfSales;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "farmId")
    public Integer getFarmId() {
        return farmId;
    }

    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    @Column(name = "dateOfSales")
    public Date getDateOfSales() {
        return dateOfSales;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setDateOfSales(Date dateOfSales) {
        this.dateOfSales = dateOfSales;
    }

    @Override
    public String toString() {
        return "FarmSales{" + "id=" + id + ", farmId=" + farmId + ", amount=" + amount + ", dateOfSales=" + dateOfSales + '}';
    }
    
}
