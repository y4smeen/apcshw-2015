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
      return 1 + height(maxValue(T.getLeft())) +
      height(maxValue(T.getRight()));
    }
  }

  public void splitDupes(Node T) {

  }

  // diameter: longest leaf-to-leaf path
  public int longest(Node T) {

  }

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
