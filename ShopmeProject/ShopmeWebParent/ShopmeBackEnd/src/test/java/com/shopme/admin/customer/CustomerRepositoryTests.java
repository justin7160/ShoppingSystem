package com.shopme.admin.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Customer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {

	@Autowired CustomerRepository repo;
	
	@Test
	public void findCustomerByEmail() {
		String email = "alex.gordan@gmail.com";
		Customer customer = repo.findByEmail(email);
		System.out.println(customer);
		assertThat(customer).isNotNull();
	}
	
	@Test
	public void updateCustomerEnabledStatus() {
		Integer id = 1;
		boolean status = true;
		
		repo.updateEnabledStatus(id, status);
	}
	
	
}
