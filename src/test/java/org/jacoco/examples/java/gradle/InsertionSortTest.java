/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class InsertionSortTest {

    private final int[] target = new int[]{1, 10, 0, -2, 5, 13, 2, 13};

    private int[] expectedResult;

    /**
     * Test of sort method, of class InsertionSort.
     */
     
    @Test
    public void testSort() {

        InsertionSort insertionSort = new InsertionSort();
        int[] actual = expectedResult = target;
        //System.out.printf("sort: %s", Arrays.toString(actual));
        Arrays.sort(expectedResult);
        insertionSort.sort(actual);
        assertArrayEquals("Array is unsorted", expectedResult, actual);
        //System.out.printf("\nsorted: %s\n", Arrays.toString(actual));  
    }     
}
