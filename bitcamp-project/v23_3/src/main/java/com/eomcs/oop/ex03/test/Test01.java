package com.eomcs.oop.ex03.test;

class Score {
   static int count;
   
   String name;
   int kor;
   int eng;
   int math;
   int sum;
   float aver;
      
       
    Score(String name, int kor, int eng, int math) {
      System.out.println("Score() - 2" );
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.compute();
      Score.increase();
   }
   
   
   static void increase() {
    Score.count++;  
   }
   
   void compute() {
     this.sum = this.kor + this.eng + this.math;
     this.aver = this.sum / 3f;
   }
}

public class Test01 {
  
  public static void main(String[] args) {
    Score s1 = new Score("홍길동",100,90,80);
    System.out.println("--------------");
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    s1.compute();
    
    
    Score s2 = new Score("임꺽정",90,80,70);         
    System.out.println("--------------");
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 70;
    s2.compute();
    
    
  }
}
   
   
   



   




