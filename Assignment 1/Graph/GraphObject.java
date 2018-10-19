/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphObject {

    private int point1;
    private int point2;

    public GraphObject(int first, int second) {
        this.point1 = first;
        this.point2 = second;
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