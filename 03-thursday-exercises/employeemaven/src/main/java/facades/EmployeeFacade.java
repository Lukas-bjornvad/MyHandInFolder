/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lukas Bjørnvad
 */
public class EmployeeFacade {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu");
public EmployeeFacade(){}

    public Employee getEmployeeByID(int id){
        EntityManager em = emf.createEntityManager();
        try{
             TypedQuery<Employee> query = 
                       em.createQuery("Select c from Employee c where c.id = :id",Employee.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }finally {
            em.close();
        }
 }
public List<Employee> getEmployeeByName(String name){
    EntityManager em = emf.createEntityManager();
    name=name.replace("%20", " ");
        try{
            TypedQuery<Employee> query = 
                       em.createQuery("Select c from Employee c where c.name = :name",Employee.class);
            query.setParameter("name", name);
            return query.getResultList();
        }finally {
            em.close();
        }
}
public List<Employee> getAllEmployees(){
     EntityManager em = emf.createEntityManager();
     
        try{
            TypedQuery<Employee> query = 
                       em.createQuery("Select c from Employee c",Employee.class);
            
            return query.getResultList();
        }finally {
            em.close();
        }
        
}
public List<Employee> getEmployeesWithHighestSalary(){
     EntityManager em = emf.createEntityManager();
        try{
            List<Employee> l = getAllEmployees();
            double x=0;
            for(int i =0; i<l.size();i++){
                x=Math.max(x, l.get(i).getSalary());
            }
            TypedQuery<Employee> query = 
                       em.createQuery("Select c from Employee c where c.salary = :salary",Employee.class);
            query.setParameter("salary", x);
            return query.getResultList();
        }finally {
            em.close();
        }
}

public Employee createEmployee(Employee cust){
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
createEmployee(new Employee("Lars Carlson", "Larsons vej 23", 2000));
createEmployee(new Employee("Janice Burgers", "Larson vej 3A", 1750));
createEmployee(new Employee("Cory Peters", "Carlson vej 21", 5000));
createEmployee(new Employee("Bethany Kent", "Kennedy Boulevard 15", 5000));
} 
//    public static void main(String[] args) {
//        EmployeeFacade l = new EmployeeFacade();
//        l.populate();
//        List<Employee> lis = l.getAllEmployees();
//        for(int i =0; i<lis.size(); i++){
//            System.out.println(lis.get(i).getName());
//        }
//        List<Employee> list = l.getEmployeesWithHighestSalary();
//        for(int i =0; i<list.size(); i++){
//            System.out.println(list.get(i).getName());
//        }
//    }
}
