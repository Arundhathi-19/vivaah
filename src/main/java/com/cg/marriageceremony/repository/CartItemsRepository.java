package com.cg.marriageceremony.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.marriageceremony.model.CartItems;
import com.cg.marriageceremony.model.Vendor;



@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer>{
	
//	@Query(value="select * from cart_items where customer_id=  :c",nativeQuery=true)
//	List<CartItems> findAllItemsInCart(@Param("c") int custId);
	
	@Query(value=" select v1 from Vendor v1 where v1.vendorId in(select c.vendor from CartItems c where c.customer.custId= :cid)")
	List<Vendor> getVendorFromCart(@Param("cid") int custId );
	
	@Query(value="delete from Cart_Items where vendor_id =:v",nativeQuery=true)
	@Modifying
	int deleteItemFromCart(@Param("v") int vendorId);
}