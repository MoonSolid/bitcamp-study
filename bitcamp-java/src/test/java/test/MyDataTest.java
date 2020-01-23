package test;

import java.util.ListIterator;
import java.util.Stack;

public class MyDataTest {
  public static void main(final String[] args) {
    Stack<String> s = new Stack<>();

    s.push("가");
    s.push("나");
    s.push("다");
    s.push("라");

    ListIterator<String> it = s.listIterator(s.size());

    while (it.hasPrevious()) {
      System.out.println(it.previous());
    }


  }
}


