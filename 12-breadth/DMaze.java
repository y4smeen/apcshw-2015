import java.util.*;
import java.io.*;

//same as the Maze except Queue is replaced with MyStack
public class DMaze {
    private char[][] board;
    private int maxX, maxY;

    private char path= '#';
    private char wall= ' ';
    private char me = 'Z';
    private char exit = '$';
    private char visit = '.';
    private boolean solved = false;
    private int[][] neighbors = { {1,0} , {0,1} , {-1,0} , {0,-1} };

    private MyStack searchOrder;
    private Node finale;

    public void delay(int n) {
	try {
	    Thread.sleep(n);
	} catch (Exception E) {

	}
    }

    public DMaze() {
	maxX = 40;
	maxY = 20;
	board = new char[maxX][maxY];

	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j = 0;
	    while (sc.hasNext()) {
		String line = sc.nextLine();
		for (int i = 0; i < maxX; i++) {
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	} catch (Exception e) {
	    System.out.println("FAIL");
	}
    }

    public String toString() {
	String s = "[2J\n";
	for (int i = 0; i < board[0].length; i++) {
	    for (int j = 0; j < board.length; j++) {
		s += board[j][i];
	    }
	    s += "\n";
	}
	return s;
    }

    public void BFS(Node n) {

	if (board[n.getX()][n.getY()] == exit) {
	    solved = true;
	    finale = n;
	}

	if (solved) {
	    return;
	}

	System.out.println(this);

	//System.out.println(n.getX() + ", " + n.getY() + " - " + solved + " - " + board[n.getX()][n.getY()]);

	board[n.getX()][n.getY()] = visit;

	//delay(50);

	for (int i = 0 ; i < neighbors.length ; i++ ) {
	    char location = board[n.getX() + neighbors[i][0]][n.getY() + neighbors[i][1]];
	    if (location == path || location == exit) {
		Node temp = new Node(n.getX() + neighbors[i][0], n.getY() + neighbors[i][1]);
		temp.setPrevious(n);
		searchOrder.push(temp);
	    }
	}
	BFS(searchOrder.pop());
    }

    public String BFS() {
	searchOrder = new MyStack();

	System.out.println(board[1][1]);
	Node temp = new Node(1,1);
	BFS(temp);

	String path = "";
	temp = finale;
	while (temp != null) {
	    path = "(" + temp.getX() + ", " + temp.getY() + ") --> " + path;
	    temp = temp.getPrevious();
	}
	return path + "EXIT";
    }

    public static void main(String[] args) {
	DMaze z = new DMaze();

	//System.out.println(z);

	String s = z.BFS();
	System.out.println(s);
    }
}
