package com.zmousa.autocomplete;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AutoCompleteUnitTest {

	private static Term[] terms;
	
	@Before
    public void setUp() throws Exception {
		Term term1 = new Term("comapny", 1);
		Term term2 = new Term("term1", 4);
		Term term3 = new Term("term3", 2);
		
		terms = new Term[]{term1, term2, term3};
    }
	
	@Test
	public void testAllMatches(){
		AutoComplete autoComplete = new AutoComplete(terms);
		Term[] matches = autoComplete.allMatches("term");
    	
		int expectedMatches = 2;
    	assertEquals(expectedMatches, matches.length);
    	
    	assertEquals(terms[1], matches[0]);
    	assertEquals(terms[2], matches[1]);
    }
	
	@Test
	public void testNumberOfMatches(){
		AutoComplete autoComplete = new AutoComplete(terms);
		int noOfMatches = autoComplete.numberOfMatches("term");
    	
		int expectedMatches = 2;
    	assertEquals(expectedMatches, noOfMatches);
    }
	
	@Test
	public void testEmptyAllMatches(){
		AutoComplete autoComplete = new AutoComplete(terms);
		Term[] matches = autoComplete.allMatches("zaher");
    	
		int expectedMatches = 0;
    	assertEquals(expectedMatches, matches.length);
    }
}
