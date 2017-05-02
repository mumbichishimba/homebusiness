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
@Table(name="farm"
    ,catalog="homebusiness"
)
public class Farm implements java.io.Serializable {
    private Integer id;
    private String name;
    private String town;
    private String location;
    private float globalX;
    private float globalY;
    private float price;

    public Farm() {
    }

    public Farm(Integer id, String name, String town, String location, float globalX, float globalY, float price) {
        this.id = id;
        this.name = name;
        this.town = town;
        this.location = location;
        this.globalX = globalX;
        this.globalY = globalY;
        this.price = price;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "town")
    public String getTown() {
        return town;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    @Column(name = "globalX")
    public float getGlobalX() {
        return globalX;
    }

    @Column(name = "globalY")
    public float getGlobalY() {
        return globalY;
    }

    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGlobalX(float globalX) {
        this.globalX = globalX;
    }

    public void setGlobalY(float globalY) {
        this.globalY = globalY;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Farm{" + "id=" + id + ", name=" + name + ", town=" + town + ", location=" + location + ", globalX=" + globalX + ", globalY=" + globalY + ", price=" + price + '}';
    }
    
}
