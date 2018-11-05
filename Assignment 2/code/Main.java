// Nicholas Rahbany

import Sort.*;
import java.util.*;
import java.io.*;

public class Main {
    File outputFile;

    public static void main(String[] args) {
        int[] array1 = buildArray(1000);
        int[] array2 = buildArray(5000);
        int[] array3 = buildArray(10000);
        int[] array4 = buildArray(20000);
        int[] array5 = buildArray(50000);
        test(array1);
    }

    private static int[] buildArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static void test(int[] array) {
        int[] resultsInsertion = new int[3]; //[comps, swaps, time]
        int[] resultsMerge = new int[3];
        int[] resultsQuick = new int[3];
        retultsInsertion = insertionSort(array);
        resultsMerge = mergeSort(array);
        resultsQuick = quickSort(array);
    }

}