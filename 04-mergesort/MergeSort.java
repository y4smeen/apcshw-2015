import java.util.Random;

public class MergeSort {

  public MergeSort() {
    Random rand = new Random();

  }

  ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
      ArrayList<Integer> merged = new ArrayList<Integer>();
      int ac = 0;// current index of arraylist a
      int bc = 0;// current index of arraylist b

      while (ac < ac.size()) {
        while (bc < b.size) {
          if (a.get(ac).compareTo(b.get(bc)) > 0) {
            merged.set(ac + bc, b.get(bc));
            bc++;
          }
        }
        merged.set(ac + bc, a.get(ac));
        ac++;
      }
      return merged;
  }

  public static void main(String[] args) {
    MergeSort m = new MergeSort();
  }
}
