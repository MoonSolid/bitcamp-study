package study;

class Calculator {

  int result = 0; 

  public void plus(int value) {

    this.result += value;
    
  }

  public void minus(int value) {

    this.result -= value;
    
  }

  public void multiple(int value) {

    this.result *= value;
    
  }

  public void divide(int value) {

    this.result /= value;
    
  }
}
