public class DummyList {
  private Node l = null;

  public void add(String s) {
    Node temp = new Node(s);
    temp.setNext(1);
    l = temp;
  }

  public String remove(int n) {
    if (n < 0||n > this.len) {
      Throw(exception);
    }
    Node T = L;
    for (int i = 0; i < n; i++) {
      T = T.getNext();
    }
    String s = T.getNext().getData();
    T.setNext(T.getNext().getNext());
    return s;
  }

  // System.currentTimeMillis();


}
