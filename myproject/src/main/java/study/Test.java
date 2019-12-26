package study;

public class Test {

  public static void main(String[] args) {
    Calculator c = new Calculator();
    Calculator c2 = new Calculator();
    
    c.plus(2);
    
    c2.plus(3);
    c2.plus(3);
    
    System.out.printf("%d , %d ",c.result,c2.result);
  }
  
}
