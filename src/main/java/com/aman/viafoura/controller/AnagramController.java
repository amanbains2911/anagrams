/**
 * 
 */
package com.aman.viafoura.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aman.viafoura.exception.AnagramsException;
import com.aman.viafoura.exception.ViafouraExceptions;
import com.aman.viafoura.model.AnagramModel;
import com.aman.viafoura.model.AnagramsCount;
import com.aman.viafoura.services.AnagramServices;

/**
 * @author amanb
 *
 */
@RestController
@RequestMapping("/anagrams")
public class AnagramController {

	@Autowired
	private AnagramServices agm;

	@Autowired
	private AnagramsCount act;

	@GetMapping("/{string1}/{string2}")
	public AnagramModel isAnagram(@PathVariable String string1, @PathVariable String string2)
			throws ViafouraExceptions {
		return agm.isAnagram(string1, string2);
	}

	@GetMapping("/{string1}")
	public String[] printAllAnagrams(@PathVariable String string1) throws AnagramsException {
		if(!(string1.matches("^[a-zA-Z]*$"))) {
			throw new AnagramsException();
		}
		List<String> allAnagrams = new ArrayList<>();
		checkAnagrams(string1, "",allAnagrams);
		act.setAnagrams(allAnagrams.toArray(new String[allAnagrams.size()]));
		return act.getAnagrams();
	}

	private void checkAnagrams(String word1, String string2,List<String> al) {
		if (word1.length() == 0) {
			al.add(string2);
			return ; 
		}
		 boolean ar[] = new boolean[26];
		   for (int i = 0; i < word1.length(); i++) {
			char ch = word1.charAt(i);
			String newN = word1.substring(0, i) + word1.substring(i + 1);
			if (ar[ch - 'a'] == false) 
				checkAnagrams(newN, string2 + ch,al);
			 ar[ch - 'a'] = true;
		}
	}
}
