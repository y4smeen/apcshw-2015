import java.lang.IndexOutOfBoundsException;

public class Queue {

    private Node start;
    private Node end;

    public Queue() {
	start = null;
	end = null;;
    }

    public void enqueue(Node n) {
	if (start == null) {
	    start = n;
	    end = start;
	} else {
	    Node temp = n;
	    end.setNext(temp);
	    end = temp;
	}
    }

    public Node dequeue() {
	Node temp = start;
	start = start.getNext();
	return temp;
    }

    public boolean empty() {
	return start == null;
    }

    public Node head() {
	return start;
    }
}
