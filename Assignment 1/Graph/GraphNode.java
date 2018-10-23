/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphNode {

    public int point1; // First point of the node
    public int point2; // Second point of the node
    public GraphNode next; // Next node

    // Constructor for GraphNode
    public GraphNode(int data1, int data2) {
        this.next = null;
        setPoint1(data1);
        setPoint2(data2);
    }

    // Determines if a node is associated with this node
    public boolean associate(GraphNode node) {
        boolean associated = false;
        if (node.getPoint1() == this.getPoint1()) { // If the first point from each node are equal
            associated = true;
        } else if (node.getPoint1() == this.getPoint2()) { // If the first point of the new node is equal to the second
                                                           // point of the current node
            associated = true;
        } else if (node.getPoint2() == this.getPoint1()) { // If the second point of the new node is equal to the first
                                                           // point of the current node
            associated = true;
        } else if (node.getPoint2() == this.getPoint2()) { // If the second point from each node are equal
            associated = true;
        }
        return associated;
    }

    // Returns point1 of the node
    public int getPoint1() {
        return this.point1;
    }

    // Returns point2 of the node
    public int getPoint2() {
        return this.point2;
    }

    // Sets point1 of the node
    public void setPoint1(int input) {
        this.point1 = input;
    }

    // Sets point2 of the node
    public void setPoint2(int input) {
        this.point2 = input;
    }

}