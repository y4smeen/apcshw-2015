import java.util.*;

public class MergeSort {

  public MergeSort() {
    Random rand = new Random();
  }

  ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
      ArrayList<Integer> merged = new ArrayList<Integer>();
      //int ac = 0;// current index of arraylist a
      //int bc = 0;// current index of arraylist b

      for (int ac = 0; ac < a.size(); ac++) {
        for (int bc = 0; bc < b.size(); bc++) {
          if (a.get(ac).compareTo(b.get(bc)) > 0) {
            merged.set(ac + bc, b.get(bc));
          }
        }
        merged.set(ac + bc, a.get(ac));
      }
      return merged;
  }

  public static void main(String[] args) {
    MergeSort m = new MergeSort();
    ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(4,7,23,45,94,103));
    ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(1,5,6,9,18,27,36,45));

    System.out.println(m.merge(a, b));
  }
}
