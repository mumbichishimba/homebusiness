/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.chichi.jfmc.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import zm.chichi.jfmc.entity.Animal;

/**
 *
 * @author Mumbi Chishimba Jr
 */
public class AnimalModel {
    private Session session = null;
    
    public AnimalModel(){
        try {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    public boolean addFarm(Animal animal){
        try {
            this.session.beginTransaction();

            this.session.save(animal);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editFarm(Animal animal){
        try {
            this.session.beginTransaction();

            this.session.saveOrUpdate(animal);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteFarm(Animal animal){
        try {
            this.session.beginTransaction();

            this.session.delete(animal);

            this.session.getTransaction().commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Animal> getAllAnimals(){
        List<Animal> animal = new ArrayList<>();
        
        Criteria cr = this.session.createCriteria(Animal.class);
        
        try {
            animal = (List<Animal>) cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return animal;
    }
    
    public Animal getAnimal(int id){
        Animal animal = null;
        
        Criteria cr = this.session.createCriteria(Animal.class);
        
        try {
            cr.add(Restrictions.eq("id", id));
            animal = (Animal)cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return animal;
    }
}
