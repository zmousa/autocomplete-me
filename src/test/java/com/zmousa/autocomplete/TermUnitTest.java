package com.zmousa.autocomplete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.algorithms.Insertion;

public class TermUnitTest {

	@Before
    public void setUp() throws Exception {
		
    }
	
	@Test (expected=NullPointerException.class)
    public void testTermQueryThrowNullPointerException() throws NullPointerException {
    	new Term(null, 5);
    }
	
	@Test (expected=IllegalArgumentException.class)
    public void testTermWeightThrowIllegalArgumentException() throws IllegalArgumentException {
    	new Term("term", -5);
    }
	
	@Test
	public void testTermComparableOfLexicographicOrderByQuery(){
		Term term1 = new Term("term2", 1);
		Term term2 = new Term("term1", 4);
		Term term3 = new Term("term3", 2);
		
		Term[] terms = new Term[]{term1, term2, term3};
		
		// sort the terms in lexicographic order.
    	Insertion.sort(terms);
    	
    	assertEquals(term2, terms[0]);
    	assertEquals(term1, terms[1]);
    	assertEquals(term3, terms[2]);
    }
	
	@Test
	public void testTermComparatorOfDescendingOrderByWeight(){
		Term term1 = new Term("term2", 1);
		Term term2 = new Term("term1", 4);
		Term term3 = new Term("term3", 2);
		
		Term[] terms = new Term[]{term1, term2, term3};
		
		// sort the terms in lexicographic order.
    	Insertion.sort(terms, Term.byReverseWeightOrder());
    	
    	assertEquals(term2, terms[0]);
    	assertEquals(term3, terms[1]);
    	assertEquals(term1, terms[2]);
    }
	
	@Test
	public void testTermComparatorOfPrefixOrder(){
		Term term1 = new Term("company", 1);
		Term term2 = new Term("comqlete", 4);
		Term term3 = new Term("companion", 2);
		
		Term[] terms = new Term[]{term1, term2, term3};
		
		// sort the terms in lexicographic order.
    	Insertion.sort(terms, Term.byPrefixOrder(4));
    	
    	assertEquals(term1, terms[0]);
    	assertEquals(term3, terms[1]);
    	assertEquals(term2, terms[2]);
    }
	
	@Test
	public void testTermToStringFormat(){
		Term term1 = new Term("term", 1);
    	
    	assertEquals("1.00	term", term1.toString());
    }
}
