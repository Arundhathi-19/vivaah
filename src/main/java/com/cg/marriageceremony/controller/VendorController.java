package com.cg.marriageceremony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.marriageceremony.model.Vendor;
import com.cg.marriageceremony.service.VendorService;


@RestController
@RequestMapping("/marriageceremony")
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})

	public class VendorController {
	@Autowired
	private VendorService vendorService;

	@PostMapping("/add-vendor")
	public Vendor addVendor(@RequestBody Vendor v) {
		Vendor vendor = vendorService.addVendor(v);

		return vendor;
	}
	@PutMapping("/{vId}")
	public Vendor updateVendor( @RequestBody Vendor vendor ,@PathVariable int vId) {
		System.out.println("updating .....");
		Vendor v= new Vendor();
		v.setCategory(vendor.getCategory());
		v.setCartItems(vendor.getCartItems());
		v.setPrice(vendor.getPrice());

		return vendorService.updateVendor(v,vId);
	}
	
	@GetMapping("/get-all-vendor")
	public List<Vendor> findAllVendor() {
		return vendorService.allVendor();
	}
	
	@DeleteMapping("/delete-vendor/{vid}")
	public int deleteVendor(@PathVariable("vid") int vid) {
		return vendorService.deleteVendor(vid);
	}
}

	