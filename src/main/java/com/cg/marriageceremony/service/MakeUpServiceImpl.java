package com.cg.marriageceremony.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.exceptions.MarriageCeremonyApplicationException;
import com.cg.marriageceremony.model.MakeUp;
import com.cg.marriageceremony.repository.MakeUpRepository;

@Component
public class MakeUpServiceImpl implements MakeUpService{

	@Autowired
	private MakeUpRepository MakeUpRepository;
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public MakeUp addMakeUp(MakeUp mu) {
		em.persist(mu);
		return mu;
	}

	@Override
	public List<MakeUp> allMakeUp() {
		List<MakeUp> makeupList=MakeUpRepository.findAll();		
		return makeupList;
	}

	@Override
	@Transactional
	public List<MakeUp> SearchingByName(String mName) {
		if(mName != null) {
		Query q=em.createQuery("select m from MakeUp m where m.mName like :MU");
		q.setParameter("MU","%"+mName+"%");
		List<MakeUp> mname=q.getResultList();
		if(mname.size()==0) {
			String msg="Sorry !! The MakeUp "+ mName +" is not available";
			throw new MarriageCeremonyApplicationException(msg);
		}
		return mname;
	}
			String msg="Sorry !! The MakeUp "+ mName +" is not available";
			throw new MarriageCeremonyApplicationException(msg);

}
	
}