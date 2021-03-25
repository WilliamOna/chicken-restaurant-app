package com.revature.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest // I can now use the app context for my tests
@ExtendWith(SpringExtension.class) // ExtendWith: tell junit 5 that it should play nice with spring
public class BuffaloChickenServiceTest {	
	
	@Autowired
	BuffaloChickenService buffaloChickenService;
	
	@Test
	public void should_return_correct_list_of_buffalo_chicken() {
		
	}
}
