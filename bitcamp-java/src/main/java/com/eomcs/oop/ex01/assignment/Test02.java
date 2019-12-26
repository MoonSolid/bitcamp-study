package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    
    
    class Score {
      String name;
      int kor;
      int eng;
      int math;
    }

    Score[] arr = new Score[3];
    
    for (int i = 0; i < arr.length; i++) {
      
      System.out.println("입력: ");
      
      Score s = new Score();
      
      s.name = keyboard.next();
      s.kor = keyboard.nextInt();
      s.eng = keyboard.nextInt();
      s.math = keyboard.nextInt();
      
          arr[i] = s;
    }
    
    for (int i = 0; i < arr.length; i++) {
      Score s = arr[i];
      int sum = s.kor + s.eng + s.math;
      float avar = sum / 3f ;
      System.out.printf("%s, %d, %d, %d ,%d , %d\n",s.name , s.kor , s.eng , s.math, sum , avar);
    }
    
    
    
    
    
      
  keyboard.close();
  
  }
}
