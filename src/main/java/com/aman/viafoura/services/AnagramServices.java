/**
 * 
 */
package com.aman.viafoura.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.viafoura.exception.ViafouraExceptions;
import com.aman.viafoura.model.AnagramModel;

/**
 * @author amanb
 *
 */
@Service
public class AnagramServices {
	
	@Autowired
	private  AnagramModel anagramModel;
	
	public AnagramModel isAnagram(String firstWord, String secondWord) throws ViafouraExceptions {
		
		if(!((firstWord.matches("^[a-zA-Z]*$"))&&(secondWord.matches("^[a-zA-Z]*$")))) {
			throw new ViafouraExceptions();
		}
		if(firstWord.length()!=secondWord.length()) {
			anagramModel.setAreAnagrams(false);
			return anagramModel;
		}
	     char[] word1 = firstWord.replaceAll("[\\s+]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s+]", "").toCharArray();	 
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     boolean s= Arrays.equals(word1, word2);
	     anagramModel.setAreAnagrams(s);
	     return anagramModel;
	}


}
