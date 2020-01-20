package test;

import java.util.function.BiFunction;

public class MyDataTest {
  public static void main(final String[] args) {

    BiFunction<Integer, Integer, Integer> f = (a, b) -> a > b ? a : b;
    System.out.println(f.apply(3, 10));

  }
}


