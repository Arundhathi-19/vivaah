package com.cg.marriageceremony.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.model.Payment;
import com.cg.marriageceremony.repository.PaymentRepository;

@Component
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	@PersistenceContext
	private EntityManager em;
	
//	@Override
//	@Transactional
//	public Payment addPaymentDetails(Payment payment) {
//		em.persist(payment);
//		return payment;
//	}
//
//	@Override
//	@Transactional
//	public int deletePayment(int paymentId) {
//		return paymentRepository.deletePayment(paymentId);
//	}

//	@Override
//	public Float getTotalAmount(int paymentId) {
//		Optional<Payment> payment = paymentRepository.findById(paymentId);
//		if(payment.isPresent()) {
//			return payment.get().getTotalPrice();
//		}
//		return null;
//	}
	
	@Override
	@Transactional
	public Float getTotalAmount(int custId) {
		float price=paymentRepository.allPrice(custId);
		return price;
	}

}



   








