package com.revature.project1.unittest;

import com.revature.project1.models.Employee;
import com.revature.project1.repositories.EmployeeRepo;
import com.revature.project1.repositories.EmployeeRepoHBImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    EmployeeRepo bc = new EmployeeRepoHBImpl();
    Employee a = new Employee();
    Employee b = new Employee();


    @Test
    public void addEmployee() {
        a.setE_name("Employee");
        a = bc.addEmployee(a);
        assertEquals("Employee", a.getE_name());

    }

    @Test
    public void getEmployee(){
        a.setE_name("Employee");
        a = bc.addEmployee(a);
        a = bc.getEmployee(a.getId());
        assertEquals("Employee", a.getE_name());
    }

    @Test
    public void updateEmployee(){
        a.setE_name("Employee");
        a = bc.addEmployee(a);
        b.setE_name("Employee1");
        a = bc.addEmployee(b);
        b = bc.updateEmployee(a);
        assertEquals("Employee1", a.getE_name());

    }

    @Test
    public void deleteEmployee(){
        a.setE_name("Employee5");
        a = bc.addEmployee(a);
        b = bc.deleteEmployee(a.getId());
        assertEquals("", "");
    }
}
