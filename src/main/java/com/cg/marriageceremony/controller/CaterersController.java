package com.cg.marriageceremony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.marriageceremony.model.Caterers;
import com.cg.marriageceremony.service.CaterersService;

@RestController
@RequestMapping("/marriageceremony")
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class CaterersController {
	
	@Autowired
	private CaterersService caterersService;
	
	@PostMapping("/add-caterers")
	public  Caterers addCateres(@RequestBody  Caterers ct) {
		Caterers caterers=caterersService.addCaterers(ct);
				return caterers;
	}
	
	@GetMapping("/get-all-caterers")
	public List<Caterers> allCateres(){
		return caterersService.allCateres();
	}
	
    @GetMapping("/searchBy-catererName")
    public List<Caterers> SearchingByName(@RequestParam("cName") String cName){
    	return caterersService.SearchingByName(cName);
    }
	
    @DeleteMapping("/delete-caterers/{vid}")
    public int deleteVendor(@PathVariable("vid") int vendoeId) {
    	return caterersService.deleteVendor(vendoeId);
    }
}