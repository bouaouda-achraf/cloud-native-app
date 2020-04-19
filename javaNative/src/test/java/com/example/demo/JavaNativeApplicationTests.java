package com.example.demo;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//@formatter:off
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//@formatter:on
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.entity.Cat;
import com.example.demo.repo.CatRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class JavaNativeApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private CatRepository catRepository;

	@Before
	public void before() throws Exception {
		Stream.of("Felix", "Garfield", "Whiskers").forEach(n -> catRepository.save(new Cat(n)));
		Arrays.asList("dd","ee").stream().forEach(cat-> catRepository.save(new Cat(cat)));
	}
	
	@Test
	public void catsReflectedInRead() throws Exception {
		MediaType halJson = MediaType.parseMediaType("application/hal+json");
		this.mvc.perform(MockMvcRequestBuilders.get("/cats"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(halJson))
				.andExpect(mvcResult -> {
					String contentAsString = mvcResult.getResponse().getContentAsString();
					Assert.assertTrue(
							contentAsString.split("totalElements")[1].split(":")[1].trim().split(",")[0].equals("5"));
				});
	}

}
