import java.io.*;
import java.util.*;

public class LList<E> implements Iterable{
		private Node<E> l;

		public LList() {
			l = new Node<E>();
		}

		public Iterator<E> iterator() {
			LLit i = new LLit(l.getNext());
			return i;
		}

		public Node getFirst() {
			return l.getNext();
		}

		public void add(int s){
				Node tmp = new Node(s);
				tmp.setNext(l);
				l = tmp;
		}

		public String toString(){
				String s = "";
				Node tmp;
				for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
						s = s + tmp + " --> ";
				}
				s = s + "null";
				return s;
		}
}
