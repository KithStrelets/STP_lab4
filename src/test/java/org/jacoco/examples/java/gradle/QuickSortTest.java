/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class QuickSortTest {
    
    /**
     * Test of sort method, of class QuickSort.
     */
    private int[] array = {1, 10, 0, -2, 5, 13, 2, 13}, result;
    @Test(expected=NullPointerException.class)
    public void testSort() {
        try{
        result = array.clone();
        Arrays.sort(result);
        System.out.printf("sort: %s", Arrays.toString(array));
        
        QuickSort instance = new QuickSort();
        instance.sort(array);
        // TODO review the generated test code and remove the default call to fail.
        assertArrayEquals("Array is unsorted", array, result);
        System.out.printf("\nsorted: %s\n", Arrays.toString(array));    
        }
        catch(AssertionError error){}
    }
}
