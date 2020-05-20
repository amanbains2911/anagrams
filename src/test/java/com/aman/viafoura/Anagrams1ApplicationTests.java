package com.aman.viafoura;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.aman.viafoura.exception.ViafouraExceptions;
import com.aman.viafoura.model.AnagramModel;
import com.aman.viafoura.services.AnagramServices;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class Anagrams1ApplicationTests {

	@Autowired
	private  AnagramModel agm;
	
	@Autowired
	private AnagramServices agm1;
	
	private static final String ROOT_URl="http://localhost:8080";
	RestTemplate resTem=new RestTemplate();
	
	@Test
	public void isAnagram() throws ViafouraExceptions {
		String word1="iceman";
		String word2="cinema";
		String word3="union";
		 agm.setAreAnagrams(agm1.isAnagram(word1, word2).isAreAnagrams());
		 assertTrue(agm.isAreAnagrams());
		 agm.setAreAnagrams(agm1.isAnagram(word1, word3).isAreAnagrams());
		 assertFalse(agm.isAreAnagrams());	 
	}
	
	@Test
	public void getAnagrams() {
		ResponseEntity<AnagramModel> responseEntity1=resTem.getForEntity(ROOT_URl+"/anagrams/iceman/cinema", AnagramModel.class);
		ResponseEntity<AnagramModel> responseEntity2=resTem.getForEntity(ROOT_URl+"/anagrams/union/cinema", AnagramModel.class);
		AnagramModel am1=responseEntity1.getBody();
		assertTrue(am1.isAreAnagrams());
		assertNotNull(am1, "Response am1 is not Null");
		AnagramModel am2=responseEntity2.getBody();
		assertFalse(am2.isAreAnagrams());
		assertNotNull(am2, "Response am2 is not Null");
	}
	
	@Test
	public void getListofAnagrams() {
		ResponseEntity<String[]> responseEntity1=resTem.getForEntity(ROOT_URl+"/anagrams/abc", String[].class);
		ResponseEntity<String[]> responseEntity2=resTem.getForEntity(ROOT_URl+"/anagrams/union", String[].class);
		String[] anagramm1=responseEntity1.getBody();
		assertEquals(6,anagramm1.length);
		assertNotNull(anagramm1);
		String[] anagramm2=responseEntity2.getBody();
		assertEquals(60,anagramm2.length);
		assertNotNull(anagramm2);
	}
	
}
