/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphList {

    private GraphNode head; // List head node
    public GraphNode currNode; // Currently selected node

    // Constructor for GraphList
    public GraphList() {
        this.head = null;
    }

    // Determines if a node is associated with the specified linked list
    public boolean associate(GraphNode newNode) {
        boolean associated = false;
        currNode = this.head;
        while (!associated && currNode != null) { // While the node isn't associated and the current node is not null
            if (currNode.associate(newNode)) { // If the current node is associated
                associated = true; // Say this node is associated
            }
            currNode = currNode.next; // Goes to the next node in the list
        }
        if (this.head == null) { // If the list does not have a node
            associated = true; // Say this node is associated
        }
        return associated;
    }

    // Adds a node to the specified linked list
    public void add(GraphNode newNode) {
        currNode = this.head;
        if (currNode == null) { // If there is no head node
            this.head = newNode; // The new node is the head node
            return;
        }
        while (currNode.next != null) { // If the next node is not null
            currNode = currNode.next; // Go to the next node
        }
        currNode.next = newNode; // The next node is the new node
    }

    // Returns the head node of this list
    public GraphNode getHead() {
        return this.head;
    }

}