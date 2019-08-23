package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankFacade {

    private static BankFacade instance;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    //Private Constructor to ensure Singleton
    //private BankFacade()
    public BankFacade() {
    }
//    public BankFacade(boolean test){
//        instance = new BankFacade();
//    }

    public CustomerDTO getCustomerByID(int id) {
  EntityManager em = emf.createEntityManager();
        try{
             TypedQuery<BankCustomer> query = 
                       em.createQuery("Select c from BankCustomer c where c.id = :id",BankCustomer.class);
            query.setParameter("id", id);
            return new CustomerDTO(query.getSingleResult());
        }finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String firstname) {
 EntityManager em = emf.createEntityManager();
    //name=name.replace("%20", " ");
    LinkedList<CustomerDTO> list = new LinkedList<>();
        try{
            TypedQuery<BankCustomer> query = 
              em.createQuery("Select c from BankCustomer c where c.firstName = :firstName", BankCustomer.class);
            query.setParameter("firstName", firstname);
            for (int i = 0; i < query.getResultList().size(); i++) {
             list.add(new CustomerDTO(query.getResultList().get(i)))  ; 
            }
               return list;     
        }finally {
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer cust) {
    try{    
        EntityManager em = emf.createEntityManager(); 
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            
    }catch(Exception ex){
        ex.printStackTrace();
    }return cust;
    }

    public List<BankCustomer> getAllBankCustomers() {
         EntityManager em = emf.createEntityManager();
     
        try{
            TypedQuery<BankCustomer> query = 
                       em.createQuery("Select c from BankCustomer c", BankCustomer.class);
            
            return query.getResultList();
        }finally {
            em.close();
        }
    }
     public void populate(){
       
            addCustomer(new BankCustomer("Freddy","Darrens","FDbank",1000, 12, "Has serious halitosis"));
            addCustomer(new BankCustomer("Ken","Borh","KBbank",4000, 11, "Suspicius activity"));
            addCustomer(new BankCustomer("Lisa","Binkens","LBbank",2000, 21, "Extremely suspicius activity"));
            addCustomer(new BankCustomer("Friday","Lark","FLbank", 20, 51, "Slightly suspicius activity"));
            addCustomer(new BankCustomer("James","Porken","JPbank", 100000, 1, "A lot of activity"));

    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
