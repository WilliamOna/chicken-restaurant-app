package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.BuffaloChicken;
import com.revature.service.BuffaloChickenService;

@RestController
public class BuffaloChickenController {
	
	@Autowired
	private BuffaloChickenService buffaloChickenService;
	// we want to respond to a GET request at "/chicken" to get all the chicken
	@GetMapping("/chicken")
	public ResponseEntity<List<BuffaloChicken>> getAll(){
		
		return new ResponseEntity<List<BuffaloChicken>>(buffaloChickenService.getAll(), HttpStatus.OK);
	}
}
