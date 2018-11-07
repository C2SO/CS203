/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 2   */
/******************************/

package Sort;

public class InsertionSort {

    public long comparisons; // Comparisons between two integers in the array
    public long swaps; // Swaps between two items in the array

    /********************************************************/
    /* Method: InsertionSort                                */
    /* Purpose: Empty constructor for InsertionSort object  */
    /* Parameters:                                          */
    /********************************************************/
    public InsertionSort() {}

    /*********************************************/
    /* Method: sort                              */
    /* Purpose: Sorts array                      */
    /* Parameters: int[] - Array of integers     */
    /*********************************************/
    void sort(int arr[]) {
        int n = arr.length; // Used as array length
        for (int i = 1; i < n; ++i) { // For every integer in the array
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

    /*********************************************/
    /* Method: start                             */
    /* Purpose: Method that handles the test     */
    /* Parameters: int[] - Array of integers     */
    /* Returns: long[] - Results of the test     */
    /*********************************************/
    public long[] start(int[] arr) {
        comparisons = 0;
        swaps = 0;
        long startTime = System.nanoTime(); // Starts timing the system
        sort(arr); // Sorts the array
        long endTime = System.nanoTime(); //  Stops timing the system
        long elapsedTime = endTime - startTime; // Calculates the elapsed time of the sort
        long[] result = { comparisons, swaps, elapsedTime }; // Stores results in an array
        return result;
    }
}
