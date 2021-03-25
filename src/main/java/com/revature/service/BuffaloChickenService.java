package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.BuffaloChicken;
import com.revature.repository.BuffaloChickenRepository;

@Service
public class BuffaloChickenService {
	private BuffaloChickenRepository buffaloChickenRepository;
	
	@Autowired
	public BuffaloChickenService(BuffaloChickenRepository buffaloChickenRepository) {
		this.buffaloChickenRepository = buffaloChickenRepository;
	}
	
	public List<BuffaloChicken> getAll(){
		return null;
	}
}
