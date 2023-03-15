package com.cg.marriageceremony.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.exceptions.MarriageCeremonyApplicationException;
import com.cg.marriageceremony.model.Caterers;
import com.cg.marriageceremony.repository.CaterersRepository;


@Component
public class CaterersServiceImpl implements CaterersService{
	
	@Autowired
	private CaterersRepository caterersRepository;
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Caterers addCaterers(Caterers ct) {
		em.persist(ct);
		return ct;
	}

	@Override
	public List<Caterers> allCateres() {
		List<Caterers> caterersList=caterersRepository.findAll();
		return caterersList;
	}

	@Override
	@Transactional
	public List<Caterers> SearchingByName(String cName) {
		if(cName != null) {
		Query q=em.createQuery("select c from Caterers c where c.cName like :CC");
		q.setParameter("CC","%"+cName+"%");
		List<Caterers> cname=q.getResultList();
		if(cname.size()==0) {
			String msg = "Sorry !! The Caterers "+  cName +"  is not available";
			throw new MarriageCeremonyApplicationException(msg);
		}
		return cname;
	}

		String msg = "Sorry !! The Caterers "  + cName +  "  is not available";
		throw new MarriageCeremonyApplicationException(msg);
	}

	@Override
	@Transactional
	public int deleteVendor(int vid) {
		return caterersRepository.deleteVendor(vid);
	}

}
