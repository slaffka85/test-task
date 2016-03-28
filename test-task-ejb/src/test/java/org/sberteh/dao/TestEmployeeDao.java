package org.sberteh.dao;

import org.junit.Before;
import org.junit.Test;
import org.sberteh.model.Employee;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


/**
 *
 */
public class TestEmployeeDao {

    private Employee employee;

    private EmployeeDao employeeDao;

    @Before
    public void setupMock() {
        employee = mock(Employee.class);
        employeeDao = mock(EmployeeDao.class);

        when(employeeDao.find(1)).thenReturn(employee);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        when(employeeDao.fetchAll()).thenReturn(employees);
    }

    @Test
    public void testFind() {
        Employee employeeNotNull = employeeDao.find(1);
        assertNotNull(employeeNotNull);

        Employee employeeNull = employeeDao.find(0);
        assertNull(employeeNull);
    }

    @Test
    public void testFetchAll() {
        List<Employee> employees = employeeDao.fetchAll();
        assertNotNull(employees);
    }

}
