package com.cg.marriageceremony.service;

import java.util.List;

import com.cg.marriageceremony.model.Caterers;



public interface CaterersService {
	Caterers addCaterers(Caterers ct);
	List<Caterers> allCateres();
	List<Caterers> SearchingByName(String cName);
	int deleteVendor(int vid);

}
