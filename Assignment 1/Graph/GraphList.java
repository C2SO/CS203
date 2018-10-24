/******************************/
/* Nicholas Rahbany           */
/* Login ID: rahb3032         */
/* CS 203, Fall 2018          */
/* Programming Assignment 1   */
/******************************/

package Graph;

public class GraphList {

    private GraphNode head; // List head node
    public GraphNode currNode; // Currently selected node

    /***********************************************/
    /* Method: GraphList                           */
    /* Purpose: Initializes the GraphList object   */
    /* Parameters:                                 */
    /***********************************************/
    public GraphList() {
        this.head = null;
    }

    /**********************************************************************/
    /* Method: associate                                                  */
    /* Purpose: Determines if a node is associated with the linked list   */
    /* Parameters:                                                        */
    /*      GraphNode newNode: Node that is being compared                */
    /* Returns: boolean: Is this node associated with the list?           */
    /**********************************************************************/
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

    /*****************************************************/
    /* Method: add                                       */
    /* Purpose: Adds a ndoe to the linked list           */
    /* Parameters:                                       */
    /*      GraphNode newNode: Node that is being added  */
    /*****************************************************/
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

    /*****************************************************/
    /* Method: getHead                                   */
    /* Purpose: Retrieves the head node of the list      */
    /* Parameters:                                       */
    /* Returns: GraphNode: The current list's head node  */
    /*****************************************************/
    public GraphNode getHead() {
        return this.head;
    }

}