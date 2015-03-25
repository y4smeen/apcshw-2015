import java.io.*;
import java.util.*;

//linked list iterator

public class LLit<E> implements Iterable {
  private Node t;
  public LLit(Node n) {
    t = n;
  }
}
