package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.WorstRequestException;
import com.revature.models.SpeedResult;
import com.revature.repositories.SpeedResultRepo;

@RestController
@RequestMapping("/api/speedresult")
public class SpeedResultController {
	
	@Autowired
	private SpeedResultRepo repo;
	
	@GetMapping("/{sName}") 
	public List<SpeedResult> findByName(@PathVariable String sName) {
		try {
			List<SpeedResult> sR = repo.findBySubjectName(sName);
			return sR;
		} catch (IllegalArgumentException e) {
			throw new WorstRequestException();
		}
	}
	
	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.OK)
	public SpeedResult save(@RequestBody SpeedResult sR) {
		try {
		 return repo.save(sR);
		} catch (IllegalArgumentException e) {
			throw new WorstRequestException();
		}
	}
}
