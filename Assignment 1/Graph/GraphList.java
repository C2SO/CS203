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
        this.head = new GraphNode();
        this.numNodes = 0;
    }

    public void setHead(GraphNode newNode) {
        this.head = newNode;
        numNodes++;
    }

    public boolean associateAndAdd(GraphNode newNode) {
        boolean isAdded = false;
        currNode = this.head;
        int currNodeIndex = 0;
        while (!isAdded && currNode != null) {
            if (currNode.associate(newNode)) {
                for(int i = currNodeIndex; i < numNodes; i++) {
                    currNode = currNode.next;
                }
                currNode.next = newNode;
                numNodes++;
                isAdded = true;
            }
            currNodeIndex++;
        }
        return isAdded;
    }
}