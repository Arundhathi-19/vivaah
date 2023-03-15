package com.cg.marriageceremony.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.marriageceremony.exceptions.FieldCannotBeEmptyException;
import com.cg.marriageceremony.exceptions.NoCustomerPresentException;
import com.cg.marriageceremony.model.CartItems;
import com.cg.marriageceremony.model.Customer;
import com.cg.marriageceremony.model.Vendor;
import com.cg.marriageceremony.repository.CustomerRepository;

@SpringBootTest
class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	@MockBean
	CustomerRepository customerRepository;

	// Stubs
	private Customer rohit;
	private Customer virat;
	private Customer shubman;
	private Customer ishan;
	private Customer lalith;
	List<Customer> customerList;

	List<CartItems> cartItems;

	@BeforeEach
	void setUp() throws Exception {

		CartItems item1 = new CartItems(1, new Customer(), new Vendor());
		CartItems item2 = new CartItems(2, new Customer(), new Vendor());
		CartItems item3 = new CartItems(3, new Customer(), new Vendor());

		cartItems = new ArrayList<>();
		cartItems.add(item1);
		cartItems.add(item2);
		cartItems.add(item3);

		// Test 1
		rohit = new Customer(1, "rohit", 3333333333L, "rohit@gmail.com", cartItems);

		// Test2
		virat = new Customer(2, "virat", 8439323023L, "virat@gmail.com", cartItems);
		shubman = new Customer(3, "shubman", 9232348343L, "shubman@gmail.com", cartItems);
		ishan = new Customer(4, "ishan", 9232747343L, "ishan@gmail.com", cartItems);
		lalith = new Customer();

		customerList = new ArrayList<>();
		customerList.add(rohit);
		customerList.add(virat);
		customerList.add(shubman);
		customerList.add(ishan);
	}

	@AfterEach

	void tearDown() throws Exception {
		customerRepository.deleteAll();
		rohit = null;
	}

	@Test
	@DisplayName("Saves the customer provided into the database")
	public void test_addCustomer_GivenTheCustomer_ShouldReturnSavedCustomer() {

		Mockito.when(customerRepository.save(rohit)).thenReturn(rohit);

		Customer customerReturnedFromCustomerService = customerService.addCustomer(rohit);

		assertNotNull(customerReturnedFromCustomerService);
		assertEquals(rohit, customerReturnedFromCustomerService);
	}

	@Test
	@DisplayName("Return List of Customers")
	public void test_getAllCustomer_ShouldReturnListOfCustomer() {

		Mockito.when(customerRepository.findAll()).thenReturn(customerList);

		List<Customer> customerListReturnedFromCustomerService = customerService.allCustomers();

		assertNotNull(customerList);
		assertNotNull(customerListReturnedFromCustomerService);
		assertEquals(4, customerListReturnedFromCustomerService.size());
		assertEquals(rohit, customerListReturnedFromCustomerService.get(0));
		assertEquals(virat, customerListReturnedFromCustomerService.get(1));
		assertEquals(shubman, customerListReturnedFromCustomerService.get(2));
		assertEquals(ishan, customerListReturnedFromCustomerService.get(3));

	}

	@Test
	public void test_addCustomer_shouldThrowFieldCannotBeEmptyExceptionForCustomer() {

		Mockito.when(customerRepository.save(virat)).thenThrow(new FieldCannotBeEmptyException());

		assertThrows(FieldCannotBeEmptyException.class, () -> {

			customerService.addCustomer(lalith);

		});

	}
	
	 @Test
		public void test_allCustomers_shouldThrowNoCustomerPresentException() {
			
			Mockito.when(customerRepository.findAll()).thenThrow(NoCustomerPresentException.class);
			
			assertThrows(NoCustomerPresentException.class, () -> customerService.allCustomers());
			
		}

}
