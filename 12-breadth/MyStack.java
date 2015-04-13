public class MyStack {

    private LList stack;

    public MyStack() {
	stack = new LList();
    }

    public void push(Node n) {
	stack.add(n);
    }

    public Node pop() {
	return stack.remove();
    }

    public boolean empty() {
	return stack.empty();
    }

    public Node top() {
	return stack.get();
    }
}
