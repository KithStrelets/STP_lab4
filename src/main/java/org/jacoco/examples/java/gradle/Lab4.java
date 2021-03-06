package org.jacoco.examples.java.gradle;

import java.util.*;
/**
 * Testing javadoc tool
 * Main just greets a user, but java file contains other classes, which are private
* @author Nikita
* 
*/ 
public class Lab4{

    /**
     *main static void
     * @param args
     */
    public static void main(String[] args) {
        
        Greeting gr = new Greeting();
        gr.greet();
    }
}
// <editor-fold defaultstate="collapsed" desc=" Lab1 ">
class Greeting {

    public void greet() {
        System.out.print("Hello from .java!");
    }
}
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" Lab2 ">
class ArrayOperations {

    private int pairedNum,tripleSum, minMaxDif, arrayMean, minMaxSum, absMax;
    public int getPairedNum(){return pairedNum;}
    public int getTripleSum(){return tripleSum;}
    public int getMinMaxDif(){return minMaxDif;}
    public int getArrayMean(){return arrayMean;}
    public int getMinMaxSum(){return minMaxSum;}
    public int getAbsMax(){return absMax;}
            
    private Scanner sc; 
    private int[] arr;
    public int [] getArray(){return arr;}
    
    public void part1(int[] array){
        arr = array;
        if (arr.length == 0){
        sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: "); 
        arr = new int[checkedinput()]; 
        System.out.println("Enter the numbers of the array: ");
                for (int a = 0; a < arr.length; a++) {                           
                        arr[a] = checkedinput();  
                }
        System.out.println("There are "+(arr.length)+ " numbers in array" + "\nArray is: " + Arrays.toString(arr));
        }
        else{
            System.out.printf("%s numbers in array \nArray is: %s\n", arr.length, Arrays.toString(arr));
        }
        Arrays.sort(arr);
        ArrayList<Integer> pair = new ArrayList<Integer>();
        int arraysum = 0;
        minMaxSum = 0;
        int max = arr[arr.length - 1];
        int min = arr[0];
        for(int a = 0; a < arr.length; a++)
        {
            if(arr[a]%2 == 0){
            pair.add(arr[a]);
            }
            arraysum += arr[a];
            if(arr[a] == min | arr[a] == max){
                minMaxSum += arr[a];
            }
        }
        int res = (Math.abs(min)>max)?min:max;
        System.out.println("Number of paired elems: " + (pairedNum = pair.size()) 
                + "\n3x multiplied sum: " + (tripleSum = arraysum*3)
                + "\nDif between min and max: " + (minMaxDif = Math.subtractExact(max,min))
                + "\nArithmetic mean: " + (arrayMean = arraysum/arr.length)
                + "\nSum of the largest and smallest numbers: " + minMaxSum
                + "\nMaximum by module element of the array: " + (absMax = res));         
    }
    
    private ArrayList<Integer> vectorZero, vectorSameNum;
    public ArrayList<Integer> getVectorZero(){return vectorZero;}
    public ArrayList<Integer> getVectorSameNum(){return vectorSameNum;}
    private int[] vectorA, vectorB;
    public int[] getSumAfterFirst(){return vectorA;}
    public int[] getSumBeforeLast(){return vectorB;}
    
    private int[][] mat;
    public int [][] getMatrix(){return mat;}
    
    public void part2(int [][] matrix){
        mat = matrix;
        int RANG;
        int MAX;
        int MIN;
        boolean createMatrix = (mat.length == 0)? true : false;
        vectorZero = new ArrayList<>();
        vectorSameNum = new ArrayList<>();
        boolean checkedA;
        boolean checkedB;
        boolean zeroRow;
        boolean sameNum;
        Random rnd = new Random();
        if(createMatrix){
            sc = new Scanner(System.in);
            System.out.println("\n\nType in the range of numbers in matrix: \nMinimum: ");
            MIN = checkedinput();
            System.out.println("\nMaximum: ");
            MAX = checkedinput();
            System.out.println("\nType in the order N of the square matrix: ");
            RANG = checkedinput();
            mat = new int[RANG][RANG];
        }
        else{
            RANG = matrix.length;
            MAX = 0;
            MIN = 0;
        }
        vectorA = new int[RANG];
        vectorB = new int[RANG];
        for(int i = 0; i < RANG; i++){
            checkedA = checkedB = false;
            zeroRow = sameNum = true;
            int boofer = 0;
            for (int j = 0; j < RANG; j++) {
                if(createMatrix)mat[i][j] = rnd.nextInt(MAX-MIN) + MIN;
                System.out.print("\t" + mat[i][j]);
                if(!checkedA){                    
                    if(j == RANG - 1 & mat[i][j] < 0){
                        vectorA[i] = 0;
                        checkedA = true;
                    }
                    if(j != RANG - 1 & mat[i][j] < 0){
                        boofer = j;
                        checkedA =  true;
                    }
                }
                if(sameNum){
                    if(j != 0 && mat[i][j] != mat[i][j-1]){
                        if(mat[i][j] != 0){
                            zeroRow = false;
                        }
                        sameNum = false;
                    }                    
                }
            }
            System.out.println();
            if(!checkedA) vectorA[i] = 100;  
            else{
                for (int k = boofer + 1; k < RANG; k++) {
                    vectorA[i] += mat[i][k];
                }
            }
            
            if(sameNum){
                if(zeroRow){
                    vectorZero.add(i);
                }
                vectorSameNum.add(i);
            }
            
            if(!checkedB){
                boolean checkedInside = false;
                for(int m = RANG-1; m >= 0; m--){
                    if(checkedInside){
                        vectorB[i] += mat[i][m];                         
                    }
                    else{
                        if(mat[i][m] < 0) checkedInside = true;
                    }                  
                }
                if(!checkedInside)vectorB[i] = -1;
            }
        }
      
        System.out.println("Sum after the first negative: " + Arrays.toString(vectorA));
        System.out.println("Sum before the last negative: " + Arrays.toString(vectorB));
        System.out.println("Rows with all zero numbers: " + Arrays.toString(vectorZero.toArray()));
        System.out.println("Rows with all the same numbers: " + Arrays.toString(vectorSameNum.toArray()));
    }
    
