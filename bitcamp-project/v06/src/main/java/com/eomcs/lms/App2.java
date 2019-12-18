package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int[] no = new int[100];
    String[] name = new String[100];
    String[] email = new String[100];
    String[] password = new String[100];
    String[] photo = new String[100];
    String[] tel = new String[100];
    Date[] registeredDate = new Date[100];

    int count = 0;

    for (int i = 0; i < 100; i++) {
      count ++;


      System.out.print("번호는? ");
      no[i] = keyboard.nextInt();

      keyboard.nextLine();

      System.out.print("이름은? ");
      name[i] = keyboard.nextLine();

      System.out.print("이메일은? ");
      email[i] = keyboard.nextLine();

      System.out.print("암호는? ");
      password[i] = keyboard.nextLine();

      System.out.print("사진는? ");
      photo[i] = keyboard.nextLine();

      System.out.print("전화는? ");
      tel[i] = keyboard.nextLine();

      
      registeredDate[i] = new Date(System.currentTimeMillis());

      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String answer = keyboard.nextLine();
      if (!answer.equalsIgnoreCase("y")) 
        break;
    }
      
    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      System.out.printf("%d,%s,%s,%s,%s\n",
          no[i],name[i],email[i],tel[i],registeredDate[i]);
      
    }
  }
}






