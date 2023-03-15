package com.cg.marriageceremony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.marriageceremony.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	@Query(value= "delete from Payment p where p.paymentId=:pid")
	@Modifying
	int deletePayment(@Param("pid") int pid);
	
	@Query(value="select sum(v.price) from vendor v, cart_items c where v.vendor_id=c.vendor_id AND c.cust_Id= :c",nativeQuery=true)
	float allPrice(@Param("c") int custId);
	
	@Query(value="select cust_id from customer where email= :uname",nativeQuery=true)
	int findCustId(@Param("uname")String username);
}

