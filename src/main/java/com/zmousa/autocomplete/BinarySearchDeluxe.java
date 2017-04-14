package com.zmousa.autocomplete;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {
	public static <Key> int firstIndexOf(final Key[] array, final Key key, Comparator<Key> comparator) { 
        //Check input
        if(array == null || key == null || comparator == null) 
            throw new NullPointerException();

        //Do binary search to find any index in the sorted array
        int occurIndex = Arrays.binarySearch(array, key, comparator);

        //Not found, return -1
        if(occurIndex < 0)
            return -1;

        //Find the first occurrence
        while(occurIndex - 1 >= 0 && comparator.compare(key, array[occurIndex - 1]) == 0)
            occurIndex--;
        
        return occurIndex;
    }

    public static <Key> int lastIndexOf(final Key[] array, Key key, Comparator<Key> comparator) { 
    	//Check input
        if(array == null || key == null || comparator == null)
             throw new NullPointerException();

        //Do binary search to find any index in the sorted array
        int occurIndex = Arrays.binarySearch(array, key, comparator);

        //Not found, return -1
        if(occurIndex < 0)
            return -1;

        //Find the last occurrence
        while(occurIndex + 1 < array.length && comparator.compare(key, array[occurIndex + 1]) == 0)
            occurIndex++;
        
        return occurIndex;
    }
}
