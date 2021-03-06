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
        // print(matrix);

        // Solve the matrix
        solve(matrix); 
    }

    /**************************************************/
    /* Method: solve                                  */
    /* Purpose: Looks for optimal solution in matrix  */
    /* Parameters: int[][] - matrix                   */
    /**************************************************/
    // I built this in reverse, just a warning
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
               
                // Find the minimum value for each row and column
                for (int newRow = 0; newRow < row; newRow++) {
                    if (matrix[newRow][col] != -1) {
                        if (solutionArr[newRow][col] < minValue || minValue == -1) {
                            minValue = solutionArr[newRow][col];
                        }
                    }
                }

                // Set [row][col] to the minimum value for that specified area
                solutionArr[row][col] = minValue;
            }
        }

        print(solutionArr);

        System.out.println(" Minimum path:");
        optimalSolution(solutionArr, solutionArr[n - 1][n - 1], matrix);
        System.out.print("\n Minimum cost: " + solutionArr[n - 1][n - 1]);
    }

    /*******************************************************************/
    /* Method: optimalSolution                                         */
    /* Purpose: Finds optimal path for matrix                          */
    /* Parameters: int[][] - matrix                                    */
    /*             Integer[][] - Array used to trace optimal solution  */
    /*             Integer - Minimum cost                              */
    /*******************************************************************/
    public static void optimalSolution(Integer[][] solutionArr, Integer solution, int[][] matrix) {

        // start in bottom right cell of solution array
        int n = solutionArr[0].length;
        Set<Integer> optimalSet = new TreeSet<>(); /* O(log(n)) */

        // add last col # to solution set
        optimalSet.add(n); // add first and last column to winning set
        int row = n - 1;
        int col = n - 1;

        // while we're still recovering the path
        while (row > 0) {

            int current = solutionArr[row][col];
            int above = solutionArr[row - 1][col];

            // if cell above is equal to current cell
            if (current == above) {
                row--; // go up
            } else { // optimal path comes from the left, add previous column to solution path
                int minIndex = Integer.MAX_VALUE;
                int i;
                for (i = row; i < col; i++) {
                    if (solutionArr[row][i] < Integer.MAX_VALUE) {
                        minIndex = i;
                    }
                }
                optimalSet.add(minIndex + 1);
                solution -= matrix[row][col];
                col = minIndex; // go back one column and restart the loop
            }
        }
        
        if (solution - solutionArr[0][1] == 0) {
            optimalSet.add(1);
        }

        // Print optimal path
        System.out.print(" 1");
        for (Integer s: optimalSet) {
            System.out.print(" -> " + s);
        }
    }

    /***************************************/
    /* Method: print                       */
    /* Purpose: Prints the inputed matrix  */
    /* Parameters: int[][] - matrix        */
    /***************************************/
    public static void print(Integer[][] matrix) {
        for (int row = 0; row < matrix.length; row++) { // For each row
            for (int col = 0; col < matrix[0].length; col++) { // For each column
                // Used to keep characters even
                if (matrix[row][col] == null)
                    System.out.print(" 0 ");
                else if (matrix[row][col] < 10) 
                    System.out.print(" " + matrix[row][col] + " ");
                else
                    System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}