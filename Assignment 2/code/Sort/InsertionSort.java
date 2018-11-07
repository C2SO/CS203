/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 1   */
/******************************/

package Sort;

public class InsertionSort {

    public long comparisons;
    public long swaps;

    public InsertionSort() {
    }

    /* Function to sort array using insertion sort */
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are greater than key, to one position
             * ahead of their current position
             */
            while (j >= 0 && arr[j] > key) {
                this.comparisons++;
                if (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                    this.swaps++;
                }
            }
            this.comparisons++;
            arr[j + 1] = key;
        }
    }

    // Driver method
    public long[] start(int[] arr) {
        comparisons = 0;
        swaps = 0;
        long startTime = System.nanoTime();

        sort(arr);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        long[] result = { comparisons, swaps, elapsedTime };
        return result;
    }
}
