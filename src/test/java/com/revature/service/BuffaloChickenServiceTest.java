package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.el.ArrayELResolver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.model.BuffaloChicken;
import com.revature.repository.BuffaloChickenRepository;


//@SpringBootTest // I can now use the app context for my tests
@ExtendWith(MockitoExtension.class) // ExtendWith: tell junit 5 that it should play nice with spring
public class BuffaloChickenServiceTest {	
	
	@InjectMocks
	BuffaloChickenService buffaloChickenService;
	
	@Mock
	BuffaloChickenRepository buffaloChickenRepository;
	
	List<BuffaloChicken> chickens;
	
	
	@BeforeEach
	public void setup() {
		//create hard-coded expected value
		chickens = new ArrayList<>();
		chickens.add(new BuffaloChicken(1, 7, "chicken wings, buffalo sauce", "entree", "wings"));
		chickens.add(new BuffaloChicken(2, 5, "grilled chicken, buffalo sauce, lettuce", "side", "salad"));
		chickens.add(new BuffaloChicken(3, 3, "blended chicken, buffalo sauce, vodka", "drink", "protein-shake"));
		when(buffaloChickenRepository.findAll()).thenReturn(chickens);
	}
	
	@AfterEach
	public void teardown() {
		chickens = null;
	}
	
	@Test
	public void should_return_correct_list_of_buffalo_chicken() {
		
		//make the assertion to see if the test passes
		assertEquals(chickens, buffaloChickenService.getAll());
	}
}
