package com.zmousa.autocomplete;

import java.util.Comparator;

public class Term implements Comparable<Term>{
	private final String query;
	private final double weight;
    
	public Term(final String query, final double weight) { 
        if(query == null)
            throw new NullPointerException();
        if(weight < 0)
            throw new IllegalArgumentException();

        this.query = query;
        this.weight = weight;
    }

	public String getQuery() {
		return query;
	}

	public double getWeight() {
		return weight;
	}

	// Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	return new Comparator<Term>() { 
            public int compare(final Term term1, final Term term2) { 
                //Compare weights in reverse order
                return ((Double)term2.weight).compareTo(term1.weight);
            }
        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(final int r){
    	if(r < 0)
            throw new IllegalArgumentException();
    	return new Comparator<Term>() {
            public int compare(final Term term1, final Term term2) {
            	// Subset the first r characters of each query
            	String subQuery1 = term1.query; 
            	if(term1.query.length() > r)
            		subQuery1 = term1.query.subSequence(0, r).toString();
            	
            	String subQuery2 = term2.query; 
            	if(term2.query.length() > r)
            		subQuery2 = term2.query.subSequence(0, r).toString();
            	
                return subQuery1.compareTo(subQuery2);
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
    	return this.query.compareTo(that.query);
	}

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
    	return String.format("%.2f\t%s", this.weight, this.query);
    }
}
