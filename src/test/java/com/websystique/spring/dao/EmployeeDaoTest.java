/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.Employee;
import com.websystique.spring.service.EmployeeService;
import java.math.BigDecimal;
import java.util.List;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author TiranoJuan
 */
public class EmployeeDaoTest {

    public EmployeeDaoTest() {
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
     * Test of saveEmployee method, of class EmployeeDao.
     */
    @Test
    public void testSaveEmployee() {
        System.out.println("saveEmployee");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.deleteEmployeeBySsn("0");
        Employee employee = new Employee();
        employee.setSsn("0");
        employee.setName("Mary");
        employee.setSalary(new BigDecimal(20000));
        employee.setJoiningDate(new LocalDate(2012, 11, 11));
        EmployeeDao instance = new EmployeeDaoImpl();
        service.saveEmployee(employee);

        Employee res = service.findBySsn("0");
        assertNotNull(res);
        assertEquals(employee, res);
        service.deleteEmployeeBySsn("0");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEmployees method, of class EmployeeDao.
     */
    @Test
    public void testFindAllEmployees() {
        System.out.println("findAllEmployees");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.deleteEmployeeBySsn("0");
        Employee employee = new Employee();
        employee.setSsn("0");
        employee.setName("Mary-Test");
        employee.setSalary(new BigDecimal(20000));
        employee.setJoiningDate(new LocalDate(2012, 11, 11));
        EmployeeDao instance = new EmployeeDaoImpl();
        service.saveEmployee(employee);

        List<Employee> res = service.findAllEmployees();
        assertNotNull(res);
        assertNotEquals(0, res.size());
        service.deleteEmployeeBySsn("0");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmployeeBySsn method, of class EmployeeDao.
     */
    @Test
    public void testDeleteEmployeeBySsn() {
        System.out.println("deleteEmployeeBySsn");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.deleteEmployeeBySsn("0");
        Employee employee = new Employee();
        employee.setSsn("0");
        employee.setName("Mary-Test");
        employee.setSalary(new BigDecimal(20000));
        employee.setJoiningDate(new LocalDate(2012, 11, 11));
        EmployeeDao instance = new EmployeeDaoImpl();
        service.saveEmployee(employee);

        
        Employee res = service.findBySsn("0");
        assertNotNull(res);
        assertEquals(employee, res);
        
        service.deleteEmployeeBySsn("0");
        Employee res2 = service.findBySsn("0");
        assertNull(res2);
        
//        assertNotNull(res);
//        assertNotEquals(0, res.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findBySsn method, of class EmployeeDao.
     */
    @Test
    public void testFindBySsn() {
        System.out.println("findBySsn");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.deleteEmployeeBySsn("0");
        Employee employee = new Employee();
        employee.setSsn("0");
        employee.setName("Mary");
        employee.setSalary(new BigDecimal(20000));
        employee.setJoiningDate(new LocalDate(2012, 11, 11));
        EmployeeDao instance = new EmployeeDaoImpl();
        service.saveEmployee(employee);

        Employee res = service.findBySsn("0");
        assertNotNull(res);
        assertEquals(employee, res);
        service.deleteEmployeeBySsn("0");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class EmployeeDao.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.deleteEmployeeBySsn("0");
        Employee employee = new Employee();
        employee.setSsn("0");
        employee.setName("Mary");
        employee.setSalary(new BigDecimal(20000));
        employee.setJoiningDate(new LocalDate(2012, 11, 11));
        EmployeeDao instance = new EmployeeDaoImpl();
        service.saveEmployee(employee);

        Employee res = service.findBySsn("0");
        assertNotNull(res);
        assertEquals(employee, res);
        
        employee.setSalary(new BigDecimal(30));
        service.updateEmployee(employee);
        
        Employee res2 = service.findBySsn("0");
        assertNotNull(res2);
        assertEquals(employee, res2);
        
        service.deleteEmployeeBySsn("0");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class EmployeeDaoImpl implements EmployeeDao {

        public void saveEmployee(Employee employee) {
        }

        public List<Employee> findAllEmployees() {
            return null;
        }

        public void deleteEmployeeBySsn(String ssn) {
        }

        public Employee findBySsn(String ssn) {
            return null;
        }

        public void updateEmployee(Employee employee) {
        }
    }

}
