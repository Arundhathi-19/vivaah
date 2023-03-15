package com.cg.marriageceremony.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.model.Venue;
import com.cg.marriageceremony.repository.VenueRepository;

@Component

public class VenueServiceImpl implements VenueService {
	
		@Autowired
		private VenueRepository venueRepository;
		@PersistenceContext
		private EntityManager em;

	   
		@Override
		@Transactional
		public Venue addVenue(Venue ve) {
			em.persist(ve);
			return ve;
		}

		@Override
		public List<Venue> allVenue() {
			List<Venue> venuelist= venueRepository.findAll();
			return venuelist;
		}

		@Override
		@Transactional
		public List<Venue> searchByVenuename(String vName) {
			Query q = em.createQuery("select n from Venue n where n.veName like :nv");
			q.setParameter("nv", "%" + vName + "%");
			List<Venue> vName1 = q.getResultList();
			return vName1;
		}
	
		
}

