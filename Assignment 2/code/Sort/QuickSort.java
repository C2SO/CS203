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
    public boolean overflow; // Used to check if there was an overflow error

    /*************************************************/
    /* Method: QuickSort                             */
    /* Purpose: Empty constuctor of QuickSort object */
    /*************************************************/
    public QuickSort() {}

    /*************************************************/
    /* Method: sort                                  */
    /* Purpose: Sorts the array                      */
    /* Parameters: int[] - Array that will be sorted */
    /*             int low - Low index of array      */
    /*             int high - High index of array    */
    /*************************************************/
    public void sort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
                comparisons++;
				i++;
			}
            comparisons++;
 
			while (arr[j] > pivot) {
                comparisons++;
				j--;
            }
            comparisons++;
            
            comparisons++;
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
                arr[j] = temp;
                swaps++;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			sort(arr, low, j);
 
		if (high > i)
			sort(arr, i, high);
	}

    /***********************************************************/
    /* Method: start                                           */
    /* Purpose: Handles the test                               */
    /* Parameters: int[] - Array that will be sorted           */
    /* Returns: long[] - Array that contains the test results  */
    /***********************************************************/
    public long[] start(int[] arr) {
        overflow = false; // Sets overflow boolean to false
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
