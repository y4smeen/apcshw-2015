import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Fifteen2 {

  private String[][] board; // actual game board
  private List<String> numList = new ArrayList<String>();
  private int dim; // board dimension
  private int size = dim * dim; // total number of spaces on board
  private Random random = new Random();

  public Fifteen2() {
    dim = 4;
    board = new String[dim][dim];
    int num = 0;
    String numString = "";
    for (int y = 0; y < dim; y++) {
      for (int x = 0; x < dim; x++) {
        if (num == 0){
          numString = "00";
        }
        else if (num > 0 && num < 10) {
          numString = "0" + Integer.toString(num);
        }
        else {
          numString = Integer.toString(num);
        }
        board[x][y] = numString;
        numList.add(numString);
        num++;
      }
    }
  }

  public String toString() {
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
    Collections.shuffle(numList);
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        board[i][j] = numList.get(j + i * dim);
      }
    }
  }

  public static void main(String[] args) {
    Fifteen2 f = new Fifteen2();
    System.out.println(f);
    f.shuffle();
    System.out.println(f);
  }

}
