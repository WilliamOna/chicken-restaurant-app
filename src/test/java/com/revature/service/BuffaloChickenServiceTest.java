package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.model.BuffaloChicken;


@SpringBootTest // I can now use the app context for my tests
@ExtendWith(SpringExtension.class) // ExtendWith: tell junit 5 that it should play nice with spring
public class BuffaloChickenServiceTest {	
	
	@Autowired
	BuffaloChickenService buffaloChickenService;
	
	@Test
	public void should_return_correct_list_of_buffalo_chicken() {
		//create hard-coded expected value
		List<BuffaloChicken> chickens = new ArrayList<>();
		chickens.add(new BuffaloChicken(1, 7, "chicken wings, buffalo sauce", "entree", "wings"));
		chickens.add(new BuffaloChicken(2, 5, "grilled chicken, buffalo sauce, lettuce", "side", "salad"));
		chickens.add(new BuffaloChicken(3, 3, "blended chicken, buffalo sauce, vodka", "drink", "protein-shake"));
		
		//make the assertion to see if the test passes
		assertEquals(chickens, buffaloChickenService.getAll());
	}
}
