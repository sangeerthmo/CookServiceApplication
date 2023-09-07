package com.me.service;

import java.util.List;

import com.me.entity.Cook;
import com.me.exception.CookNotFoundException;
//import com.me.entity.Employee;


public interface CookService {
	public Cook registerCook(Cook cook);
	public Cook updateCook(Cook cook);
	public Cook deleteCook(int cookid) throws CookNotFoundException;
	public Cook getCook(int cookid) throws CookNotFoundException;
	public List<Cook> getCooks();
}

