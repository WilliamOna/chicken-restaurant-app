package com.revature.controller;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.model.BuffaloChicken;
import com.revature.service.BuffaloChickenService;

@WebMvcTest(BuffaloChickenController.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BuffaloChickenControllerTest {
	private MockMvc mockMvc;
	
	@MockBean
	BuffaloChickenService buffaloChickenService;
	
	@InjectMocks
	BuffaloChickenController buffaloChickenController;
	
	
	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(buffaloChickenController).build();
	}
	
	@Test
	public void should_return_200_and_correct_list() throws Exception {
		
		//setup expected value
		List<BuffaloChicken>chickens = new ArrayList<>();
		chickens.add(new BuffaloChicken(1, 7, "chicken wings, buffalo sauce", "entree", "wings"));
		chickens.add(new BuffaloChicken(2, 5, "grilled chicken, buffalo sauce, lettuce", "side", "salad"));
		chickens.add(new BuffaloChicken(3, 3, "blended chicken, buffalo sauce, vodka", "drink", "protein-shake"));
		ResponseEntity<List<BuffaloChicken>> expected = new ResponseEntity<List<BuffaloChicken>>(chickens, HttpStatus.OK);
		
		when(buffaloChickenService.getAll()).thenReturn(chickens);
		
		//check against actual
//		assertThat(buffaloChickenController.getAll()).isEqualTo(expected);
		
		this.mockMvc.perform(get("/chicken"))
		//check that we have 200 status code
			.andExpect(status().isOk())
			// check to make sure that we are returning a list of objects in our json
			.andExpect(MockMvcResultMatchers.jsonPath("$.*", isA(List.class)))
			// check to make sure that the first item in the list has an id of 1
			.andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(1,2,3)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[*].type").value(Matchers.containsInAnyOrder("entree","drink","side")));
//			.andDo(print());
			;
	}
	
}
