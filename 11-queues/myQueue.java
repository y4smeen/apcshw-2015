public class myQueue<E>{
    // You decide how the node(s) are declared
      private Node<E> top, bottom;

    // make whatever constructor(s) you need
    public myQueue(E s) {
        top = new Node<E>(s);
        bottom = new Node<E>(s);
        top.setNext(bottom);
    }

    public void enqueue(E data){
        // add something to the tail/last
        Node<E> tmp = new Node<E>(data);
        bottom.setNext(tmp);
        bottom = tmp;
    }

    public E dequeue(){
        // remove and return the head/front item from the stack

    }

    public boolean empty(){
      return top == null;
    }

    public E head() {
        // return the first item in the queue
        return top.getNext().getData();
    }
}
