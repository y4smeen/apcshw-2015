import java.io.*;
import java.util.*;

public class Fifteen2 {

  private int[][] board; // actual game board
  private int dim; // board dimension

  public Fifteen2() {
    dim = 4;
    board = new int[dim][dim];
    int num = 1;
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        if (num < 16) {
          board[x][y] = num;
          num++;
        } else {
          board[x][y] = 0;
        }
      }
    }
  }

  public String toString() {
    String s = "[2J\n";
    int count = 1;
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        s += board[x][y];
        if (count % 4 == 0) {
          s += "\n";
        }
        count++;
      }
    }
    return s;
  }

  public static void main(String[] args) {
    Fifteen2 f = new Fifteen2();
    System.out.println(f);
  }

}
