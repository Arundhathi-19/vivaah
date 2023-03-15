package com.cg.marriageceremony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.marriageceremony.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value="select cust_id from customer where email= :uname",nativeQuery=true)
	int findCustId(@Param("uname")String username);

}
