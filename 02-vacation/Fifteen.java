import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class Fifteen extends JFrame {

    // VARIABLES
    private static final int SIDE = 4;
    private JPanel top, gameBoard;
    private JButton[][] grid = new JButton[SIDE][SIDE];
    private JFrame frame = new JFrame("Fifteen Puzzle");
    private boolean youLose = false, isEnded = true, isStarted = false;

    public Fifteen() {
	top = new JPanel();
	JButton shuffle = new JButton("Shuffle");
	//shuffle.setPreferredSize(new Dimension(400,100));
	top.setLayout(new GridLayout());
	frame.add(top, shuffle, BorderLayout.PAGE_START);
	grid(SIDE, SIDE);
    }

    private class TileMove implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    if (!youLose) {
		frame.repaint();
	    }
	}
    }

    public void grid(int rows, int cols) {
	frame.setLayout(new GridLayout(rows, cols));
	grid = new JButton[rows][cols];
	int tile = 1;

	for(int col = 0; col < cols; col++) {
	    for(int row = 0; row < rows; row++) {
		if(tile < 16) {
		    grid[row][col] = new JButton(Integer.toString(tile));
		    grid[row][col].setPreferredSize(new Dimension(100, 100));
		    grid[row][col].addActionListener(new TileMove());
		    frame.add(grid[row][col]);
		    tile++;
		} else {
		    grid[row][col] = new JButton();
		    frame.add(grid[row][col]);
		}
	    }
	}

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
	frame.setResizable(false);
    }

    /*
    public void shuffle() {
	for(int row = 0; row < ROWS; row++) {
	    for(int col = 0; col < COLS; col++) {
		switch(row, col, (int)(Math.random() * ROWS), (int)(Math.random() * COLS));
	    }
	}
    }
    
    public void switch(int r1, int c1, int r2, int c2) {
	int holdTile = 
    }
    */
    public static void main(String[] args) {
	Fifteen fifteen = new Fifteen();
    }
}