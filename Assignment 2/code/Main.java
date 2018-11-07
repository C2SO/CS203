
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
        test(array1);
        test(array2);
        test(array3);
        test(array4);
        test(array5);
        System.out.println("------------------------------------------------------------------------------------");
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
        System.out.println("------------------------------------------------------------------------------------");
        final Object[][] table = new String[4][];
        long[] resultsInsertion = new long[3];
        long[] resultsMerge = new long[3];
        long[] resultsQuick = new long[3];
        table[0] = new String[] {"Type of Sort", "Comparisons", "Swaps", "Execution Time"};
        resultsInsertion = insertionSort.start(array);
        table[1] = new String[] {"Insertion Sort", Long.toString(resultsInsertion[0]), Long.toString(resultsInsertion[1]), Long.toString(resultsInsertion[2])};
        resultsMerge = mergeSort.start(array);
        table[2] = new String[] {"Merge Sort", Long.toString(resultsMerge[0]), Long.toString(resultsMerge[1]), Long.toString(resultsMerge[2])};
        resultsQuick = quickSort.start(array);
        table[3] = new String[] {"Quick Sort", Long.toString(resultsQuick[0]), Long.toString(resultsQuick[1]), Long.toString(resultsQuick[2])};
        print(table);
    }

    public static void print(Object[][] table) {
        for (final Object[] row : table) {
            System.out.format("%20s%20s%20s%20s\n", row);
        }

    }

}