//Dillon is great help (y)

import java.util.*;
import java.io.*;

public class Maze {

    private char[][] board;
    private int maxX, maxY;

    private char path= '#';
    private char wall= ' ';
    private char me = 'Z';
    private char exit = '$';
    private char visit = '.';
    private boolean solved = false;

    //the array is used to locate the neighbors around a certain node in +- x +-y
    private int[][] neighbors = { {1,0} , {0,1} , {-1,0} , {0,-1} };

    //this queue would be used to store the searhOrder
    private Queue searchOrder;

    //the last node of the solved search
    private Node finale;

    public void delay(int n) {
	try {
	    Thread.sleep(n);
	} catch (Exception E) {

	}
    }

    public Maze() {
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

	//if it is solved, nothing happens
	if (solved) {
	    return;
	}

	//this checks if you have found the end
	if (board[n.getX()][n.getY()] == exit) {
	    solved = true;
	    finale = n;
	}

	System.out.println(this);

	//System.out.println(n.getX() + ", " + n.getY() + " - " + solved + " - " + board[n.getX()][n.getY()]);

	board[n.getX()][n.getY()] = visit;

	//delay(50);

	for (int i = 0 ; i < neighbors.length ; i++ ) {
	    char location = board[n.getX() + neighbors[i][0]][n.getY() + neighbors[i][1]];
	    // if the new neighbors are either the path or exit, it gets added into Queue
	    if (location == path || location == exit) {
		Node temp = new Node(n.getX() + neighbors[i][0], n.getY() + neighbors[i][1]);
		temp.setPrevious(n);
		searchOrder.enqueue(temp);
	    }
	}

	// this searches the next item in the queue
	BFS(searchOrder.dequeue());
    }

    public String BFS() {
	searchOrder = new Queue();

	//the start point
	Node temp = new Node(1,1);
	// this begins the breadth first search
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
	Maze z = new Maze();

	//System.out.println(z);

	String s = z.BFS();
	System.out.println(s);
    }
}
