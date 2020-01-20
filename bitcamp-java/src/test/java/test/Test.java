package test;

public class Test {
  public static void main(String[] args) {
    Object obj = new String("Hello");

    String str = ((String) obj).toLowerCase();
    System.out.println(str);

  }
}

