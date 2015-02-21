import java.io.*;
import java.util.*;

public class Fifteen2 {

  private String[][] board; // actual game board
  private int dim; // board dimension
  private int size = dim * dim; // total number of spaces on board
  private Random random = new Random();

  public Fifteen2() {
    dim = 4;
    board = new String[dim][dim];
    int num = 1;
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        if (num < 10) {
          board[x][y] = "0" + Integer.toString(num);
          num++;
        }
        else if (num > 9 && num < 16) {
          board[x][y] = Integer.toString(num);
          num++;
        }
        else {
          board[x][y] = "00";
        }
      }
    }
  }

  public String toString() {
    // String s = "[2J\n";
    String s = "\n";
    int count = 1;
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        s += board[x][y] + " ";
        if (count % 4 == 0) {
          s += "\n";
        }
        count++;
      }
    }
    return s;
  }

  public void shuffle() {
    for (int i = size; i > 1; i--) {
        exchange(i - 1, random.nextInt(i));
    }
  }

  public void exchange(int x, int y) {
    String temp = board[x / dim][x % dim];
    board[x / dim][x % dim] = board[y / dim][y % dim];
    board[y / dim][y % dim] = temp;
  }

  public static void main(String[] args) {
    Fifteen2 f = new Fifteen2();
    System.out.println(f);
    f.shuffle();
    System.out.println(f);
  }

}
