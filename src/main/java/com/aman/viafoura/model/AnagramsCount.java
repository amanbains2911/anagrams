/**
 * 
 */
package com.aman.viafoura.model;

import java.util.Arrays;

/**
 * @author amanb
 *
 */

public class AnagramsCount {
	
	private String[] anagrams;

	public AnagramsCount() {
		super();
	}

	public String[] getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(String[] anagrams) {
		this.anagrams = anagrams;
	}

	@Override
	public String toString() {
		return "{ anagrams: " +"AnagramsCount [anagrams=" + Arrays.toString(anagrams) + "]"+"}";
	}

	public AnagramsCount(String[] anagrams) {
		this.anagrams = anagrams;
	}

	
	
}
