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
    int p = A[k];
    int Li = l
    int Hi = h - 1;
    int Pi;

    while (Li != Hi) {
      if(A[Li] < p) {
        Li++;
      }
      else {
        swap(A, A[Li], A[Hi]);
        Hi--;
      }
    }

    if (p > )


  }

  public int[] swap(int[] A, int i1, int i2) {
    int hold = A[i1];
    A[i1] = A[i2];
    A[i2] = hold;
    return A;
  }

}
