package com.cg.marriageceremony.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.dto.CartItemsData;
import com.cg.marriageceremony.model.CartItems;
import com.cg.marriageceremony.model.Customer;
import com.cg.marriageceremony.model.Vendor;
import com.cg.marriageceremony.repository.CartItemsRepository;
import com.cg.marriageceremony.repository.CustomerRepository;
import com.cg.marriageceremony.repository.VendorRepository;






@Component
public class CartServiceImpl implements CartService {
    @Autowired
	private CartItemsRepository cartRepo;
    @Autowired
    private CustomerRepository custRepo;
    @Autowired
    private VendorRepository venRepo;
    @PersistenceContext
    private EntityManager em;
	
	@Override
	public CartItems addItemsInCart(CartItemsData cartData) {
		int cid= cartData.getCustomerId();
		Customer c=custRepo.findById(cid).get();
		int vid= cartData.getVendorId();
		Vendor v= venRepo.findById(vid).get();
		CartItems cart= new CartItems();
		cart.setCustomer(c);
		cart.setVendor(v);
		cart= cartRepo.save(cart);
		return cart;
	}
	
	@Override
	public List<Vendor>getVendorFromCart(int custId){
		List <Vendor> prodList = cartRepo.getVendorFromCart(custId);
		return prodList;
	}

	@Override
	@Transactional
	public int deleteItem(int vendorId) {
		return cartRepo.deleteItemFromCart(vendorId);
	}

}