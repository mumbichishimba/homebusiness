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
@Table(name="farmareacrop"
    ,catalog="homebusiness"
)
public class FarmAreaCrop implements java.io.Serializable {
    private Integer id;
    private Integer farmAreaId;
    private Integer plantId;
    private Float amount;

    public FarmAreaCrop() {
    }

    public FarmAreaCrop(Integer id, Integer farmAreaId, Integer plantId, Float amount) {
        this.id = id;
        this.farmAreaId = farmAreaId;
        this.plantId = plantId;
        this.amount = amount;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "farmAreaId")
    public Integer getFarmAreaId() {
        return farmAreaId;
    }

    @Column(name = "plantId")
    public Integer getPlantId() {
        return plantId;
    }

    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFarmAreaId(Integer farmAreaId) {
        this.farmAreaId = farmAreaId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FarmAreaCrop{" + "id=" + id + ", farmAreaId=" + farmAreaId + ", plantId=" + plantId + ", amount=" + amount + '}';
    }
    
}
