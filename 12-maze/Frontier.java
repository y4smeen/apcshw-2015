import java.util.*;

public class Frontier {

  public LinkedList<Node> l = new LinkedList<Node>();

  public void add(Node n) {
    l.add(n);
  }

  public Node remove() {
    Node r = l.remove();
    return r;
  }

  public boolean isEmpty() {
    return l.isEmpty();
  }

}
