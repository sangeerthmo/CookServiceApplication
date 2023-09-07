package com.me;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.me.entity.Cook;
import com.me.service.CookService;

@SpringBootTest
public class CookRepoTest {
	
	@MockBean
	private CookService cookService;
	
	@Test
	public void testRegister() {
		Cook cook = new Cook(2,"bvk","cook@gmail.com" , 45);
		
		Mockito.when(cookService.registerCook(cook)).thenReturn(cook);
	}
	
	@Test
	public void testGet() {
		Cook cook = new Cook(2,"bvk","cook@gmail.com" , 45);
		
		Mockito.when(cookService.getCook(2)).thenReturn(cook);
	}
}