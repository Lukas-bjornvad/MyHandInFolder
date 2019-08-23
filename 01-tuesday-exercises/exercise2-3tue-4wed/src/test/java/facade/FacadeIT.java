/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Costumer;
import java.util.List;
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
public class FacadeIT {
    
    public FacadeIT() {
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
     * Test of findByID method, of class Facade.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        long id = 1L;
        Facade instance = new Facade();
        Costumer expResult = new Costumer("Lars", "Larson");
        Costumer result = instance.findByID(id);
        assertEquals(expResult.getFirstName(), result.getFirstName());

    }

    /**
     * Test of findByLastName method, of class Facade.
     */
    @Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        String name = "Larson";
        Facade instance = new Facade();
        instance.populate();
        int expResult = 2;
        List<Costumer> result = instance.findByLastName(name);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addCustomer method, of class Facade.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Costumer cust = new Costumer("Coral", "Reef");;
        Facade instance = new Facade();
        instance.addCustomer(cust);
        int expResult = 5;
        int result = instance.getNumberOfCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of allCustomers method, of class Facade.
     */
    @Test
    public void testAllCustomers() {
        System.out.println("allCustomers");
        Facade instance = new Facade();
        int expResult = 5;
        List<Costumer> result = instance.allCustomers();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of getNumberOfCustomers method, of class Facade.
     */
    @Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        Facade instance = new Facade();
        int expResult = 5;
        int result = instance.getNumberOfCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
