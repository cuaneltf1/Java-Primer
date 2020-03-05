package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.AggService;

@RestController
public class AggController {
	
	@Autowired
	AggService aService;
	
	@GetMapping("/experiment/{sName}/{convert}")
	public ResponseEntity<List<SpeedResult>> getMethod(@PathVariable getItem("sName") String sName, @PathVariable ("convert") String convert) {
		SpeedResult sResult = aService.findByName(sName);
		sResult = aService.convert(convert);
		return sResult;
	}
	
	@PostMapping
	public ResponseEntity


