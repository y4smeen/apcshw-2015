public class Trees {
  public int maxValue(Node T) {
      if (T == null) {
        return minValue(T);
      }
      else {
        max(maxValue(T.getLeft()))
      }
  }

  public int height(Node T) {
    if (T == null) {
      return 0;
    }
    else {
      return 1 + Math.max(height(T.getLeft()), height(T.getRight()));
    }
  }

  public void splitDupes(Node T) {

  }

  /* HEAP
  1. binary tree
  2. parent is smaller than either child
  3. as full as possible left to right
  */
  public longest(Node T) {
    if (T == null) {
      return 0;
    }
    int root = 1 + height(T.getLeft()) + height(T.getRight());
    int left = longest(T.getLeft());
    int right = longest(T.getRight());
    return Math.max(root, Math.max(left, right));
  }

  /* diameter: longest leaf-to-leaf path
  public int diameter(Node T) {
    if (T == null) {
      return 0;
    }
    else {
      PL1 = height(T.getLeft())+
        height(T.getRight()) +
        2;
      PL2 = diameter(T.getLeft());
      PL3 = diameter(T.getRight());
      return max(PL1, PL2, PL3);
    }
  }
  */
  /* Remove min
  1. pull off root
  2. move lowest rightest value to root
  3. pushdown(root)
      while node > either child
        swap w/smaller child
        and work down tree
  removemin/pushdown --> O(log n)
  heapsort --> O(n log n)
  findmin() --> O(1)
  insert --> O(log n)
  create --> O(n log n) (really it's O(n))

  given node n, n's children are at 2n, 2n+1
  parent int(n/2)
  */
  public numNodes(Node T) {
    if (T == null) {
      return 0;
    }
    else {
      return T.getVal() +
      numNodes(T.getLeft()) +
      numNodes(T.getRight());
    }
  }

}
