/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Costumer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lukas Bjørnvad
 */
public class Facade {
 EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu");
public Facade(){}

public Costumer findByID(long id){
        EntityManager em = emf.createEntityManager();
        try{
             TypedQuery<Costumer> query = 
                       em.createQuery("Select c from Costumer c where c.id = :id",Costumer.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }finally {
            em.close();
        }
 }
public List<Costumer> findByLastName(String name){
    EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Costumer> query = 
                       em.createQuery("Select c from Costumer c where c.lastName = :name",Costumer.class);
            query.setParameter("name", name);
            return query.getResultList();
        }finally {
            em.close();
        }
}
public List<Costumer> allCustomers(){
     EntityManager em = emf.createEntityManager();
     
        try{
            TypedQuery<Costumer> query = 
                       em.createQuery("Select c from Costumer c",Costumer.class);
            
            return query.getResultList();
        }finally {
            em.close();
        }
}
public int getNumberOfCustomers(){
    List<Costumer> hb;
    hb= allCustomers();
    return hb.size();
}



public Costumer addCustomer(Costumer cust){
    try{    
        EntityManager em = emf.createEntityManager(); 
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            
    }catch(Exception ex){
        ex.printStackTrace();
    }return cust;
}
public void populate(){
addCustomer(new Costumer("Lars", "Larson"));
addCustomer(new Costumer("Janice", "Larson"));
addCustomer(new Costumer("Cory", "Carlson"));
addCustomer(new Costumer("Bethany", "Kent"));
} 
    /*public static void main(String[] args) {
        Facade test = new Facade();
        test.populate();
        List<Costumer> liste = test.allCustomers();
        List<Costumer> lister = test.findByLastName("Larson");
        for(int i=0; i<liste.size(); i++){
            System.out.println(liste.get(i).getFirstName());
        }
        System.out.println(test.getNumberOfCustomers());
        System.out.println(test.findByID(1).getFirstName());
          for(int j=0; j<lister.size(); j++){
        System.out.println(lister.get(j).getFirstName());
          }
        
    }*/
}
