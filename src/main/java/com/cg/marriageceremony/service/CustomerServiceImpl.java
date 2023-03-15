package com.cg.marriageceremony.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.exceptions.FieldCannotBeEmptyException;
import com.cg.marriageceremony.exceptions.NoCustomerPresentException;
import com.cg.marriageceremony.model.Customer;
import com.cg.marriageceremony.repository.CustomerRepository;


@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		
		try {
			if (customer.getCustName() == null || customer.getEmail() == null || customer.getMobileNo() <= 0
					|| customer.getCustName().isEmpty() || customer.getEmail().isEmpty()) {
				throw new FieldCannotBeEmptyException("Please fill every field appropriately");
			}
			return customerRepository.save(customer);
		} catch (FieldCannotBeEmptyException exception) {
			throw exception;
		} catch (RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}

	}

	@Override
	public List<Customer> allCustomers() {
		try {
			List<Customer> custList = customerRepository.findAll();
			if (custList.isEmpty()) {
				throw new NoCustomerPresentException("There in no customers present in database");
			}
			return custList;
		} catch (NoCustomerPresentException exception) {
			throw exception;
		} catch (RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
}
	
