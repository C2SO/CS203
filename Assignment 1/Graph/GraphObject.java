/*
Nicholas Rahbany
CS 203
*/

package Graph;

public class GraphObject {

    public int point1;
    public int point2;

    public GraphObject(int input1, int input2) {
        setPoint1(input1);
        setPoint2(input2);    
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