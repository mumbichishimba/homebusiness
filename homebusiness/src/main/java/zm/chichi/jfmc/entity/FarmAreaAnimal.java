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
@Table(name="farmareaanimal"
    ,catalog="homebusiness"
)
public class FarmAreaAnimal implements java.io.Serializable {

    private Integer id;
    private Integer farmAreaId;
    private Integer animalId;
    private Float amount;

    public FarmAreaAnimal() {
    }

    public FarmAreaAnimal(Integer id, Integer farmAreaId, Integer animalId, Float amount) {
        this.id = id;
        this.farmAreaId = farmAreaId;
        this.animalId = animalId;
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

    @Column(name = "animalId")
    public Integer getAnimalId() {
        return animalId;
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

    public void setAnimalId(Integer plantId) {
        this.animalId = plantId;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FarmAreaAnimal{" + "id=" + id + ", farmAreaId=" + farmAreaId + ", plantId=" + animalId + ", amount=" + amount + '}';
    }
    
}
