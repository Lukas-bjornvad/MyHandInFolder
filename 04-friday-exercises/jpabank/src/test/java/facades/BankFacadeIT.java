/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import entities.MakeTestData;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lukas Bjørnvad
 */
public class BankFacadeIT {
    
    public BankFacadeIT() {
        BankFacade instance = new BankFacade();
        instance.populate();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerByID method, of class BankFacade.
     */
    @Test
    public void testGetCustomerByID() {
        System.out.println("getCustomerByID");
        int id = 1;
        BankFacade instance = new BankFacade();
        CustomerDTO expResult = new CustomerDTO(new BankCustomer("Freddy","Darrens","FDbank",1000, 12, "Has serious halitosis"));
        CustomerDTO result = instance.getCustomerByID(id);
        assertEquals(expResult.getFullName(), result.getFullName());
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of getCustomerByName method, of class BankFacade.
     */
    @Test
    public void testGetCustomerByName() {
        System.out.println("getCustomerByName");
        String name = "Freddy";
        BankFacade instance = new BankFacade();
        LinkedList<CustomerDTO> expResult= new LinkedList<>();
        expResult.add(new CustomerDTO(new BankCustomer("Freddy","Darrens","FDbank",1000, 12, "Has serious halitosis")));
        List<CustomerDTO> result = instance.getCustomerByName(name);
        assertEquals(expResult.get(0).getFullName(), result.get(0).getFullName());
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of addCustomer method, of class BankFacade.
     */
    @Test
    public void addCustomer() {
        System.out.println("addCustomer");
        BankFacade instance = new BankFacade();
        instance.addCustomer(new BankCustomer("Korral","Puksen","PDbank",9000, 27, "Has no halitosis"));
        CustomerDTO expResult = new CustomerDTO(new BankCustomer("Korral","Puksen","PDbank",9000, 27, "Has no halitosis"));
        CustomerDTO result = instance.getCustomerByID(6);
        assertEquals(expResult.getFullName(), result.getFullName());
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of getAllBankCustomers method, of class BankFacade.
     */
    @Test
    public void testGetAllBankCustomers() {
        System.out.println("getAllBankCustomers");
        BankFacade instance = new BankFacade();
        int expResult = 6;
        List<BankCustomer> result;
        result = instance.getAllBankCustomers();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }
 
    
}
