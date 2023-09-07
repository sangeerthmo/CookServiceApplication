package com.me.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.dao.CookRepository;
import com.me.entity.Cook;
import com.me.exception.CookNotFoundException;

@Service
public class CookServiceImpl implements CookService {

	@Autowired
	private CookRepository cookRepo;
	
	@Override
	public Cook registerCook(Cook cook) {
		return cookRepo.save(cook);
	}

	@Override
	public Cook updateCook(Cook cook) {
		return cookRepo.save(cook);
	}

	@Override
	public Cook deleteCook(int cookid)  throws CookNotFoundException{
		Optional<Cook> cook = cookRepo.findById(cookid);
		
		Cook coo = null;
		if(cook.isPresent()) {
			cookRepo.deleteById(cookid);
			coo = cook.get();
		}else {
			throw new CookNotFoundException("No such cook");
		}
		return coo;
	}

	@Override
	public Cook getCook(int cookid)  throws CookNotFoundException{
		Optional<Cook> cook = cookRepo.findById(cookid);
		Cook coo = null;
		if(cook.isPresent()) {
			coo = cook.get();
		}else {
			throw new CookNotFoundException("No such cook");
		}
		return coo;
	}

	

	@Override
	public List<Cook> getCooks() {
		return cookRepo.findAll();
	}
	
}