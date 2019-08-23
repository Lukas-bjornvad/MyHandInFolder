/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lukas Bjørnvad
 */
//public class EntityTested {
//       public static void main(String[] args) {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//EntityManager em = emf.createEntityManager();
//Costumer cust1 = new Costumer("Carlos","Lopez");
//Costumer cust2 = new Costumer("Kariz","Parif");
//
//try { 
//      em.getTransaction().begin();
//      em.persist(cust1);
//      em.persist(cust2);
//      em.getTransaction().commit();
//      //Verify that books are managed and has been given a database id
//      System.out.println(cust1.getId());
//      System.out.println(cust2.getId());
//            
//        }finally{
//            em.close();
//        }
//}
//}
