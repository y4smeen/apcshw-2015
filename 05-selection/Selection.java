public class Select {

  public int Smallest(int[] A) {
    int small = 0;
    if (A.length > 0) {
      small = A[0];
      for (int i = 0; i < A.length; i++) {
        if (A[i] < small) {
          small = A[i];
        }
      }
    }
    return small;
  }

  public int Select(int[] A, int k, int l, int h) {
    
  }

}
