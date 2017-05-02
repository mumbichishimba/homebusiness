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
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Mumbi Chishimba Jr
 */

@Entity
@Table(name="bussales"
    ,catalog="homebusiness"
)
public class BusSale {
    private Integer id;
    private Date dateOfSale;
    private Float amount;
    private String description;
    private int busId;
    private Integer addedByUserId;
    private Bus bus;

    public BusSale() {
    }

    public BusSale(Integer id, Date dateOfSale, Float amount, String description, int busId, Integer addedByUserId) {
        this.id = id;
        this.dateOfSale = dateOfSale;
        this.amount = amount;
        this.description = description;
        this.busId = busId;
        this.addedByUserId = addedByUserId;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    

    /**
     * @return the amount
     */
    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    /**
     * @return the dateOfSale
     */
    @Column(name = "dateOfSale")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateOfSale() {
        return dateOfSale;
    }

    /**
     * @return the description
     */
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    /**
     * @return the busId
     */
    @Column(name = "busId")
    public int getBusId() {
        return busId;
    }

    /**
     * @return the addedByUserId
     */
    @Column(name = "addedByUserId")
    public Integer getAddedByUserId() {
        return addedByUserId;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @param busId the busId to set
     */
    public void setBusId(int busId) {
        this.busId = busId;
    }

    /**
     * @param addedByUserId the addedByUserId to set
     */
    public void setAddedByUserId(Integer addedByUserId) {
        this.addedByUserId = addedByUserId;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "BusSale{" + "id=" + id + ", dateOfSale=" + dateOfSale + ", amount=" + amount + ", description=" + description + ", busId=" + busId + ", addedByUserId=" + addedByUserId + '}';
    }
    
}
