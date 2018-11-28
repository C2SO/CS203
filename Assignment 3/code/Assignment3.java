/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 3   */
/******************************/

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Assignment3 {

    public static File file; // File used as input
    public static Scanner scan; // Scanner used to read file
    public static int baseNum; // Used as the dimensions for the matrix
    public static int inputNum = 0; // Used as the number being added to the matrix

    /*********************************************/
    /* Method: main                              */
    /* Purpose: Defining method to run function  */
    /* Parameters: String[] - arguments          */
    /*********************************************/
    public static void main(String[] args) throws FileNotFoundException {
        file = new File("input.txt");
        scan = new Scanner(file); 
        baseNum = scan.nextInt(); 

        // Make matrix
        int[][] matrix = new int[baseNum][baseNum]; // Matrix used to store the values
        for (int row = 0; row < matrix.length; row++) { // For each row
            for (int col = row + 1; col < matrix[0].length; col++) { // For each column where it's row + 1
                inputNum = scan.nextInt(); // Scan the next number
                matrix[row][col] = inputNum; // Place the number here
            }
        }

        // Print matrix
        for (int row = 0; row < matrix.length; row++) { // For each row
            for (int col = 0; col < matrix[0].length; col++) { // For each column
                // Used to keep characters even
                if (matrix[row][col] < 10) 
                    System.out.print(" " + matrix[row][col] + " ");
                else
                    System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Solve the matrix
        solve(matrix); 
    }

    /**
     * Obtains and prints the lowest possible cost of canoe-ing down the river
     */
    public static void solve(int[][] matrix) {
        int n = matrix[0].length;
        Integer[][] solutionArr = new Integer[n][n];
        /*
         * Fill in top row of solution array Will always be the same as the top row of
         * the input
         */
        for (int i = 0; i < n; i++) {
            solutionArr[0][i] = matrix[0][i];
        }
        // Top to bottom
        for (int i = 1; i < n; i++) {
            // Left to right
            for (int j = i; j < n; j++) {
                int minValue = -1;

                // Find the minimum value of all values to the left of the current cell [i][j]
                // added onto the current cell. That is, the most optimal previous value plus
                // the price
                // of renting a canoe in this particular column.
                for (int k = i; k < j; k++) {
                    if (solutionArr[i][k] + matrix[i][j] < minValue || minValue == -1) {
                        minValue = solutionArr[i][k] + matrix[i][j];
                    }
                }
                // find the minimum value of all cells above in the same column of the current
                // cell
                // if any of these values are less than the current minimum obtained from
                // looking to the left,
                // update the minimum to the value above as it is more optimal.
                for (int k = 0; k < i; k++) {
                    if (matrix[k][j] != -1) {
                        if (solutionArr[k][j] < minValue || minValue == -1) {
                            minValue = solutionArr[k][j];
                        }
                    }
                }
                // Finally, update the current cell to the most optimal value obtained from the
                // above loops.
                solutionArr[i][j] = minValue;
            }
        }

        System.out.println(
                " Minimum path: " + recover(solutionArr).toString() + ", Minimum cost: " + solutionArr[n - 1][n - 1]);
    }

    /**
     * Recovers the optimal path from the solution array obtained from the dynamic
     * programming approach.
     *
     * @param solutionArr the solution array
     * @return a set of the winning indexes. (not zero based)
     */
    public static Set<Integer> recover(Integer[][] solutionArr) {
        // algorithm:
        // add first and last col # to solution set

        // start in bottom right cell of solution array

        // if cell above is equal to current cell
        // go up
        // else
        // go left, record new col in solution
        int n = solutionArr[0].length;
        Set<Integer> winSet = new TreeSet<>(); /* O(log(n)) */

        winSet.add(1);
        winSet.add(n); // add first and last column to winning set
        int row = n - 1, col = n - 1; // very last cell

        // while we're still recovering the path
        while (row > 0) {

            int current = solutionArr[row][col];
            int above = solutionArr[row - 1][col];
            // int left = solutionArr[row][col-1];

            if (current == above) {
                row--; // go up
            } else { // optimal path comes from the left, add previous column to solution path
                int min = Integer.MAX_VALUE;
                int minIndex = Integer.MAX_VALUE;
                int i;
                for (i = row; i < col; i++) {

                    if (solutionArr[row][i] < min) {
                        min = solutionArr[row][i];
                        minIndex = i;
                    }
                }
                winSet.add(minIndex + 1);
                col = minIndex; // go back one column and restart the loop
            }
        }
        // System.out.printf("Winning indexes = %s\n", winSet.toString());
        return winSet;
    }

}