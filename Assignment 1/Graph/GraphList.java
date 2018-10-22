/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphList {

    private GraphNode head;
    private int numNodes;
    public GraphNode currNode;

    public GraphList() {
        this.head = null;
        this.numNodes = 0;
    }

    public boolean associate(GraphNode newNode) {
        boolean associated = false;
        currNode = this.head;
        int currNodeIndex = 0;
        while (!associated && currNode != null) {
            if (currNode.associate(newNode)) {
                associated = true;
            }
            currNodeIndex++;
        }
        if (numNodes == 0) {
            associated = true;
        }
        return associated;
    }

    public void add(GraphNode newNode) {
        currNode = this.head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        numNodes++;
    }

}