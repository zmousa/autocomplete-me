package com.zmousa.autocomplete;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchDeluxeUnitTest {

	private static Term[] terms;
	
	@Before
    public void setUp() throws Exception {
		Term term1 = new Term("comapny", 1);
		Term term2 = new Term("term1", 4);
		Term term3 = new Term("term3", 2);
		
		terms = new Term[]{term1, term2, term3};
    }
	
	@Test (expected=NullPointerException.class)
    public void testFirstIndexArrayNullThrowNullPointerException() throws NullPointerException {
		Term key = new Term("term", 5);
    	BinarySearchDeluxe.firstIndexOf(null, key, Term.byPrefixOrder(key.getQuery().length()));
    }
	
	@Test (expected=NullPointerException.class)
    public void testFirstIndexKeyNullThrowNullPointerException() throws NullPointerException {
		Term key = new Term("term", 5);
    	BinarySearchDeluxe.firstIndexOf(terms, null, Term.byPrefixOrder(key.getQuery().length()));
    }
	
	@Test (expected=NullPointerException.class)
    public void testFirstIndexComparatorNullThrowNullPointerException() throws NullPointerException {
		Term key = new Term("term", 5);
    	BinarySearchDeluxe.firstIndexOf(terms, key, null);
    }
	
	@Test (expected=NullPointerException.class)
    public void testLastIndexArrayNullThrowNullPointerException() throws NullPointerException {
		Term key = new Term("term", 5);
    	BinarySearchDeluxe.lastIndexOf(null, key, Term.byPrefixOrder(key.getQuery().length()));
    }
	
	@Test (expected=NullPointerException.class)
    public void testLastIndexKeyNullThrowNullPointerException() throws NullPointerException {
		Term key = new Term("term", 5);
    	BinarySearchDeluxe.lastIndexOf(terms, null, Term.byPrefixOrder(key.getQuery().length()));
    }
	
	@Test (expected=NullPointerException.class)
    public void testLastIndexComparatorNullThrowNullPointerException() throws NullPointerException {
		Term key = new Term("term", 5);
    	BinarySearchDeluxe.lastIndexOf(terms, key, null);
    }
	
	@Test
	public void testFirstIndex(){
		Term key = new Term("term", 5);
    	int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(key.getQuery().length()));
    	int expectedFirstIndex = 1;
    	assertEquals(expectedFirstIndex, firstIndex);
    }
	
	@Test
	public void testLastIndex(){
		Term key = new Term("term", 5);
    	int firstIndex = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(key.getQuery().length()));
    	int expectedLastIndex = 2;
    	assertEquals(expectedLastIndex, firstIndex);
    }
	
	@Test
	public void testFirstIndexNotFound(){
		Term key = new Term("zaher", 5);
    	int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, key, Term.byPrefixOrder(key.getQuery().length()));
    	int expectedFirstIndex = -1;
    	assertEquals(expectedFirstIndex, firstIndex);
    }
	
	@Test
	public void testLastIndexNotFound(){
		Term key = new Term("zaher", 5);
    	int firstIndex = BinarySearchDeluxe.lastIndexOf(terms, key, Term.byPrefixOrder(key.getQuery().length()));
    	int expectedLastIndex = -1;
    	assertEquals(expectedLastIndex, firstIndex);
    }
}
