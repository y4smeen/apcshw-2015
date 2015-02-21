import java.util.Arrays;

public class Fifteen1 {

    private int dimension = 4;
    private int[][] grid = new int[dimension][dimension];

    public Fifteen1() {
      gridMaker(grid);
    }

    public void gridMaker(int[][] array) {
      int number = 1;
      for (int col = 0; col < dimension; col++) {
        for (int row = 0; row < dimension; col++) {
          if (number < 16) {
            array[row][col] = number;
            number++;
          }
          else {
            array[row][col] = 0;
          }
        }
      }
    }

    public static void main(String[] args) {
      Fifteen1 fifteen = new Fifteen1();
      System.out.println(fifteen);
    }

}
