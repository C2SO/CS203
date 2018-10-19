/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphNode {

    private GraphObject data1;
    public GraphNode next;

    public GraphNode(int data1, int data2) {
        GraphObject nodeObject = new GraphObject();
        nodeObject.setPoint1(data1);
        nodeObject.setPoint2(data2);
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

}