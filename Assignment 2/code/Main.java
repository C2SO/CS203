
// Nicholas Rahbany

import Sort.*;
import java.util.*;
import java.io.*;

public class Main {
    File outputFile;
    public static MergeSort mergeSort;
    public static InsertionSort insertionSort;
    public static QuickSort quickSort;

    public static void main(String[] args) {
        quickSort = new QuickSort();
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
        int[] array1 = buildArray(1000);
        int[] array2 = buildArray(5000);
        int[] array3 = buildArray(10000);
        int[] array4 = buildArray(20000);
        int[] array5 = buildArray(50000);
        int[] arraySorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrayUnsorted = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Array 1");
        test(array1);
        System.out.println("Array 2");
        test(array2);
        System.out.println("Array 3");
        test(array3);
        System.out.println("Array 4");
        test(array4);
        System.out.println("Array 5");
        test(array5);
        System.out.println("Sorted Array");
        test(arraySorted);
        System.out.println("Completely Unsorted Array");
        test(arrayUnsorted);
    }

    public static int[] buildArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void test(int[] array) {
        final Object[][] table = new String[4][];
        long[] resultsInsertion = new long[3];
        long[] resultsMerge = new long[3];
        long[] resultsQuick = new long[3];
        System.out.println("Number of Items: " + array.length);
        System.out.print("Errors: ");
        table[0] = new String[] {"Type of Sort", "Comparisons", "Swaps", "Execution Time"};
        resultsInsertion = insertionSort.start(array);
        table[1] = new String[] {"Insertion Sort", Long.toString(resultsInsertion[0]), Long.toString(resultsInsertion[1]), Long.toString(resultsInsertion[2])};
        resultsMerge = mergeSort.start(array);
        table[2] = new String[] {"Merge Sort", Long.toString(resultsMerge[0]), Long.toString(resultsMerge[1]), Long.toString(resultsMerge[2])};
        resultsQuick = quickSort.start(array);
        table[3] = new String[] {"Quick Sort", Long.toString(resultsQuick[0]), Long.toString(resultsQuick[1]), Long.toString(resultsQuick[2])};
        System.out.println("");
        print(table);
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void print(Object[][] table) {
        for (final Object[] row : table) {
            System.out.format("%20s%20s%20s%20s\n", row);
        }

    }

}