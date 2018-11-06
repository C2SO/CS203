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
        long[] resultsInsertion = new long[3]; //[comps, swaps, time]
        long[] resultsMerge = new long[3];
        long[] resultsQuick = new long[3];
        resultsInsertion = insertionSort.start(array);
        resultsMerge = mergeSort.start(array);
        // resultsQuick = quickSort.start(array);
        // print(resultsInsertion, resultsMerge, resultsQuick);
    }

    public static void print(int[] insertion, int[] merge, int[] quick) {
        
    }

}