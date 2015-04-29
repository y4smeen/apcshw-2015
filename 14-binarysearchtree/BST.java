import java.io.*;
import java.util.*;
public class BST{
		Node r;

		public Node search(Node t, int i){
				if (t==null || t.getData()==i)
						return t;
				else if (t.getData() < i)
						return search(t.getRight(),i);
				else
						return search(t.getLeft(),i);
		}

		public String search(int i){
				Node retval = search(r,i);
				if (retval==null)
						return "Not Found";
				else
						return ""+retval;
		}

		public void insert(int i){
				Node n = new Node(i);
				Node t2=null;
				Node t = r;
				if (r==null){
						r=n;
						return;
				}

				while (t!=null){
						t2 = t;
						if (t.getData()==i)
								return;
						else if (t.getData() < i)
								t=t.getRight();
						else if (t.getData() > i)
								t=t.getLeft();
						else
								return;
				}


				if (i>t2.getData())
						t2.setRight(n);
				else
						t2.setLeft(n);
		}

		public String traverse(Node t){
			if (t.getRight() != null) {
				traverse(t.getRight());
			}
			if (t.getLeft() != null) {
				traverse(t.getLeft());
			}
		}
		public String toString(){
				return traverse(r);
		}

		public static void main(String[] args){
				BST t = new BST();
				Random r = new Random();
				for (int i = 0; i < 20; i ++){
						int z = r.nextInt(100);
						//System.out.println(z);
						t.insert(z);
				}
				System.out.println(t);
				//				t.insert(30);
				System.out.println(t.search(30));
		}
}
