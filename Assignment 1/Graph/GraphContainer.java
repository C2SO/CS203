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
    private static GraphList[] graphArray;
    private int arraySize;
    public int dataIndex;
    public int sizeIndex;
    private String data1;
    private String data2;

    public GraphContainer() {
        arraySize = 0;
    }

    publc run() {
        inFile = new File("inputFile.txt");
        read = new Scanner(inFile);
        String line; // Defining a line in the input file
        String[] data; // An array of the line when parsed
        String[] nodeData; // Array used to store new node's data
        while (read.hasNext()) { // If there is a line that hasn't been scanned
            line = read.nextLine(); // Scan the line
            data = line.split(" "); // Parse the line
            graphArray = new Array[0]; // Array that will store the Linked Lists
            dataIndex = 1; // Used as an index for how many nodes are counted
            while (data[dataIndex] != null) {
                nodeData = data[dataIndex].split(","); // Parse the data into two separate points
                data1 = nodeData[0].substring(1, nodeData[0].length()); // Set the first point to only look for
                                                                        // everything after the first
                                                                        // parenthesis
                data2 = nodeData[1].substring(0, nodeData[1].length()); // Set the second point to be everything
                                                                        // until the last parenthesis
                GraphNode node = new GraphNode(data1.toInt(), data2.toInt()); // New node that will be added
                addNodeRec(node);
            }
        }

        // Print result
    }

    private Array[] addLinkedList(Array[] inputArray) {
        Array[] newArray = new Array[arraySize + 1];
        for (int i = 0; i < arraySize; i++) {
            newArray[i] = inputArray[i];
        }
        return newArray;
    }

    private boolean associateAndAdd(GraphNode inputNode) {
        boolean isAdded = false;
        int listNumber = 0;
        while(isAdded == false && GraphList[listNumber] != null) {
            isAdded = GraphList[listNumber].associateAndAdd(inputNode);
            listNumber++;
        }
        return isAdded;
    }

    public void addNodeRec(GraphNode newNode) {
        if (!associateAndAdd(newNode)) {
            GraphList list = new GraphList(); // Creates a new LinkedList
            addLinkedList(graphArray); // Adds linked list into array
            arraySize += 1; // Used to see how many linked lists are made
            addNodeRec(newNode);
        }
    }

}