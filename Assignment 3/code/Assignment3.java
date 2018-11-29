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
        print(matrix);

        // Solve the matrix
        solve(matrix); 
    }

    /**************************************************/
    /* Method: solve                                  */
    /* Purpose: Looks for optimal solution in matrix  */
    /* Parameters: int[][] - matrix                   */
    /**************************************************/
    public static void solve(int[][] matrix) {
        int n = matrix[0].length;
        Integer[][] solutionArr = new Integer[n][n]; // Used to visualize the optimal solution
        
        // Fill in top row of matrix (will be same as original matrix)
        for (int i = 0; i < n; i++) {
            solutionArr[0][i] = matrix[0][i];
        }

        for (int row = 1; row < n; row++) {
            // Left to right
            for (int col = row; col < n; col++) {
                int minValue = -1;

                for (int newCol = row; newCol < col; newCol++) { // For each newCol where it is less than the current col
                    if (solutionArr[row][newCol] + matrix[row][col] < minValue || minValue == -1) { // If [row][newCol] + [row][col] < minval or minval = -1
                        minValue = solutionArr[row][newCol] + matrix[row][col]; // Set new minimum to [row][newCol] + [row][col]
                    }
                }
                // find the minimum value of all cells above in the same column of the current
                // cell
                // if any of these values are less than the current minimum obtained from
                // looking to the left,
                // update the minimum to the value above as it is more optimal.
                for (int newRow = 0; newRow < row; newRow++) {
                    if (matrix[newRow][col] != -1) {
                        if (solutionArr[newRow][col] < minValue || minValue == -1) {
                            minValue = solutionArr[newRow][col];
                        }
                    }
                }
                // Finally, update the current cell to the most optimal value obtained from the
                // above loops.
                solutionArr[row][col] = minValue;
            }
        }

        System.out.println(
                " Minimum path: " + path(solutionArr).toString() + "\n Minimum cost: " + solutionArr[n - 1][n - 1]);
    }

    /*******************************************/
    /* Method: path                            */
    /* Purpose: Finds optimal path for matrix  */
    /* Parameters: int[][] - matrix            */
    /* Returns: Set containing optimal path    */
    /*******************************************/
    public static Set<Integer> path(Integer[][] solutionArr) {

        // start in bottom right cell of solution array
        int n = solutionArr[0].length;
        Set<Integer> optimalSet = new TreeSet<>(); /* O(log(n)) */

        // add first and last col # to solution set
        optimalSet.add(1);
        optimalSet.add(n); // add first and last column to winning set
        int row = n - 1, col = n - 1; // very last cell

        // while we're still recovering the path
        while (row > 0) {

            int current = solutionArr[row][col];
            int above = solutionArr[row - 1][col];

            // if cell above is equal to current cell
            if (current == above) {
                row--; // go upmin
            } else { // optimal path comes from the left, add previous column to solution path
                int minIndex = Integer.MAX_VALUE;
                int i;
                for (i = row; i < col; i++) {
                    if (solutionArr[row][i] < Integer.MAX_VALUE) {
                        minIndex = i;
                    }
                }
                optimalSet.add(minIndex + 1);
                col = minIndex; // go back one column and restart the loop
            }
        }
        return optimalSet;
    }

    /***************************************/
    /* Method: print                       */
    /* Purpose: Prints the inputed matrix  */
    /* Parameters: int[][] - matrix        */
    /***************************************/
    public static void print(int[][] matrix) {
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
    }

}