package com.me.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.me.entity.Cook;
import com.me.exception.CookNotFoundException;
import com.me.service.CookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CookController {

	@Autowired
	private CookService cookService;
	
	@PostMapping(value = "/register", consumes={MediaType.APPLICATION_JSON_VALUE})
	public Cook registerCook(@Valid @RequestBody Cook cook) {
		return cookService.registerCook(cook);
	}
	
	@PutMapping(value = "/update/{id}",consumes={MediaType.APPLICATION_JSON_VALUE})
	public Cook updateCook(@PathVariable("id") int cookid,@RequestBody @Valid Cook cook) {
		Cook cook_original = cookService.getCook(cookid);
		
		String name_orig = cook_original.getName();
		if(!name_orig.equals(cook.getName())) {
			cook_original.setName(cook.getName());
		}
		
		String email_orig = cook_original.getCookEmail();
		if(!email_orig.equals(cook.getCookEmail())) {
			cook_original.setCookEmail(cook.getCookEmail());
		} 
		
		if(cook_original.getAge() != cook.getAge()) {
			cook_original.setAge(cook.getAge());
		}
		
		return cookService.registerCook(cook_original);
		
	}
		
	
	@DeleteMapping(value = "/delete/{id}")
	public Cook deleteCook(@PathVariable("id") int cookid) throws CookNotFoundException {
		return cookService.deleteCook(cookid);
	}
	
	@GetMapping(value = "/get/{id}")
	public Cook getCook(@PathVariable("id") int cookid) throws CookNotFoundException{
		return cookService.getCook(cookid);
	}
	
	@GetMapping(value = "/getAll")
	public List<Cook> getCooks() {
		return cookService.getCooks();
	}
}