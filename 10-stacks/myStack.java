public class myStack<E>{
    // You decide how the node(s) are declared

    // make whatever constructor(s) you need

    private Node<E> l;

    public myStack(E s) {
      l = s;
    }

    public void push(E data){
      // add something to the top
      Node tmp = new Node(data);
      tmp.setNext(l);
      l = tmp;
    }

    public E pop(){
        // remove and return the top item from the stack
        if (empty()) return -1;

        tmp = s.getData();
        l = l.getNext();
        return tmp;

    }

    public boolean empty(){
      return l == null;
    }

    public E top() {
        // return the top item from the stack
        return l.getData();
    }
}
