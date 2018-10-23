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
    public int dataIndex; // Used as an index for how many nodes are counted per each input line from
                          // inFile
    private int data1; // Used as first data for GraphNode
    private int data2; // Used as second data for GraphNode
    public int[] listAssociated; // Array of associated list IDs
    public int listAssociatedSize; // Int size of associated lists

    public GraphContainer() {
    }

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
            listAssociated = new int[0];
            listAssociatedSize = 0;
            for (int i = 1; i < data.length; i++) {
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

    // Adds a new linked list to the graphArray object
    private GraphList[] addLinkedList(GraphList[] inputArray) {
        GraphList[] newArray = new GraphList[arraySize + 1]; // Initializes new linked list
        for (int i = 0; i < arraySize; i++) { // Resizes graphArray
            newArray[i] = inputArray[i];
        }
        newArray[arraySize] = new GraphList(); // Adds newArray to graphList
        return newArray;
    }

    // Associated the new node to a linked list
    private boolean associate(GraphNode inputNode) {
        boolean isAdded = false;
        for (int i = 0; i < arraySize; i++) { // For each linked list
            if (graphArray[i].associate(inputNode)) { // Check if it is associated
                addAssociatedArray(i); // Add the list ID to the associated array
                isAdded = true;
            }
        }
        return isAdded;
    }

    // Adds a node to the linked lists
    public void addNodeRec(GraphNode newNode) { // Adds nodes recursively
        while (!associate(newNode)) { // While the node hasn't been associated
            graphArray = addLinkedList(graphArray); // Adds linked list into array
            arraySize += 1; // Used to see how many linked lists are made
        }
        add(listAssociated, newNode); // Add node to the associated list
    }

    // Adds the ID of the linked list into the array which stores the data
    public void addAssociatedArray(int associated) {
        int[] newArray = new int[listAssociatedSize + 1]; // Creates a new array that is one size larger than the
                                                          // current listAssociated array
        for (int i = 0; i < listAssociatedSize; i++) { // For each ID in the array
            newArray[i] = listAssociated[i]; // Add it to newArray
        }
        newArray[listAssociatedSize] = associated; // Add the newly associated list ID to newArray
        listAssociated = newArray; // Set listAssociated as newArray
        listAssociatedSize++; // Increase the size of the array
    }

    // Adds inputNode to the associated list
    public void add(int[] associated, GraphNode inputNode) {
        while (associated.length > 1) { // While the number of associated lists is > 1
            combineList(associated[0], associated[1]); // Combine two lists together
        }
        int i = associated[0]; // Sets the ID for the Linked List which the node will be added
        graphArray[i].add(inputNode); // Adds the node to the linked list
    }

    // Combines two linked lists together
    public void combineList(int firstList, int secondList) {
        GraphList newList = new GraphList();
        GraphList first = graphArray[firstList];
        GraphList second = graphArray[secondList];
        GraphNode firstHead = first.getHead();
        GraphNode secondHead = first.getHead();
        GraphNode currNode = firstHead;
        for (int i = 0; i < first.getNumNodes(); i++) {
            newList.add(currNode);
            currNode = currNode.next;
        }
        currNode = secondHead;
        for (int i = 0; i < second.getNumNodes(); i++) {
            newList.add(currNode);
            currNode = currNode.next;
        }
        GraphList[] associatedList = new GraphList[arraySize - 1];
        int graphArrayIndex = 0;
        for (int i = 0; i < arraySize; i++) {
            if (i != secondList) {
                associatedList[i] = graphArray[graphArrayIndex];
            }
            graphArrayIndex++;
        }
        graphArray = associatedList;
    }

}