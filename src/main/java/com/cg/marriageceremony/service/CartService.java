package com.cg.marriageceremony.service;

import java.util.List;

import com.cg.marriageceremony.dto.CartItemsData;
import com.cg.marriageceremony.model.CartItems;
import com.cg.marriageceremony.model.Vendor;


public interface CartService {
	CartItems addItemsInCart(CartItemsData cartData);
	
	List<Vendor> getVendorFromCart(int custId);
	int deleteItem(int vendorId);
}
