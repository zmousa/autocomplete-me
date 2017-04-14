package com.zmousa.autocomplete;

import edu.princeton.cs.algorithms.Insertion;

public class AutoComplete {
	private final Term[] terms;

    //Constructor
    public AutoComplete(final Term[] terms) { 
        this.terms = terms;
    }

    //Return all terms that start with the prefix in descending order of weights
    public Term[] allMatches(final String prefix) { 
    	// sort the terms in lexicographic order.
    	Insertion.sort(terms);
    	
    	// find first and last index for query strings that start with a given prefix;
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));

        // No matches
        if (start == -1)
        	return new Term[0];
        
        // collect all queries between start and last indexes.
        Term[] matches = new Term[end - start + 1];
        for(int i = 0; start <= end; i++, start++) { 
            matches[i] = this.terms[start];
        }
        // sort the matching terms in descending order by weight.
        Insertion.sort(matches, Term.byReverseWeightOrder());

        return matches;
    }
    
    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
    	// sort the terms in lexicographic order.
    	Insertion.sort(terms);
    	
    	// find first and last index for query strings that start with a given prefix;
        int start = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int end = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));

        // No matches
        if (start == -1)
        	return 0;
        
        // find the all query strings that start with a given prefix.
        return end - start + 1;
    }
}
