/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 1   */
/******************************/

package Graph;

public class GraphNode {

    public int point1; // First point of the node
    public int point2; // Second point of the node
    public GraphNode next; // Next node

    /***********************************************/
    /* Method: GraphNode                           */
    /* Purpose: Initializes the GraphNode object   */
    /* Parameters:                                 */
    /*      int data1: First point in the node     */
    /*      int data2: Second point in the node    */
    /***********************************************/
    public GraphNode(int data1, int data2) {
        this.next = null;
        setPoint1(data1);
        setPoint2(data2);
    }

    /*******************************************************************/
    /* Method: associate                                               */
    /* Purpose: Determines if a node is associated with another node   */
    /* Parameters:                                                     */
    /*      GraphNode node: The node you are comparing                 */
    /* Returns: Boolean: Is the node associated?                       */
    /*******************************************************************/
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

    /*******************************************/
    /* Method: getPoint1                       */
    /* Purpose: Retrieves the value of point1  */
    /* Parameters:                             */
    /* Returns: int: Value of point1           */
    /*******************************************/
    public int getPoint1() {
        return this.point1;
    }

    /*******************************************/
    /* Method: getPoint2                       */
    /* Purpose: Retrieves the value of point2  */
    /* Parameters:                             */
    /* Returns: int: Value of point2           */
    /*******************************************/
    public int getPoint2() {
        return this.point2;
    }

    /*******************************************/
    /* Method: setPoint1                       */
    /* Purpose: Sets the value of point1       */
    /* Parameters:                             */
    /*      int: value to be set to point1     */
    /*******************************************/
    public void setPoint1(int input) {
        this.point1 = input;
    }


    /*******************************************/
    /* Method: setPoint2                       */
    /* Purpose: Sets the value of point2       */
    /* Parameters:                             */
    /*      int: value to be set to point2     */
    /*******************************************/
    public void setPoint2(int input) {
        this.point2 = input;
    }

}