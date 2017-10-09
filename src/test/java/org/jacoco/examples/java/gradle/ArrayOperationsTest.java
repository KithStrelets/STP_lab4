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
public class ArrayOperationsTest {
    
    ArrayOperations arOps = new ArrayOperations();
    private final int[] targetArray = new int[]{1, 10, 0, -2, 5, 13, 2, 13};
    private final int[][] targetMatrix = new int[][]{
        {1,0,-1,5,2},
        {2,3,4,-5,0},
        {1,2,3,4,5},
        {0,0,0,0,0},
        {-1,-1,-1,-1,-1}
    };
 
// <editor-fold defaultstate="collapsed" desc=" method part1() ">
    /**
     * Test of method part1 of class ArrayOperations.
     */
    @Test
    public void testPart1ArrayIsNotNull() {
        arOps.part1(targetArray);
        assertNotNull("There is no array to operate with",arOps.getArray());
    }
    @Test
    public void testPart1SumOfPairNumbers() {
        arOps.part1(targetArray);
        assertEquals("Numper of paired elements is wrong",4, arOps.getPairedNum());
    }
    @Test
    public void testPart1TripledSum() {
        arOps.part1(targetArray); 
        assertEquals("3x sum of elements is wrong",126, arOps.getTripleSum());
    }
    @Test
    public void testPart1MinAndMaxDifferance() {
        arOps.part1(targetArray);     
        assertEquals("Arithmetical differance between min and max numbers is wrong",15, arOps.getMinMaxDif());
    }
    @Test
    public void testPart1MeanOfArray() {
        arOps.part1(targetArray);        
        assertEquals("Array mean is wrong",5, arOps.getArrayMean());
    }
    @Test
    public void testPart1SumOfMaxAndMinNumbers() {
        arOps.part1(targetArray);        
        assertEquals("Sum of all MINs and MAXs is wrong",24, arOps.getMinMaxSum());
    }
    @Test
    public void testPart1AbsoluteArrayMaximum() {
        arOps.part1(targetArray);        
        assertEquals("Absolute MAX number is wrong",13, arOps.getAbsMax());
    }
    // </editor-fold>
    
    @Test
    public void testPart2MatrixIsNotNull(){ 
        arOps.part2(targetMatrix);
        assertNotNull("There is no matrix to operate with",arOps.getMatrix());
    }
    @Test
    public void testPart2MatrixSumAfterFirstNegative(){
        arOps.part2(targetMatrix);
        assertArrayEquals("Row count is wrong",new int[]{7,0,100,100,-4}, arOps.getSumAfterFirst());
    }
    @Test
    public void testPart2MatrixSumBeforeLastNegative(){
        arOps.part2(targetMatrix);
        assertArrayEquals("Row count is wrong",new int[]{1,9,-1,-1,-4}, arOps.getSumBeforeLast());
    }
    @Test
    public void testPart2MatrixGetRowsWithAllZeroNumbers(){
        arOps.part2(targetMatrix);
        assertEquals("Doesn't detect necessary rows",Arrays.toString(new int[]{3,4}), Arrays.toString(arOps.getVectorZero().toArray()));
    }
    @Test
    public void testPart2MatrixGetRowsWithAllSameNumbers(){
        arOps.part2(targetMatrix);
        assertEquals("Doesn't detect necessary rows",Arrays.toString(new int[]{3,4}),Arrays.toString(arOps.getVectorSameNum().toArray()));
    }
    @Test
    public void testPart2MatrixDetectsRowsWithAllPositiveNumbers(){
        arOps.part2(targetMatrix);
        int[] actual = arOps.getSumAfterFirst();
        assertEquals("Doesn't detect the rule of 100",100, actual[2]);
        assertEquals("Doesn't detect the rule of 100",100, actual[3]);
        actual = arOps.getSumBeforeLast();
        assertEquals("Doesn't detect the rule of -1",-1, actual[2]);
        assertEquals("Doesn't detect the rule of -1",-1, actual[3]);        
    }
    
    
}
