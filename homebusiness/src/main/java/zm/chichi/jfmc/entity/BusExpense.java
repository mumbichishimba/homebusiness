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
import javax.persistence.Transient;

/**
 *
 * @author Mumbi Chishimba Jr
 */

@Entity
@Table(name="busexpenses"
    ,catalog="homebusiness"
)
public class BusExpense {
    private Integer id;
    private Date dateOfExpense;
    private Float amount;
    private String expenseType;
    private int busId;
    private Integer addedByUserId;
    private Bus bus;

    public BusExpense() {
    }

    public BusExpense(Integer id, Date dateOfExpense, Float amount, String expenseType, int busId, Integer addedByUserId) {
        this.id = id;
        this.dateOfExpense = dateOfExpense;
        this.amount = amount;
        this.expenseType = expenseType;
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
     * @return the dateOfExpense
     */
    @Column(name = "dateOfExpense")
    public Date getDateOfExpense() {
        return dateOfExpense;
    }

    /**
     * @return the amount
     */
    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    /**
     * @return the expenseType
     */
    @Column(name = "expenseType")
    public String getExpenseType() {
        return expenseType;
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
     * @param dateOfExpense the dateOfExpense to set
     */
    public void setDateOfExpense(Date dateOfExpense) {
        this.dateOfExpense = dateOfExpense;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @param expenseType the expenseType to set
     */
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
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

    @Transient
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    
    
    @Override
    public String toString() {
        return "BusExpense{" + "id=" + id + ", dateOfExpense=" + dateOfExpense + ", amount=" + amount + ", expenseType=" + expenseType + ", busId=" + busId + ", addedByUserId=" + addedByUserId + '}';
    }
    
    
}
