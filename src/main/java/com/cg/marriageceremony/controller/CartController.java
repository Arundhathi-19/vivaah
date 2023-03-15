package com.cg.marriageceremony.controller;

import java.security.Principal;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.marriageceremony.dto.CartItemsData;
import com.cg.marriageceremony.model.CartItems;
import com.cg.marriageceremony.model.Vendor;
import com.cg.marriageceremony.repository.CustomerRepository;
import com.cg.marriageceremony.service.CartService;


@RestController
@RequestMapping("/marriageceremony")
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class CartController {

	@Autowired
	private CartService cartservice;

	@Autowired
	CustomerRepository custRepo;
	
	@PreAuthorize("hasAuthority('User')")
	@PostMapping("/add-items-in-cart")
	public CartItems addItemsInCart(@RequestBody CartItemsData cartData, Principal p) {
		int cid=custRepo.findCustId(p.getName());
		cartData.setCustomerId(cid);
		CartItems cart = cartservice.addItemsInCart(cartData);
		return cart;
	}
	

	@PreAuthorize("hasAuthority('User')")
	@GetMapping("/getCartItems")
	public List<Vendor> getVendorFromCart(Principal p){
		int cid= custRepo.findCustId(p.getName());
		List<Vendor> vlist = cartservice.getVendorFromCart(cid);
		return vlist;
	}
	
	@DeleteMapping("/deleteCartItems/{vendorId}")
	public int deleteCartItem(@PathVariable("vendorId") int vendorId) {
		return cartservice.deleteItem(vendorId);
		
	}

	

}