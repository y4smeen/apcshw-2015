import java.util.*;

public class Frontier {
		public LinkedList<Node> l = new LinkedList<Node>();

		public void add(Node n){
				l.add(n);
		}

		public Node remove() {
				return l.remove(0);
		}

		public boolean isEmpty(){
				return l.isEmpty();
		}
}
