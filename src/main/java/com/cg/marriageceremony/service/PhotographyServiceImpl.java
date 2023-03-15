package com.cg.marriageceremony.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.exceptions.MarriageCeremonyApplicationException;
import com.cg.marriageceremony.model.Photography;
import com.cg.marriageceremony.repository.PhotographyRepository;

@Component
public class PhotographyServiceImpl implements PhotographyService{
	
	@Autowired
	private PhotographyRepository photographyRepository;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Photography addPhotography(Photography pg) {
       em.persist(pg);
		return pg;
	}

	@Override
	public List<Photography> allPhotography() {
        List<Photography> photographyList=photographyRepository.findAll();
		return photographyList;
	}

	@Override
	@Transactional
	public List<Photography> SearchingByName(String pName) {
		if(pName != null) {
		Query q=em.createQuery("select p from Photography p where p.pName like :PG");
		q.setParameter("PG","%"+pName+"%");
		List<Photography> pname=q.getResultList();
		if(pname.size()==0) {
			String msg="Sorry !! The Photographers "+ pName +" is not available";
			throw new MarriageCeremonyApplicationException(msg);
		}

		return pname;
	}
		String msg="Sorry !! The Photographers "+ pName +" is not available";
		throw new MarriageCeremonyApplicationException(msg);
	}
	
	@Override
	@Transactional
	public int deleteVendor(int vid) {
		return photographyRepository.deleteVendor(vid);
	}

}
