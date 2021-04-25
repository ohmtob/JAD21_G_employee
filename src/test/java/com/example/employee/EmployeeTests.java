package com.example.employee;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmployeeTests {
	@Test
	void calculateMonthlySalaryReturnsCorrectValue() {
		Integer hours = 100;
		Employee employee = new Employee();	
		employee.setHourlySalary(250);
		employee.setName("Tobias Öhman");
		employee.setSsn("19800515");
		employee.setCarReg("ABC123");

		assertThat(employee.calculateMonthlySalary(hours)).isEqualTo(25000);

	}

}
