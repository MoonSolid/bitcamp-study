package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

public class Test01 {
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
      
      System.out.println("이름과 국어,영어,수학 점수를 입력하세요");
      
      Score s = new Score();
      
      s.name = keyboard.next();
      s.kor = keyboard.nextInt();
      s.eng = keyboard.nextInt();
      s.math = keyboard.nextInt();
      
      arr[i] = s;
      
    }
    
    
    keyboard.close();
    
    System.out.println("-----------------------------------");
    for (int i = 0; i < arr.length; i++) {
      Score s = arr[i];
      int sum = s.kor + s.eng + s.math;
      float aver = sum / 3f;
      System.out.printf("%s, %d, %d, %d, %d %.1f\n",s.name,s.kor,s.eng,s.math,sum,aver);
     
    }
    
    
    
    
    
    
    
    
  }
}
    
   /* 
    User[] date = new User[3];
    
    for (int i = 0; i < date.length; i++) {
      date[i] = new User();

    date[i].name = keyboard.next();
    date[i].kor = keyboard.nextInt();
    date[i].eng = keyboard.nextInt();
    date[i].math = keyboard.nextInt();
    date[i].sum = date[i].kor + date[i].eng + date[i].math;
    date[i].avar = date[i].sum / 3 ;
    
    
    }
    
    keyboard.close();
    */
    
    
    
   
    
  
  

