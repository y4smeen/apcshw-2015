import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
		private Node<E> t;
		private Node<E> previous;

		public LLit(Node<E> n) {
				t = n;
				previous = null;
		}

		public boolean hasNext() {
				return t != null;
		}

		public E next() {
				E retval = t.getData();
				previous = t;
				t = t.getNext();
				return retval;
		}

		public void remove() {
			previous.setNext(t.getData());
		}
}
