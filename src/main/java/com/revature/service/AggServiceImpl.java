package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repo.AggRepoImp;

@Service
public class AggServiceImpl implements AggService{

	@Autowired
	private AggRepoImp aRepo;
	
	@Override
	public SpeedResult findByName(String name) {
		return aRepo.findByName(name);
	}

}
