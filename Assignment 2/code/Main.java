/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 1   */
/******************************/

import Sort.*;
import java.util.*;
import java.io.*;

public class Main {
    public static MergeSort mergeSort; // MergeSort object
    public static InsertionSort insertionSort; // InsertionSort Object
    public static QuickSort quickSort; // QuickSort Object

    /*********************************************/
    /* Method: main                              */
    /* Purpose: Defining method to run function  */
    /* Parameters: String[] - arguments            */
    /*********************************************/
    public static void main(String[] args) {
        quickSort = new QuickSort(); // Creating QuickSort Object
        insertionSort = new InsertionSort(); // Creating InsertionSort Object
        mergeSort = new MergeSort(); // Creating MergeSort Object
        int[] array1 = buildArray(1000); // Building random array with 1000 integers
        int[] array2 = buildArray(5000); // Building random array with 5000 integers
        int[] array3 = buildArray(10000); // Building random array with 10000 integers
        int[] array4 = buildArray(20000); // Building random array with 20000 integers
        int[] array5 = buildArray(50000); // Building random array with 50000 integers
        int[] arraySorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Pre-sorted array
        int[] arrayUnsorted = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // Purposefully unsorted array
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Array 1");
        test(array1); // Test array1
        System.out.println("Array 2");
        test(array2); // Test array2
        System.out.println("Array 3");
        test(array3); // Test array3
        System.out.println("Array 4");
        test(array4); // Test array4
        System.out.println("Array 5");
        test(array5); // Test array5
        System.out.println("Sorted Array");
        test(arraySorted); // Test arraySorted
        System.out.println("Completely Unsorted Array");
        test(arrayUnsorted); // Test arrayUnsorted
    }

    /**********************************************/
    /* Method: buildArray                         */
    /* Purpose: Fills array with random integers  */
    /* Parameters: int - array size               */
    /**********************************************/
    public static int[] buildArray(int size) {
        Random random = new Random(); // Creates Random object
        int[] array = new int[size]; // Creates an array with desired size
        for (int i = 0; i < size; i++) { // For every position in the array
            array[i] = random.nextInt(); // Fills array position with random integer
        }
        return array; // Returns filled array
    }
    
    /***************************************************/
    /* Method: test                                    */
    /* Purpose: Runs efficiency test on desired array  */
    /* Parameters: int[] - Array being tested          */
    /***************************************************/
    public static void test(int[] array) {
        final Object[][] table = new String[4][]; //  Creats table object that will be printed
        long[] resultsInsertion = new long[3]; // Results of insertion test
        long[] resultsMerge = new long[3]; // Results of merge test
        long[] resultsQuick = new long[3]; // Results of quick test
        System.out.println("Number of Items: " + array.length);
        System.out.print("Errors: ");
        table[0] = new String[] {"Type of Sort", "Comparisons", "Swaps", "Execution Time"};
        resultsInsertion = insertionSort.start(array); // Runs insertion test
        table[1] = new String[] {"Insertion Sort", Long.toString(resultsInsertion[0]), Long.toString(resultsInsertion[1]), Long.toString(resultsInsertion[2])};
        resultsMerge = mergeSort.start(array); // Runs merge test
        table[2] = new String[] {"Merge Sort", Long.toString(resultsMerge[0]), Long.toString(resultsMerge[1]), Long.toString(resultsMerge[2])};
        resultsQuick = quickSort.start(array); // Runs quick test
        table[3] = new String[] {"Quick Sort", Long.toString(resultsQuick[0]), Long.toString(resultsQuick[1]), Long.toString(resultsQuick[2])};
        System.out.println("");
        print(table);
        System.out.println("------------------------------------------------------------------------------------");
    }

    /********************************************************/
    /* Method: print                                        */
    /* Purpose: Prints table                                */
    /* Parameters: Object[][] - Table that will be printed  */
    /********************************************************/
    public static void print(Object[][] table) {
        for (final Object[] row : table) { // For every row in the table
            System.out.format("%20s%20s%20s%20s\n", row); // Print the row in a desired format
        }

    }

}