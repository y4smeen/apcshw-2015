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
			// in order traversal
			if (t == null) return "";
			else {
				return traverse(t.getLeft()) +
				t.getData() + ", " +
				traverse(t.getRight());
			}
			/* preorder traversal
			else {
			return t.getData() + ", " +
			traverse(t.getLeft()) +
			traverse(t,getRight());
			}
			*/
		}
		/* remove
				1. use the search part of insert to get a pointer
				t to the node we want to move and t2 to its parent
				(insert searches until null, we stop when
				t.getData() == thing to delete)
				2. first 2 cases can be combined
					a. t is a leaf
					point t2's left or right to null (as appropriate)
					b. t has 1 child
					point t2's left or right to t's non null child
					c. t has 2 children
						i. find largest on left subtree (or smallest
						in right)
						L = t.getLeft();
						while (L.getRight() != null)
							L = L.getRight();
						ii. copy the data from L into t
						iii. remove (t.getLeft(), L.getData())
		*/
		public void remove(Node n, int i) {
			search(n, i);
			
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
