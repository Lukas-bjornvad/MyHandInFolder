/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lukas Bjørnvad
 */
public class EmployeeFacadeIT {
    
    public EmployeeFacadeIT() {
         EmployeeFacade instance = new EmployeeFacade();
                instance.populate();
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getEmployeeByID method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeByID() {
        System.out.println("getEmployeeByID");
        int id = 1;
        EmployeeFacade instance = new EmployeeFacade();
        Employee expResult = new Employee("Lars Carlson", "Larsons vej 23", 2000);
        Employee result = instance.getEmployeeByID(id);
        assertEquals(expResult.getName(), result.getName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeeByName method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeByName() {
        System.out.println("getEmployeeByName");
        String name = "Cory Peters";
        EmployeeFacade instance = new EmployeeFacade();
        Employee expResult = new Employee("Cory Peters", "Carlson vej 21", 5000);
        List<Employee> result = instance.getEmployeeByName(name);
        assertEquals(expResult.getName(), result.get(0).getName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllEmployees method, of class EmployeeFacade.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        EmployeeFacade instance = new EmployeeFacade();
        int expResult = 4;
        List<Employee> result = instance.getAllEmployees();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeesWithHighestSalary method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesWithHighestSalary() {
        System.out.println("getEmployeesWithHighestSalary");
        EmployeeFacade instance = new EmployeeFacade();
        int expResult = 2;
        List<Employee> result = instance.getEmployeesWithHighestSalary();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createEmployee method, of class EmployeeFacade.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("createEmployee");
        Employee cust = new Employee("Cory Peters", "Carlson vej 21", 5000);
        EmployeeFacade instance = new EmployeeFacade();
        String expResult = cust.getName();
        String result = instance.getEmployeeByName(cust.getName()).get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }


    
}
