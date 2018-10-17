/*
Nicholas Rahbany
CS 203
*/

package Graph;

import java.io.*;
import java.util.*;

public class GraphContainer {

    private static File inFile;
    private static Scanner read;
    private static Array[] graphArray;
    private int arraySize;

    public GraphContainer() {
        
    }

    publc run() {
        inFile = new File("inputFile.txt");
        read = new Scanner(inFile);
        String line; // Defining a line in the input file
        String[] data; // An array of the line when parsed
        while (read.hasNext()) { // If there is a line that hasn't been scanned
            line = read.nextLine(); // Scan the line
            data = line.split(" "); // Parse the line
            graphArray = new Array[0];
            if (true == false) { // Check if node does not associate with current list

            } else {
                GraphList list = new GraphList();
                graphArray = newArray[1];
                list.setVertices(data[0].toInteger());
                list.setSides(data.size() - 1);
                graphArray[0] = list;
            }
        }

    }