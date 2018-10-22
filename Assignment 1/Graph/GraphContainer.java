/*
Nicholas Rahbany
CS 203
*/

package Graph;

import java.io.*;
import java.util.*;

public class GraphContainer {

    private static File inFile;// Input File
    private static Scanner read; // Scanner used to read input file
    private GraphList[] graphArray; // Array of GraphList objects
    private int arraySize; // Size of graphArray
    public int dataIndex; // Used as an index for how many nodes are counted per each input line from inFile
    private int data1; // Used as first data for GraphNode
    private int data2; // Used as second data for GraphNode

    public GraphContainer() {}

    public void run() {
        inFile = new File("inputFile.txt");
        try {
            read = new Scanner(inFile);
        } catch (FileNotFoundException invalidFile) {
            System.out.println("Input a valid file name");
        }
        String line; // Defining a line in the input file
        String[] data; // An array of the line when parsed
        String[] nodeData; // Array used to store new node's data
        while (read.hasNext()) { // If there is a line that hasn't been scanned
            this.arraySize = 0;
            line = read.nextLine(); // Scan the line
            data = line.split(" "); // Parse the line
            graphArray = new GraphList[0]; // Array that will store the Linked Lists
            dataIndex = 1; // Used as an index for how many nodes are counted
            while (data[dataIndex] != null) {
                nodeData = data[dataIndex].split(","); // Parse the data into two separate points
                data1 = Integer.parseInt(nodeData[0].substring(1, nodeData[0].length())); // Set the first point to only
                                                                                          // look for everything after
                                                                                          // the first parenthesis
                data2 = Integer.parseInt(nodeData[1].substring(0, nodeData[1].length() - 1)); // Set the second point to
                                                                                              // be everything until the
                                                                                              // last parenthesis
                GraphNode node = new GraphNode(data1, data2); // New node that will be added
                addNodeRec(node); // Adds node to linked list
                dataIndex++;
            }
        }

        // Print result
    }

    private GraphList[] addLinkedList(GraphList[] inputArray) {
        GraphList[] newArray = new GraphList[arraySize + 1];
        for (int i = 0; i < arraySize; i++) {
            newArray[i] = inputArray[i];
        }
        newArray[arraySize] = new GraphList();
        return newArray;
    }

    private boolean associateAndAdd(GraphNode inputNode) {
        boolean isAdded = false;
        for (int i = 0; i < arraySize; i++) {
            if (isAdded == false) {
                if (graphArray[i].associate(inputNode)) {
                    graphArray[i].add(inputNode);
                    isAdded = true;
                }
            }
        }
        return isAdded;
    }

    public void addNodeRec(GraphNode newNode) { // Adds nodes recursively
        while (!associateAndAdd(newNode)) {
            graphArray = addLinkedList(graphArray); // Adds linked list into array
            arraySize += 1; // Used to see how many linked lists are made
        }
    }

}