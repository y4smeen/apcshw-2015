public class Node {

    private int x, y;
    private Node next;
    private Node previous;

    public Node() {

    }

    public Node(int xcor, int ycor) {
	x = xcor;
	y = ycor;
    }

    public void setNext(Node n) {
	next = n;
    }

    public Node getNext() {
	return next;
    }

    public void setPrevious(Node n) {
	previous = n;
    }

    public Node getPrevious() {
	return previous;
    }

    public void setData(int xcor, int ycor) {
	x = xcor;
	y = ycor;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }
}
