/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphList {

    private GraphNode head;
    public GraphNode currNode;

    public GraphList() {
        this.head = null;
    }

    public boolean associate(GraphNode newNode) {
        boolean associated = false;
        currNode = this.head;
        while (!associated && currNode != null) {
            if (currNode.associate(newNode)) {
                associated = true;
            }
            currNode = currNode.next;
        }
        if (this.head == null) {
            associated = true;
        }
        return associated;
    }

    public void add(GraphNode newNode) {
        currNode = this.head;
        if (currNode == null) {
            this.head = newNode;
            return;
        }
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public GraphNode getHead() {
        return this.head;
    }

}