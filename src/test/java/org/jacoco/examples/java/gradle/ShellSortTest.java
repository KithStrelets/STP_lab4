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
public class ShellSortTest {
    

    /**
     * Test of sort method, of class ShellSort.
     */
    private final int[] array = {1, 10, 0, -2, 5, 13, 2, 13};
    
    @Test
    public void testSort() {
        int[] result = array.clone();
        Arrays.sort(result);
        //System.out.printf("sort: %s", Arrays.toString(array));  
        ShellSort instance = new ShellSort();
        instance.sort(array);
        assertArrayEquals("Array is unsorted", array, result);
        //System.out.printf("\nsorted: %s\n", Arrays.toString(array));
    }
}
