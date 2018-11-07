// Java program for implementation of QuickSort 
package Sort;

public class QuickSort {

    boolean overflow = false;

    public long comparisons;
    public long swaps;

    public QuickSort() {
        comparisons = 0;
        swaps = 0;
    }

    /*
     * This function takes last element as pivot, places the pivot element at its
     * correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     */
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

    /*
     * The main function that implements QuickSort() arr[] --> Array to be sorted,
     * low --> Starting index, high --> Ending index
     */
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
        } catch (StackOverflowError e) {
            this.overflow = true;
        }
    }

    // Driver program
    public long[] start(int[] arr) {
        int n = arr.length;

        long startTime = System.nanoTime();
        sort(arr, 0, n - 1);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        long[] results = { comparisons, swaps, elapsedTime };
        if (overflow) {
            System.out.println("Stack Overflow Exception in Quick Sort");
        }
        return results;
    }
}
