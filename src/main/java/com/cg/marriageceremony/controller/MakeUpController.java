package com.cg.marriageceremony.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.cg.marriageceremony.model.MakeUp;
import com.cg.marriageceremony.service.MakeUpService;

@RestController
@RequestMapping("/marriageceremony")
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})

public class MakeUpController {
	@Autowired
	private MakeUpService makeupService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/add-makeup")
	public  MakeUp addMakeUp(@RequestBody  MakeUp mu) {
		MakeUp makeup=makeupService.addMakeUp(mu);
				return makeup;
	}
	
	@GetMapping("/get-all-makeup")
	public List<MakeUp> allMakeUp(){
		return makeupService.allMakeUp();
	}
	
    @GetMapping("/search-By-makeupName")
    public List<MakeUp> SearchingByName(@RequestParam("mname") String mName){
    	return makeupService.SearchingByName(mName);
    }
   
}
