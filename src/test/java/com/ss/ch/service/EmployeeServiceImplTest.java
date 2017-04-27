package com.ss.ch.service;

import com.ss.ch.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring-config.xml")
public class EmployeeServiceImplTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testGetEmployeeById() {
		Employee emp = employeeService.getEmployeeById(1);
		
		assertNotNull(emp);
	}
	
	@Test
	public void testCreateEmployee()
	{
		Employee emp = new Employee();
		emp.setName("Emp123");
		int key = employeeService.createEmployee(emp);
		
		assertNotNull(key);
	}

}
