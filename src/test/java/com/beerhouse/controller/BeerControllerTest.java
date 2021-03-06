package com.beerhouse.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BeerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getReturn200() throws Exception {
		URI uri = new URI("/beer");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void getParamReturn200() throws Exception {
		URI uri = new URI("/beer/2");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void postReturn201Created() throws Exception {
		URI uri = new URI("/beer");
		String json = "{\"name\": \"CERVEJA 4\",\"ingredients\":\"LÚPULO,MALTE,AGUA,BAUNILHA\", \"alcoholContent\": \"1%\",\"price\": 50.50,\"categoryName\": \"PILSEN\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
	}
	
	@Test
	public void putReturn200() throws Exception {
		URI uri = new URI("/beer/3");
		String json = "{\"name\": \"CERVEJA PUT\",\"ingredients\":\"LÚPULO,MALTE,AGUA,BAUNILHA\", \"alcoholContent\": \"5%\",\"price\": 10.50,\"categoryName\": \"PILSEN\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void putReturn404() throws Exception {
		URI uri = new URI("/beer/1000");
		String json = "{\"name\": \"CERVEJA PUT\",\"ingredients\":\"LÚPULO,MALTE,AGUA,BAUNILHA\", \"alcoholContent\": \"5%\",\"price\": 10.50,\"categoryName\": \"PILSEN\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}
	
	@Test
	public void patchReturn200() throws Exception {
		URI uri = new URI("/beer/1");
		String json = "{\"name\": \"CERVEJA PUT\",\"ingredients\":\"LÚPULO,MALTE,AGUA,BAUNILHA\", \"alcoholContent\": \"5%\",\"price\": 10.50,\"categoryName\": \"PILSEN\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.patch(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void patchReturn404() throws Exception {
		URI uri = new URI("/beer/1000");
		String json = "{\"name\": \"CERVEJA Patch\",\"ingredients\":\"LÚPULO,MALTE,AGUA,BAUNILHA\", \"alcoholContent\": \"5%\",\"price\": 10.50,\"categoryName\": \"PILSEN\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.patch(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}
	
	@Test
	public void deleteReturn204() throws Exception {
		URI uri = new URI("/beer/1");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(204));
	}
	
	@Test
	public void deleteReturn404() throws Exception {
		URI uri = new URI("/beer/10");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}
	
}
