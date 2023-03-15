package com.cg.marriageceremony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.marriageceremony.model.Customer;
import com.cg.marriageceremony.secure.model.UserDto;
import com.cg.marriageceremony.secure.service.JwtUserDetailsService;
import com.cg.marriageceremony.service.CustomerService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/marriageceremony")
@SecurityRequirement(name = "Vivaah")

public class CustomerController {
@Autowired
private CustomerService customerService;

@Autowired
private JwtUserDetailsService jwtUserDetailsService;

@PostMapping("/addCustomers")
public Customer addCustomer(@RequestBody UserDto userDto) {
	
	Customer customer = new Customer();
	customer.setCustName(userDto.getCustName());
	customer.setMobileNo(userDto.getMobileNo());
	customer.setEmail(userDto.getUsername());
	Customer customers = customerService.addCustomer(customer);
		
		userDto.setRole("User");
		jwtUserDetailsService.save(userDto);

		return customers;
	}

@PreAuthorize("hasAuthority('Admin')")
@GetMapping("/getAllCustomers")
        public List<Customer> findallcustomer() {
	    return customerService.allCustomers();
}

}
