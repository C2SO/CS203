/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphNode {

    public int point1;
    public int point2;
    public GraphObject data1;
    public GraphNode next;

    public GraphNode() {
        setPoint1(-1);
        setPoint2(-1);   
        this.next = null;
    }

    public GraphNode(int data1, int data2) {
        this.next = null;
        setPoint1(data1);
        setPoint2(data2);    
    }

    public boolean associate(GraphNode node) {
        boolean associated = false;
        if (node.data1.getPoint1() == this.data1.getPoint1()) {
            associated = true;
        } else if (node.data1.getPoint1() == this.data1.getPoint2()) {
            associated = true;
        } else if (node.data1.getPoint2() == this.data1.getPoint1()) {
            associated = true;
        } else if (node.data1.getPoint1() == this.data1.getPoint1()) {
            associated = true;
        }
        return associated;
    }

    public int getPoint1() {
        return this.point1;
    }

    public int getPoint2() {
        return this.point2;
    }

    public void setPoint1(int input) {
        this.point1 = input;
    }

    public void setPoint2(int input) {
        this.point2 = input;
    }

}