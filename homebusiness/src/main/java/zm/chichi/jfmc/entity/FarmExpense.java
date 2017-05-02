/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.entity;

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
@Table(name="farmexpense"
    ,catalog="homebusiness"
)
public class FarmExpense implements java.io.Serializable {

    private Integer id;
    private Integer farmId;
    private String expenseName;
    private String expenseType;
    private Float amount;

    public FarmExpense() {
    }

    public FarmExpense(Integer id, Integer farmId, String expenseName, String expenseType, Float amount) {
        this.id = id;
        this.farmId = farmId;
        this.expenseName = expenseName;
        this.expenseType = expenseType;
        this.amount = amount;
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

    @Column(name = "expenseName")
    public String getExpenseName() {
        return expenseName;
    }

    @Column(name = "expenseType")
    public String getExpenseType() {
        return expenseType;
    }

    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FarmExpense{" + "id=" + id + ", farmId=" + farmId + ", expenseName=" + expenseName + ", expenseType=" + expenseType + ", amount=" + amount + '}';
    }
    
    
}
