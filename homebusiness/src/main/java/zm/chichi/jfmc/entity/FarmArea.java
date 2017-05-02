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
@Table(name="farmarea"
    ,catalog="homebusiness"
)
public class FarmArea implements java.io.Serializable {

    private Integer id;
    private Integer farmId;
    private Float lengthInMeters;
    private Float breadthInMeters;
    private String primaryItem;
    private Float globalX;
    private Float globalY;
    private Integer isActive;

    public FarmArea() {
    }

    public FarmArea(Integer id, Integer farmId, Float lengthInMeters, Float breadthInMeters, String primaryItem, Float globalX, Float globalY, Integer isActive) {
        this.id = id;
        this.farmId = farmId;
        this.lengthInMeters = lengthInMeters;
        this.breadthInMeters = breadthInMeters;
        this.primaryItem = primaryItem;
        this.globalX = globalX;
        this.globalY = globalY;
        this.isActive = isActive;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public Float getLengthInMeters() {
        return lengthInMeters;
    }

    public Float getBreadthInMeters() {
        return breadthInMeters;
    }

    public Float getGlobalX() {
        return globalX;
    }

    public Float getGlobalY() {
        return globalY;
    }
    
    public Integer getIsActive() {
        return isActive;
    }

    public String getPrimaryItem() {
        return primaryItem;
    }

    public void setPrimaryItem(String primaryItem) {
        this.primaryItem = primaryItem;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public void setLengthInMeters(Float lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    public void setBreadthInMeters(Float breadthInMeters) {
        this.breadthInMeters = breadthInMeters;
    }

    public void setGlobalX(Float globalX) {
        this.globalX = globalX;
    }

    public void setGlobalY(Float globalY) {
        this.globalY = globalY;
    }
    
    @Override
    public String toString() {
        return "FarmArea{" + "id=" + id + ", farmId=" + farmId + ", lengthInMeters=" + lengthInMeters + ", breadthInMeters=" + breadthInMeters + ", primaryItem=" + primaryItem + ", globalX=" + globalX + ", globalY=" + globalY + ", isActive=" + isActive + '}';
    }

    
}
