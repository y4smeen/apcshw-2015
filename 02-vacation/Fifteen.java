import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Fifteen {

    // VARIABLES
    private final int NUM_ROWS = 4;
    private final int NUM_COLUMNS = 4;

    JFrame frame = new JFrame();
    JButton[][] grid;

    public Fifteen() {
	grid(NUM_ROWS, NUM_COLUMNS);
    }

    public void grid(int rows, int columns) {
	frame.setLayout(new GridLayout(rows, columns));
	grid = new JButton[rows][columns];

	for(int col = 0; col < columns; col++) {
	    for(int row = 0; row < rows; row++) {
		grid[row][col] = new JButton("(" + row + ", " + col + ")");
		frame.add(grid[row][col]);
	    }
	}

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	Fifteen fifteen = new Fifteen();
    }
}