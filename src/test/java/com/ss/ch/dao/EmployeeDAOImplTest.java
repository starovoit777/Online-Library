package com.ss.ch.dao;

import static org.junit.Assert.*;

import com.ss.ch.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring-config.xml")
public class EmployeeDAOImplTest {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	public void testGetEmployeeById() {
		Employee emp = employeeDAO.getEmployeeById(1);
		
		assertNotNull(emp);
	}
	
	@Test
	public void testCreateEmployee() {
		Employee emp1 = new Employee();
		Employee emp = new Employee();
		emp.setName("Emp123");
		employeeDAO.save(emp1);
		int key = employeeDAO.createEmployee(emp);
		
		assertNotNull(key);
	}

}
