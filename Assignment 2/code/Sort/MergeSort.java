/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 2   */
/******************************/

package Sort;

public class MergeSort {
    public long comparisons; // Number of comparisons made
    public long swaps; // Number of swaps made

    /****************************************************/
    /* Method: MergeSort                                */
    /* Purpose: Empty constructor for MergeSort object  */
    /* Parameters: String[] - arguments                 */
    /****************************************************/
    public MergeSort() {}
    

    /**********************************************/
    /* Method: merge                              */
    /* Purpose: Merges two subarrays of arr[]     */
    /* Parameters: int arr[] - array of integers  */
    /*             int l - Left number            */
    /*             int m - middle number          */
    /*             int r - right number           */
    /**********************************************/
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) { // while there are numbers to compare within both indexes
            comparisons++;
            if (L[i] <= R[j]) { // If the integer in L[] is less than or equal to the integer in R[]
                arr[k] = L[i];
                swaps++;
                i++;
            } else {
                swaps++;
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) { // While there are numbers left to move
            arr[k] = L[i];
            swaps++;
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) { // While there are numbers left to move
            arr[k] = R[j];
            swaps++;
            j++;
            k++;
        }
    }

    /******************************************************/
    /* Method: sort                                       */
    /* Purpose: main functino that sorts the array        */
    /* Parameters: int[] arr - Array that will be sorted  */
    /*             int l - Left index of array            */
    /*             int r - Right index of array           */
    /******************************************************/
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /***********************************************************/
    /* Method: start                                           */
    /* Purpose: Handles the test                               */
    /* Parameters: int[] - Array that will be sorted           */
    /* Returns: long[] - Array that contains the test results  */
    /***********************************************************/
    public long[] start(int[] arr) {
        comparisons = 0;
        swaps = 0;
        long startTime = System.nanoTime(); // Start timing the test
        sort(arr, 0, arr.length - 1); // Sort the array
        long endTime = System.nanoTime(); // Stop timing the test
        long elapsedTime = endTime - startTime; // Total elapsed time
        long[] results = {comparisons, swaps, elapsedTime}; // Defines array that holds results
        return results;
    }
}
