package com.cg.marriageceremony.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.model.Vendor;
import com.cg.marriageceremony.repository.VendorRepository;

@Component
public class VendorServiceImpl implements VendorService {
       @Autowired
		private VendorRepository vendorRepository;

		@PersistenceContext
		private EntityManager em;

		@Override
		@Transactional
		public Vendor addVendor(Vendor v) {
			em.persist(v);
			return v;
		}

		@Override
		public List<Vendor> allVendor() {
			List<Vendor> vendorlist = vendorRepository.findAll();
			return vendorlist;
		}

		@Override
		@Transactional
		public List searchByCategory(String category) {
			Query q = em.createQuery("select c from Vendor c where c.category like :v");
			q.setParameter("v", "%" + category + "%");
			List<Vendor> category1 = q.getResultList();
			return category1;
		}

		@Override
		@Transactional
		public int deleteVendor(int vid) {
			return vendorRepository.deleteVendor(vid);
		}

		@Override
		@Transactional
		public Vendor updateVendor(Vendor vendor, int vid) {
			Vendor v = em.find(Vendor.class,vid);
			v.setCategory(vendor.getCategory());
			v.setCartItems(vendor.getCartItems());
			v.setPrice(vendor.getPrice());
			return v;
		}
		}