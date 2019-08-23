/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lukas Bjørnvad
 */
public class MakeTestData {
    public void populate(){
         EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu");
         EntityManager em = emf.createEntityManager(); 
            em.getTransaction().begin();
            em.persist(new BankCustomer("Freddy","Darrens","FDbank",1000, 12, "Has serious halitosis"));
            em.persist(new BankCustomer("Ken","Borh","KBbank",4000, 11, "Suspicius activity"));
            em.persist(new BankCustomer("Lisa","Binkens","LBbank",2000, 21, "Extremely suspicius activity"));
            em.persist(new BankCustomer("Friday","Lark","FLbank", 20, 51, "Slightly suspicius activity"));
            em.persist(new BankCustomer("James","Porken","JPbank", 100000, 1, "A lot of activity"));
            em.getTransaction().commit();
            em.close();
    }
//    public static void main(String[] args) {
//        MakeTestData k = new MakeTestData();
//       k.populate(); 
//    }
}
