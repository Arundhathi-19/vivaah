package com.cg.marriageceremony.service;

import java.util.List;

import com.cg.marriageceremony.model.Photography;



public interface PhotographyService {
	Photography addPhotography(Photography pg);
	List<Photography> allPhotography();
	List<Photography> SearchingByName(String pName);
	int deleteVendor(int vid);

}
