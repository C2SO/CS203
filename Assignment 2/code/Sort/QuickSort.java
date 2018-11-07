/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 1   */
/******************************/

package Sort;

public class QuickSort {

    public long comparisons; // Counts the comparisons between two values
    public long swaps; // Counts the switches between two values in the array

    /*************************************************/
    /* Method: QuickSort                             */
    /* Purpose: Empty constuctor of QuickSort object */
    /*************************************************/
    public QuickSort() {}

    /********************************************************************/
    /* Method: partition                                                */
    /* Purpose: This function takes last element as pivot, places       */
    /*     the pivot element at its correct position in sorted array,   */
    /*     and places all smaller (smaller than pivot) to left of       */
    /*     pivot and all greater elements to right of pivot             */
    /* Parameters: int[] - Array that will be partitioned               */
    /*             int low - Low index of array                         */
    /*             int high - High index of array                       */
    /********************************************************************/
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swaps++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        swaps++;

        return i + 1;
    }

    /*************************************************/
    /* Method: sort                                  */
    /* Purpose: Sorts the array                      */
    /* Parameters: int[] - Array that will be sorted */
    /*             int low - Low index of array      */
    /*             int high - High index of array    */
    /*************************************************/
    void sort(int arr[], int low, int high) {
        try {
            if (low < high) {
                /*
                 * pi is partitioning index, arr[pi] is now at right place
                 */
                int pi = partition(arr, low, high);

                // Recursively sort elements before
                // partition and after partition
                sort(arr, low, pi - 1);
                sort(arr, pi + 1, high);
            }
        } catch (StackOverflowError e) { // If there is a StackOverflowError
            this.overflow = true;
        }
    }

    /***********************************************************/
    /* Method: start                                           */
    /* Purpose: Handles the test                               */
    /* Parameters: int[] - Array that will be sorted           */
    /* Returns: long[] - Array that contains the test results  */
    /***********************************************************/
    public long[] start(int[] arr) {

        boolean overflow = false; // Sets overflow boolean to false
        comparisons = 0;
        swaps = 0;
        int n = arr.length; // Set as array length

        long startTime = System.nanoTime(); // Starts timing the sort
        sort(arr, 0, n - 1); // Sort the array
        long endTime = System.nanoTime(); // Stops timing the sort
        long elapsedTime = endTime - startTime; // Calculates the total elapsed time
        long[] results = { comparisons, swaps, elapsedTime }; // Stors results in array
        if (overflow) { // If there was an overflow error, then print this error
            System.out.print("Stack Overflow Exception in Quick Sort");
        }
        return results; // Returns results
    }
}
