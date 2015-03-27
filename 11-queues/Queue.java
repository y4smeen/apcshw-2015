public class Queue<E>{
    // You decide how the node(s) are declared
    private Node<E> back, front;
    // make whatever constructor(s) you need

    public void enqueue(E data){
        // add something to the tail/last
        Node<E> tmp = new Node<E>(data);
        if (empty()) {
          front = tmp;
          back = tmp;
        } else {
          back.setNext(tmp);
          back = tmp;
        }
    }

    public E dequeue(){
        // remove and return the head/front item from the stack
        if (empty()) {
          Throw new IllegalArgumentException("INVALID");
        }
        E retval = front.getData();
        front = front.getNext();
        if (front == null) back == null;
        return retval;
    }

    public boolean empty(){
      return back == null;
    }

    public E head() {
        // return the first item in the queue
    }
}