    private int checkedinput(){
        int input;
        while(true){
        try{
            input = sc.nextInt();
            break;
        }
        catch(InputMismatchException | NegativeArraySizeException e){
            System.out.println("Input mistake, type another one:");
            checkedinput();
        }
        }
        return input;
    }    
}

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" Sort methods ">
interface Sorting{
    
    public void sort(int values[]);
}

class BubbleSort implements Sorting{
    
    @Override
    public void sort(int array[]){
        int n = array.length;
        int temp;
        boolean swapped;
        do{
            swapped = false;
            for(int i = 0; i < n; i++){
                if(i != n-1 && array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
            }
        }
        while (swapped);

        //System.out.println("Sorted list of numbers");   
        //System.out.println(Arrays.toString(array));     
        }
}

class InsertionSort implements Sorting{ 
   public int[] targetArray;
    @Override
    public void sort(int array[]){
        targetArray = array;
        int n = array.length; 
         
        for (int j = 1; j < n; j++) {           
            int extracted = array[j];
            int i = j - 1;                          
            while ( (i >= 0) && ( array [i] > extracted ) ) {               
                array [i+1] = array [i]; 
                i--;                  
            }              
            array[i+1] = extracted;          
        }
        //System.out.println("Sorted array: \n" + Arrays.toString(array));
    }
} 

class QuickSort implements Sorting{
    @Override
    public void sort(int array[]){
        quick(array, 0, array.length -1);
    }
    
    private int partition(int array[], int low, int high)
    {
        int i = low-1;
        int temp;
        for (int j = low; j < high; j++)
        {
            if (array[j] <= array[high])
            {
            i++;
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            }
        }

        temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }
    
    private void quick(int array[], int low, int high)
    {
        if (low < high)
        {
        int mid = partition(array, low, high);

        quick(array, low, mid-1);
        quick(array, mid+1, high);
        }
    }
}

class CycleSort implements Sorting{
    
    @Override
    public void sort(int array[]){
        
        int n = array.length;
        int value;
        int position;
        int temp;
        for (int cycleStart = 0; cycleStart < n; cycleStart++) {
            value = array[cycleStart];
            position = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) if(array[i] < value) position++;
            if (position == cycleStart) continue;

            while (value == array[position]) position++;

            temp = array[position];
            array[position] = value;
            value = temp;

            while (position != cycleStart) {
                position = cycleStart;
                for (int i = cycleStart + 1; i < n; i++) if(array[i] < value) position++;

                while (value == array[position]) position++;

                temp = array[position];
                array[position] = value;
                value = temp;
            }
        }
        //System.out.println("Sorted array cycle: \n" + Arrays.toString(array));
    }
}

class ShellSort implements Sorting{
    
    @Override
    public void sort(int array[]){
        
        int n = array.length;
        int temp;
        int j;
        
        for(int d = n / 2; d > 0; d /= 2){
            for(int i = d; i < n; i++){
                temp = array[i];
                for(j = i; j >= d && array[j - d] > temp; j -= d){
                    array[j] = array[j - d];
                }
                array[j] = temp;
            }
        }        
        //System.out.println("lab3.Lab3.shell()" + Arrays.toString(array));
    }
}

class CocktailSort implements Sorting{
    
    @Override
    public void sort(int array[]){
        int n = array.length;
        int start = 0;
        int end = n - 1;
        int temp;
        boolean swapped = true;
        
        while (swapped)
        {
        // reset the swapped flag on entering
        // the loop, because it might be true from
        // a previous iteration.
        swapped = false;
        for (int i = start; i < end; ++i)
        {
        if (array[i] > array[i + 1])
        {
        temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
        swapped = true;
        }
        }

        // if nothing moved, then array is sorted.
        if (!swapped) break;

        // otherwise, reset the swapped flag so that it
        // can be used in the next stage
        swapped = false;

        // move the end point back by one, because
        //  item at the end is in its rightful spot
        end--;

        // from right to left, doing the
        // same comparison as in the previous stage
        for (int i = end - 1; i >= start; --i)
        {
            if (array[i] > array[i + 1])
            {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swapped = true;
            } 
        }

        // increase the starting point, because
        // the last stage would have moved the next
        // smallest number to its rightful spot.
        start++;
        }    
        //System.out.println("lab3.Lab3.cocktail()" + Arrays.toString(array));
    }
}
// </editor-fold>